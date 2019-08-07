using System;
using System.Collections.Generic;
using System.IO;
using System.Threading;
using System.Threading.Tasks;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Logging.Abstractions;
using Newtonsoft.Json;

namespace Naveego.Vault
{
    /// <summary>
    ///     A login strategy will attempt to create an authenticated <see cref="IVaultApi" /> instance
    ///     and return it, along with the <see cref="SecretAuth" /> which should be renewed to keep the
    ///     instance's token valid.
    /// </summary>
    public interface ILoginStrategy
    {
        /// <summary>
        ///     Attempt to create an authenticated <see cref="IVaultApi" /> instance
        ///     and return it, along with the <see cref="SecretAuth" /> which should be renewed to keep the
        ///     instance's token valid. If the strategy cannot succeed, it should throw an exception with an explanation.
        /// </summary>
        /// <param name="url"></param>
        /// <param name="log"></param>
        /// <param name="cancellationToken"></param>
        /// <returns></returns>
        Task<LoginResult> LoginAsync(string url, ILogger log, CancellationToken cancellationToken = default);
    }

    public class LoginResult
    {
        public IVaultApi Client { get; set; }
        public SecretAuth SecretAuth { get; set; }
    }

    /// <summary>
    ///     A strategy which authenticates using kubernetes.
    /// </summary>
    public class KubernetesLoginStrategy : ILoginStrategy
    {
        private const string KubernetesTokenPath = "/var/run/secrets/kubernetes.io/serviceaccount/token";

        public string Role { get; set; }
        public string Mount { get; set; } = "auth/kubernetes";

        public async Task<LoginResult> LoginAsync(string url, ILogger log, CancellationToken cancellationToken = default)
        {
            log = log ?? NullLogger.Instance;
            if (string.IsNullOrEmpty(Role))
            {
                throw new InvalidOperationException("Kubernetes service token found, but settings.KubernetesRole was empty.");
            }

            if (!File.Exists(KubernetesTokenPath))
            {
                throw new InvalidOperationException("no file at kubernetes token path");
            }

            log.LogInformation("Found kubernetes service account token, will use it to authenticate to Vault.");
            var token = File.ReadAllText(KubernetesTokenPath);
            var kubeRequest = new Dictionary<string, string>
            {
                ["role"] = Role,
                ["jwt"] = token
            };

            var loginPath = $"{Mount.TrimEnd('/')}/login";

            try
            {
                var client = new VaultApi(url);
                var authResponse = await client.WriteAsync<Dictionary<string, object>>(loginPath, kubeRequest, cancellationToken);
                client.Token = authResponse.Auth.ClientToken;
                return new LoginResult
                {
                    SecretAuth = authResponse.Auth,
                    Client = client
                };
            }
            catch (Exception ex)
            {
                throw new Exception($"Error logging in using kubernetes mount '{Mount}' and role '{Role}'.", ex);
            }
        }
    }

    /// <summary>
    ///     A strategy which authenticates by creating a token which is based on the <see cref="Token" />.
    /// </summary>
    public class TokenLoginStrategy : ILoginStrategy
    {

        private class TokenLookupResponse
        {
            [JsonProperty("accessor")]
            public string Accessor { get; set; }
            [JsonProperty("id")]
            public string Id { get; set; }
            [JsonProperty("ttl")]
            public int Ttl { get; set; }
            [JsonProperty("renewable")]
            public bool Renewable { get; set; }
            [JsonProperty("policies")]
            public List<string> Policies { get; set; } = new List<string>();
            public Dictionary<string,string> Metadata { get; set; } = new Dictionary<string, string>();
        }
        
        public string Token { get; set; }

        public async Task<LoginResult> LoginAsync(string url, ILogger log, CancellationToken cancellationToken = default)
        {
            var client = new VaultApi(url);

            client.Token = Token;

            var response = await client.ReadAsync<TokenLookupResponse>("auth/token/lookup-self",  cancellationToken);
            if (response?.Data == null)
            {
                throw new Exception("Response or response.Data was null.");
            }

            var secretAuth = new SecretAuth
            {
                Accessor = response.Data.Accessor,
                ClientToken = response.Data.Id,
                LeaseDuration = response.Data.Ttl,
                Policies = response.Data.Policies,
                Metadata = response.Data.Metadata,
            };

            return new LoginResult
            {
                Client = client,
                SecretAuth = secretAuth
            };
        }
    }
}