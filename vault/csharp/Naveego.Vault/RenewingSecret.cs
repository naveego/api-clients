using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;
using Vault;
using Vault.Models;

namespace Metabase.Api.Vault
{
    public class RenewingSecret<T> : IDisposable
    {
        private readonly CancellationTokenSource _cts;
        private readonly Func<CancellationToken, Task<T>> _factory;
        private readonly TimeSpan _interval;
        private readonly Task _task;
        private Exception _error;
        private T _value;

        public RenewingSecret(T initialValue, CancellationToken token, TimeSpan interval, Func<CancellationToken, Task<T>> factory)
        {
            _value = initialValue;
            _cts = CancellationTokenSource.CreateLinkedTokenSource(token);
            _interval = interval;
            _factory = factory;
            _task = Task.Factory.StartNew(async () =>
            {
                try
                {
                    while (true)
                    {
                        await Task.Delay(interval, _cts.Token);
                        _value = await factory(_cts.Token);
                    }
                }
                catch (Exception ex)
                {
                    _error = new Exception($"Factory threw error at {DateTime.UtcNow}.", ex);
                }
            });
        }

        /// <summary>
        ///     Create a renewing secret that doesn't actually do any renewing.
        /// </summary>
        /// <param name="initialValue"></param>
        public RenewingSecret(T initialValue)
        {
            _value = initialValue;
        }

        public T Value => _error == null ? _value : throw _error;

        public void Dispose()
        {
            _cts?.Cancel();
            _cts?.Dispose();
        }
    }

    public static class RenewingFactories
    {
        private static readonly Regex SecretReferenceParser = new Regex(@"(?:^|\()vault:/?/?([^?)]+)(?:\?template=([^)]+))?(?:$|\))");

        private static readonly Regex TemplateReplacer = new Regex(@"\{\{\s*\.?([A-z]+)\s*\}\}");

        public static (Uri, bool) ParseSecretURI(string secretUri)
        {
            try
            {
                if (string.IsNullOrEmpty(secretUri)) return (null, false);

                var matches = SecretReferenceParser.Match(secretUri);
                if (!matches.Success) return (null, false);

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


        public static Func<IVaultClient, Task<VaultResponse<string>>> MakeRenderSecretTemplate(
            string stringWithEmbeddedSecrets)
        {
            var (uri, hasSecret) = ParseSecretURI(stringWithEmbeddedSecrets);

            if (!hasSecret)
                return client => Task.FromResult(new VaultResponse<string>
                {
                    Data = stringWithEmbeddedSecrets
                });

            return async client =>
            {
                string formattedSecret;
                VaultResponse<Dictionary<string, string>> secret;

                try
                {
                    secret = await client.Secret.Read<Dictionary<string, string>>(uri.AbsolutePath);
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
                            .ToDictionary(q => q.FirstOrDefault(), q => q.Skip(1).FirstOrDefault());

                        if (!query.TryGetValue("template", out var template))
                            throw new ArgumentException(
                                $"Secret embedded in string {stringWithEmbeddedSecrets} had multiple keys, but no template was provided.");

                        formattedSecret = TemplateReplacer.Replace(template, m =>
                        {
                            var token = m.Groups[1].Value;
                            if (secret.Data.TryGetValue(token, out var value)) return value;

                            throw new ArgumentOutOfRangeException(
                                $"The template for secret reference '{stringWithEmbeddedSecrets}' referenced a key '{token}' which was not in the secret.");
                        });
                        break;
                }

                var final = SecretReferenceParser.Replace(stringWithEmbeddedSecrets, formattedSecret);

                var finalResponse = new VaultResponse<string>
                {
                    Data = final,
                    Renewable = secret.Renewable,
                    LeaseDuration = secret.LeaseDuration,
                    Auth = secret.Auth,
                    Warnings = secret.Warnings,
                    LeaseId = secret.LeaseId,
                    RequestId = secret.RequestId
                };

                return finalResponse;
            };
        }
    }
}