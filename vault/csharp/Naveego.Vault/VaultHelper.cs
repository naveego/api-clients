using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Logging.Abstractions;
using Newtonsoft.Json;
using Vault;
using Vault.Models;

namespace Metabase.Api.Vault
{
    public interface IVaultHelper : IVaultApi, IDisposable
    {
        Task<RenewingSecret<T>> GetRenewingSecret<T>(Func<IVaultApi, CancellationToken, Task<VaultResponse<T>>> getter, CancellationToken cancellationToken = default (CancellationToken));
        
    }

    public interface IVaultApi
    {
        Task<VaultResponse<T>> ReadAsync<T>(string path, CancellationToken cancellationToken = default (CancellationToken));
        Task<VaultResponse<T>> WriteAsync<T>(string path, object payload, CancellationToken cancellationToken = default (CancellationToken));
    }

    public class VaultHelperConfig
    {
        public VaultHelperConfig()
        {
            
        }
        
        public VaultHelperConfig(string address)
        {
            Address = address;
        }

        /// <summary>
        ///     Vault client to use. If not set, one will be created using <see cref="Address" />.
        /// </summary>
        public IVaultClient VaultClient { get; set; }

        public string Address { get; set; }
        
        public ILogger Logger { get; set; } = NullLogger.Instance;

        public List<ILoginStrategy> LoginStrategies { get; set; } = new List<ILoginStrategy>();

        public VaultHelperConfig UsingKubernetesLogin(string role, string mount = "auth/kubernetes")
        {
            LoginStrategies.Add(new KubernetesLoginStrategy
            {
                Role = role,
                Mount = mount
            });
            return this;
        }

        public VaultHelperConfig UsingTokenLogin(string token)
        {
            LoginStrategies.Add(new TokenLoginStrategy()
            {
                Token = token,
            });
            return this;
        }
    }

    public class VaultHelper : IVaultHelper
    {
        private readonly VaultHelperConfig _config;
        private readonly CancellationTokenSource _cts;
        private readonly IVaultClient _vaultClient;
        private readonly ILogger _logger;

        private VaultHelper(VaultHelperConfig config)
        {
            _config = config;
            _cts = new CancellationTokenSource();
            _logger = config.Logger;
            _vaultClient = config.VaultClient ?? new VaultClient(
                               new VaultOptions
                               {
                                   Address = config.Address
                               });
        }


        public static async Task<IVaultHelper> CreateAsync(VaultHelperConfig config)
        {
            var helper = new VaultHelper(config);

            await helper.StartAsync();

            return helper;
        }

        private async Task StartAsync()
        {
            try
            {
                VaultResponse<TokenData> secret = null;
                var errors = new Dictionary<string, string>();
                foreach (var strategy in _config.LoginStrategies)
                    try
                    {
                        secret = await strategy.LoginAsync(_vaultClient, _logger);
                        if (secret != null) break;
                        errors[strategy.ToString()] = "returned null";
                    }
                    catch (Exception ex)
                    {
                        errors[strategy.ToString()] = ex.ToString();
                    }

                if (secret?.Auth == null)
                {
                    var errorMessages = string.Join(";", errors.Select(x => $"{x.Key}:{x.Value}"));
                    throw new Exception($"All auth strategies failed (strategies were [{errorMessages}]).");
                }

                _logger.LogInformation("Authenticated to Vault.");

                _vaultClient.Token = secret.Auth.ClientToken;

#pragma warning disable 4014
                Task.Factory.StartNew(() => RunTokenRenewer(secret.Auth));
#pragma warning restore 4014
            }
            catch (Exception ex)
            {
                _logger.LogCritical(ex, "Could not create vault client.");
                throw;
            }
        }
        
