using System;
using System.Collections.Generic;
using System.IO;
using System.Threading;
using System.Threading.Tasks;
using Vault;
using Vault.Models;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Logging.Abstractions;

namespace Metabase.Api.Vault
{
    public interface ILoginStrategy
    {
        Task<VaultResponse<TokenData>> LoginAsync(IVaultClient client, ILogger log, CancellationToken cancellationToken = default(CancellationToken));
    }

    public class KubernetesLoginStrategy : ILoginStrategy
    {
        private const string KubernetesTokenPath = "/var/run/secrets/kubernetes.io/serviceaccount/token";

        public string Role { get; set; }
        public string Mount { get; set; } = "auth/kubernetes";
        
        public async Task<VaultResponse<TokenData>> LoginAsync(IVaultClient client, ILogger log, CancellationToken cancellationToken = default(CancellationToken))
        {
            log = log ?? NullLogger.Instance;
            if (string.IsNullOrEmpty(this.Role))
            {
                throw new InvalidOperationException("Kubernetes service token found, but settings.KubernetesRole was empty.");
            }
            
            log.LogInformation("Found kubernetes service account token, will use it to authenticate to Vault.");
            var token = File.ReadAllText(KubernetesTokenPath);
            var kubeRequest = new Dictionary<string, string>()
            {
                ["role"] = this.Role,
                ["jwt"] = token,
            };

            var loginPath = $"{this.Mount.TrimEnd('/')}/login";
            
            try
            {
                var authResponse = await client.Secret.Write<Dictionary<string, string>, TokenData>(loginPath,kubeRequest);
                return authResponse;
            }
            catch (Exception ex)
            {
                throw new Exception($"Error logging in using kubernetes mount '{this.Mount}' and role '{this.Role}'.", ex);
            }
        }
    }
    
    public class TokenLoginStrategy : ILoginStrategy
    {
        public string Token { get; set; }
        
        public async Task<VaultResponse<TokenData>> LoginAsync(IVaultClient client, ILogger log, CancellationToken cancellationToken = default(CancellationToken))
        {
            client.Token = Token;

            var response = await client.Auth.Write<NoData, TokenData>("token/create", null, cancellationToken);

            return response;
        }
    }
}