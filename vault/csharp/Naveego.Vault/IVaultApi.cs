using System.Threading;
using System.Threading.Tasks;
using Vault;

namespace Metabase.Api.Vault
{
    public interface IVaultApi
    {
        string Token { get; set; }
        Task<Secret<T>> ReadAsync<T>(string path, CancellationToken cancellationToken = default);
        Task<Secret<T>> WriteAsync<T>(string path, object payload = null, CancellationToken cancellationToken = default);
    }

    public class VaultApi : IVaultApi
    {
        private readonly IVaultClient _client;
        private string _token;

        public VaultApi(string address)
        {
            _client = new VaultClient(new VaultOptions {Address = address});
        }

        public string Token
        {
            get => _token;
            set
            {
                _token = value;
                _client.Token = value;
            }
        }

        public async Task<Secret<T>> ReadAsync<T>(string path, CancellationToken cancellationToken = default)
        {
            var response = await _client.Secret.Read<T>(path, cancellationToken);
            return Secret<T>.FromResponse(response);
        }

        public async Task<Secret<T>> WriteAsync<T>(string path, object payload, CancellationToken cancellationToken = default)
        {
            var result = await _client.Secret.Write<object, T>(path, payload, cancellationToken);
            return Secret<T>.FromResponse(result);
        }
    }
}