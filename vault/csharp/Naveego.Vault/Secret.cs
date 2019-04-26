using System.Collections.Generic;
using Vault.Models;

namespace Metabase.Api.Vault
{
    public class Secret<T>
    {
        public string RequestId { get; set; }

        public string LeaseId { get; set; }

        public bool Renewable { get; set; }

        public int LeaseDuration { get; set; }

        public List<string> Warnings { get; set; }

        public T Data { get; set; }

        public SecretAuth Auth { get; set; }
        
        public Secret(){}

        internal Secret<T> FromResponse(VaultResponse<T> response)
        {
            if (response == null)
                return null;

            return new Secret<T>()
            {
                Data = response.Data,
                Auth = response.Auth == null
                    ? null
                    : new SecretAuth()
                    {
                        Accessor = response.Auth.Accessor,
                        Metadata = response.Auth.Metadata,
                        Policies = response.Auth.Policies,
                        Renewable = response.Auth.Renewable,
                        ClientToken = response.Auth.ClientToken,
                        LeaseDuration = response.Auth.LeaseDuration,
                    },
                Renewable = response.Renewable,
                LeaseId = response.LeaseId,
                LeaseDuration = response.LeaseDuration,
                Warnings = response.Warnings,
                RequestId = response.RequestId,
            };
        }

        public Secret<TOther> Rewrap<TOther>(TOther data)
        {
            return new Secret<TOther>()
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
}