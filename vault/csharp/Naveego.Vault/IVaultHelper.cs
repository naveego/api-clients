using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Logging.Abstractions;
using Newtonsoft.Json;
using Vault.Models;

namespace Metabase.Api.Vault
{
    public interface IVaultHelper : IVaultApi, IDisposable
    {
        /// <summary>
        /// Gets a secret using the provided secret getter.
        /// </summary>
        /// <param name="getter"></param>
        /// <param name="cancellationToken"></param>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        Task<T> GetSecretAsync<T>(Func<IVaultApi, CancellationToken, Task<Secret<T>>> getter, CancellationToken cancellationToken = default(CancellationToken));

        /// <summary>
        /// Gets a new <see cref="LiveSecret{T}"/> which will be acquired and renewed using the <paramref name="getter"/>.
        /// </summary>
        /// <param name="label">Used to prefix log messages and errors related to this secret.</param>
        /// <param name="getter"></param>
        /// <param name="cancellationToken"></param>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        Task<LiveSecret<T>> GetRenewingSecretAsync<T>(string label, Func<IVaultApi, CancellationToken, Task<Secret<T>>> getter, CancellationToken cancellationToken = default(CancellationToken));
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
        private IVaultApi _api;
        private readonly ILogger _logger;
      

        private VaultHelper(VaultHelperConfig config)
        {
            _config = config;
            _cts = new CancellationTokenSource();
            _logger = config.Logger;
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
                LoginResult loginResult = null;
                var errors = new Dictionary<string, string>();
                foreach (var strategy in _config.LoginStrategies)
                    try
                    {
                        loginResult = await strategy.LoginAsync(_config.Address, _logger);
                        if (loginResult != null) break;
                        errors[strategy.ToString()] = "returned null";
                    }
                    catch (Exception ex)
                    {
                        errors[strategy.ToString()] = ex.ToString();
                    }

                if (loginResult?.SecretAuth == null)
                {
                    var errorMessages = string.Join(";", errors.Select(x => $"{x.Key}:{x.Value}"));
                    throw new Exception($"All auth strategies failed (strategies were [{errorMessages}]).");
                }

                _logger.LogInformation("Authenticated to Vault.");

                _api = loginResult.Client;

#pragma warning disable 4014
                Task.Factory.StartNew(() => RunTokenRenewer(loginResult.SecretAuth));
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

                    await _api.WriteAsync<NoData>("auth/token/renew-self");

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

        public async Task<T> GetSecretAsync<T>(Func<IVaultApi, CancellationToken, Task<Secret<T>>> getter, CancellationToken cancellationToken = default(CancellationToken))
        {
            var cts = CancellationTokenSource.CreateLinkedTokenSource(_cts.Token, cancellationToken);
            var secret = await getter(this, cts.Token);
            return secret.Data;
        }

        public async Task<LiveSecret<T>> GetRenewingSecretAsync<T>(string label, Func<IVaultApi, CancellationToken, Task<Secret<T>>> getter, CancellationToken cancellationToken = default(CancellationToken))
        {
            var cts = CancellationTokenSource.CreateLinkedTokenSource(_cts.Token, cancellationToken);
            var secret = await getter(this, cts.Token);

            if (secret.Renewable)
            {
                // If the lease is renewable, the renewal action is to renew the lease and return
                // the original value provided by the getter.
                var halflife = TimeSpan.FromSeconds(secret.LeaseDuration / 2.0);
                return new LiveSecret<T>(label, secret.Data, _cts.Token, halflife, async (token) =>
                {
                    _logger.LogDebug($"Renewing lease for secret with label '{label}'.");
                    await _api.WriteAsync<NoData>("sys/lease/renew", new Dictionary<string,string>{["lease_id"] = secret.LeaseId}, token);
                    return secret.Data;
                });
            }
            else if (secret.LeaseDuration == 0)
            {
                _logger.LogDebug($"Lease for secret with label '{label}' will never expire, no renewal work to do.");
                return new LiveSecret<T>(secret.Data);
            }
            else
            {
                // If the lease is not renewable, the only way to keep the secret fresh is to re-invoke the getter.
                var halflife = TimeSpan.FromSeconds(secret.LeaseDuration / 2.0);
                return new LiveSecret<T>(label, secret.Data, _cts.Token, halflife, async (token) =>
                {
                    _logger.LogDebug($"Re-acquiring secret with label '{label}'.");
                    var renewedSecret = await getter(this, token);
                    return renewedSecret.Data;
                });
            }
        }


        public string Token
        {
            get => _api.Token;
            set => _api.Token = value;
        }

        public Task<Secret<T>> ReadAsync<T>(string path, CancellationToken cancellationToken = default(CancellationToken)) => _api.ReadAsync<T>(path, cancellationToken);

        public Task<Secret<T>> WriteAsync<T>(string path, object payload, CancellationToken cancellationToken = default(CancellationToken)) => _api.WriteAsync<T>(path, payload, cancellationToken);

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