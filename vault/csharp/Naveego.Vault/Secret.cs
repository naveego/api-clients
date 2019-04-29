using System.Collections.Generic;
using Vault.Models;

namespace Metabase.Api.Vault
{
    /// <summary>
    ///     Represents the case where no data is expected back from the API.
    /// </summary>
    public class NoData
    {
    }

    public class Secret<T>
    {
        public string RequestId { get; set; }

        public string LeaseId { get; set; }

        public bool Renewable { get; set; }

        public int LeaseDuration { get; set; }

        public List<string> Warnings { get; set; }

        public T Data { get; set; }

        public SecretAuth Auth { get; set; }

        internal static Secret<T> FromResponse(VaultResponse<T> response)
        {
            if (response == null)
            {
                return null;
            }

            return new Secret<T>
            {
                Data = response.Data,
                Auth = response.Auth == null
                    ? null
                    : new SecretAuth
                    {
                        Accessor = response.Auth.Accessor,
                        Metadata = response.Auth.Metadata,
                        Policies = response.Auth.Policies,
                        Renewable = response.Auth.Renewable,
                        ClientToken = response.Auth.ClientToken,
                        LeaseDuration = response.Auth.LeaseDuration
                    },
                Renewable = response.Renewable,
                LeaseId = response.LeaseId,
                LeaseDuration = response.LeaseDuration,
                Warnings = response.Warnings,
                RequestId = response.RequestId
            };
        }

        /// <summary>
        ///     Returns a new secret with the new <paramref name="data" />
        ///     and a shallow copy of all other properties.
        /// </summary>
        /// <param name="data"></param>
        /// <typeparam name="TOther"></typeparam>
        /// <returns></returns>
        public Secret<TOther> ReWrap<TOther>(TOther data)
        {
            return new Secret<TOther>
            {
                Data = data,
                Renewable = Renewable,
                LeaseDuration = LeaseDuration,
                Auth = Auth,
                Warnings = Warnings,
                LeaseId = LeaseId,
                RequestId = RequestId
            };
        }
    }


    public class SecretAuth
    {
        public string ClientToken { get; set; }
        public string Accessor { get; set; }
        public List<string> Policies { get; set; }
        public Dictionary<string, string> Metadata { get; set; }
        public int LeaseDuration { get; set; }
        public bool Renewable { get; set; }
    }
}