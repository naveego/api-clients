using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;

namespace Naveego.Vault
{
    public static class SecretGetters
    {
        private static readonly Regex SecretReferenceParser = new Regex(@"(?:^|\()vault:/?/?([^?)]+)(?:\?template=([^)]+))?(?:$|\))");

        private static readonly Regex TemplateReplacer = new Regex(@"\{\{\s*\.?([A-z]+)\s*\}\}");


        private static (Uri, bool) ParseSecretURI(string secretUri)
        {
            try
            {
                if (string.IsNullOrEmpty(secretUri))
                {
                    return (null, false);
                }

                var matches = SecretReferenceParser.Match(secretUri);
                if (!matches.Success)
                {
                    return (null, false);
                }

                var path = matches.Groups[0].Value?
                    .Trim('(', ')')
                    .Replace("vault://", "vault:");

                var url = new Uri(path);


                return (url, true);
            }
            catch (Exception ex)
            {
                throw new ArgumentException($"Invalid secretURI {secretUri}", ex);
            }
        }


        public static Func<IVaultApi, CancellationToken, Task<Secret<string>>> MakeJwtGetter(string role, TimeSpan ttl, string tenantID, string sub, Dictionary<string, object> claims = null)
        {
            claims = new Dictionary<string, object>(claims ?? new Dictionary<string, object>());
            claims["tid"] = tenantID;
            claims["sub"] = sub;
            return MakeJwtGetter(role, ttl, claims);
        }

        public static Func<IVaultApi, CancellationToken, Task<Secret<string>>> MakeJwtGetter(string role, TimeSpan ttl, Dictionary<string, object> claims = null)
        {
            claims = new Dictionary<string, object>(claims ?? new Dictionary<string, object>());

            return async (client, cancellationToken) =>
            {
                try
                {
                    var path = $"jose/jwt/issue/{role}";
                    claims["exp"] = DateTimeOffset.Now.Add(ttl).ToUnixTimeSeconds();

                    var req = new Dictionary<string, object>
                    {
                        ["token_ttl"] = ttl.TotalSeconds,
                        ["claims"] = claims
                    };

                    var secret = await client.WriteAsync<Dictionary<string, string>>(path, req, cancellationToken);

                    if (secret?.Data == null)
                    {
                        throw new Exception("Secret contained no data.");
                    }

                    if (!secret.Data.TryGetValue("token", out var token))
                    {
                        throw new Exception("Secret did not contain token.");
                    }

                    return secret.ReWrap(token);
                }
                catch (Exception ex)
                {
                    throw new Exception($"Error creating JWT using role '{role}'.", ex);
                }
            };
        }

        /// <summary>
        ///     The getter returned by this method will resolve an embedded template by pulling values from a vault secret.
        ///     An example of an embedded template:
        ///     <code>
        /// mongodb://(vault://database/creds/mongodb-admin?template={{.username}}:{{.password}})@mongodb:27017/go-between?readPreference=primary
        /// </code>
        ///     The vault secret will be read from database/creds/mongodb-admin, then the "username" and "password"
        ///     values from the secret will be formatted using the template. Finally, the entire (vault:...) token
        ///     will be replaced with the result of the formatting. If the username and password were "user" and "pass",
        ///     the result would be:
        ///     <code>
        /// mongodb://user:pass@mongodb:27017/go-between?readPreference=primary
        /// </code>
        /// </summary>
        /// <param name="stringWithEmbeddedSecrets"></param>
        /// <returns></returns>
        /// <exception cref="Exception"></exception>
        /// <exception cref="ArgumentException"></exception>
        /// <exception cref="ArgumentOutOfRangeException"></exception>
        public static Func<IVaultApi, CancellationToken, Task<Secret<string>>> MakeSecretTemplateGetter(string stringWithEmbeddedSecrets)
        {
            var (uri, hasSecret) = ParseSecretURI(stringWithEmbeddedSecrets);

            if (!hasSecret)
            {
                return (client, token) => Task.FromResult(new Secret<string>
                {
                    Data = stringWithEmbeddedSecrets
                });
            }

            return async (client, cancellationToken) =>
            {
                string formattedSecret;
                Secret<Dictionary<string, string>> secret;

                try
                {
                    secret = await client.ReadAsync<Dictionary<string, string>>(uri.AbsolutePath, cancellationToken);
                }
                catch (Exception ex)
                {
                    throw new Exception($"Error resolving embedded secret in '{stringWithEmbeddedSecrets}'", ex);
                }

                switch (secret.Data.Count)
                {
                    case 0:
                        throw new Exception($"Secret embedded in template '{stringWithEmbeddedSecrets}' was empty.");
                    case 1:
                        formattedSecret = secret.Data.Values.First();
                        break;
                    default:
                        var query = uri.Query
                            .Substring(1) // Remove '?'
                            .Split('&')
                            .Select(q => q.Split('='))
                            .ToDictionary(q => q.FirstOrDefault(), q => Uri.UnescapeDataString(q.Skip(1).FirstOrDefault() ?? ""));

                        if (!query.TryGetValue("template", out var template))
                        {
                            throw new ArgumentException(
                                $"Secret embedded in string {stringWithEmbeddedSecrets} had multiple keys, but no template was provided.");
                        }

                        formattedSecret = TemplateReplacer.Replace(template, m =>
                        {
                            var token = m.Groups[1].Value;
                            if (secret.Data.TryGetValue(token, out var value))
                            {
                                return value;
                            }

                            throw new ArgumentOutOfRangeException(
                                $"The template for secret reference '{stringWithEmbeddedSecrets}' referenced a key '{token}' which was not in the secret.");
                        });
                        break;
                }

                var final = SecretReferenceParser.Replace(stringWithEmbeddedSecrets, formattedSecret);

                return secret.ReWrap(final);
            };
        }
    }
}