        private async Task RunTokenRenewer(SecretAuth tokenData)
        {
            try
            {
                if (!tokenData.Renewable)
                {
                    if (tokenData.LeaseDuration == 0)
                        _logger.LogInformation("Auth token will live forever, not renewing.");
                    else
                        _logger.LogWarning(
                            $"Auth token is not renewable. It will expire in {tokenData.LeaseDuration} seconds.");

                    return;
                }

                _logger.LogDebug("Auth token renewal started.");

                // ReSharper disable once PossibleLossOfFraction
                var halflife = TimeSpan.FromSeconds(tokenData.LeaseDuration / 2);

                while (true)
                {
                    _logger.LogDebug("Ttl for auth token is {1} seconds, will renew in {2}.", tokenData.LeaseDuration, halflife);
                    await Task.Delay(halflife, _cts.Token);
                    _logger.LogDebug("Renewing auth token.");

                    await _vaultClient.Auth.Write<NoData>("token/renew-self");

                    _logger.LogDebug("Auth token renewed.");
                }
            }
            catch (TaskCanceledException)
            {
                _logger.LogInformation("Auth token renewal cancelled.");
            }
            catch (Exception ex)
            {
                _logger.LogCritical(ex, "Auth token renewal failed, application can no longer authenticate.");
                Environment.Exit(8200);
            }
        }

        public async Task<RenewingSecret<T>> GetRenewingSecret<T>(Func<IVaultApi, CancellationToken, Task<VaultResponse<T>>> getter, CancellationToken cancellationToken = default (CancellationToken))
        {
            var cts = CancellationTokenSource.CreateLinkedTokenSource(_cts.Token, cancellationToken);
            var secret = await getter(this, cts.Token);
            
            if (secret.Renewable)
            {
                // ReSharper disable once PossibleLossOfFraction
                var halflife = TimeSpan.FromSeconds(secret.LeaseDuration / 2);
                return new RenewingSecret<T>(secret.Data, _cts.Token, halflife, async (token) =>
                {
                    var renewedSecret = await getter(this, token);
                    return renewedSecret.Data;
                });
            }
            else
            {
                return new RenewingSecret<T>(secret.Data);
            }
        }

        public Task<VaultResponse<T>> ReadAsync<T>(string path, CancellationToken cancellationToken = default (CancellationToken))
        {
            return _vaultClient.Secret.Read<T>(path, cancellationToken);
        }

        public Task<VaultResponse<T>> WriteAsync<T>(string path, object payload, CancellationToken cancellationToken = default (CancellationToken))
        {
            return _vaultClient.Secret.Write<object, T>(path, payload, cancellationToken);
        }

        public void Dispose()
        {
            _cts?.Cancel();
            _cts?.Dispose();
        }
    }


    public class TokenData
    {
        [JsonProperty("accessor")] public string Accessor { get; set; }

        [JsonProperty("creation_time")] public int CreationTime { get; set; }

        [JsonProperty("creation_ttl")] public int CreationTtl { get; set; }

        [JsonProperty("display_name")] public string DisplayName { get; set; }

        [JsonProperty("entity_id")] public string EntityId { get; set; }

        [JsonProperty("expire_time")] public string ExpireTime { get; set; }

        [JsonProperty("explicit_max_ttl")] public int ExplicitMaxTtl { get; set; }

        [JsonProperty("id")] public string Id { get; set; }

        [JsonProperty("identity_policies")] public IList<string> IdentityPolicies { get; set; }

        [JsonProperty("issue_time")] public string IssueTime { get; set; }

        [JsonProperty("meta")] public Dictionary<string, string> Meta { get; set; }

        [JsonProperty("num_uses")] public int NumUses { get; set; }

        [JsonProperty("orphan")] public bool Orphan { get; set; }

        [JsonProperty("path")] public string Path { get; set; }

        [JsonProperty("policies")] public IList<string> Policies { get; set; }

        [JsonProperty("renewable")] public bool Renewable { get; set; }

        [JsonProperty("ttl")] public int Ttl { get; set; }
    }
}