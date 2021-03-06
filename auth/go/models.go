package

// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

import (
    "encoding/json"
    "github.com/Azure/go-autorest/autorest"
)

// The package's fully qualified name.
const fqdn = "go"

            // DiscoveryKeysType ...
            type DiscoveryKeysType struct {
            autorest.Response `json:"-"`
            Keys *[]DiscoveryKeyType `json:"keys,omitempty"`
            }

            // DiscoveryKeyType ...
            type DiscoveryKeyType struct {
            Alg *string `json:"alg,omitempty"`
            E *string `json:"e,omitempty"`
            Kid *string `json:"kid,omitempty"`
            Kty *string `json:"kty,omitempty"`
            N *string `json:"n,omitempty"`
            Use *string `json:"use,omitempty"`
            X5c *[]string `json:"x5c,omitempty"`
            X5t *string `json:"x5t,omitempty"`
            }

            // OauthTokenType ...
            type OauthTokenType struct {
            autorest.Response `json:"-"`
            AccessToken *string `json:"access_token,omitempty"`
            ExpiresIn *int32 `json:"expires_in,omitempty"`
            ID *string `json:"id,omitempty"`
            IssuedAt *int64 `json:"issued_at,omitempty"`
            RefreshToken *string `json:"refresh_token,omitempty"`
            }

            // SamlGenerateRequestResponseType ...
            type SamlGenerateRequestResponseType struct {
            autorest.Response `json:"-"`
            RelayState *string `json:"relay_state,omitempty"`
            SamlRequest *string `json:"saml_request,omitempty"`
            }

            // SamlSAMLSettingsType ...
            type SamlSAMLSettingsType struct {
            autorest.Response `json:"-"`
            AssertionConsumerServiceURL *string `json:"assertion_consumer_service_url,omitempty"`
            ID *string `json:"id,omitempty"`
            IdpPublicCertPath *string `json:"idp_public_cert_path,omitempty"`
            IdpSsoDecriptorURL *string `json:"idp_sso_decriptor_url,omitempty"`
            IdpSsoURL *string `json:"idp_sso_url,omitempty"`
            }

            // TenantConfigurationType ...
            type TenantConfigurationType struct {
            autorest.Response `json:"-"`
            ID *string `json:"id,omitempty"`
            Name *string `json:"name,omitempty"`
            Provider *string `json:"provider,omitempty"`
            ProviderSettings *string `json:"provider_settings,omitempty"`
            }

            // UserAuthCodeResponseType ...
            type UserAuthCodeResponseType struct {
            autorest.Response `json:"-"`
            Code *string `json:"code,omitempty"`
            }

            // UserCreateUserType ...
            type UserCreateUserType struct {
            User *UserUserType `json:"User,omitempty"`
            }

            // UserLoginRequestType ...
            type UserLoginRequestType struct {
            Password *string `json:"password,omitempty"`
            Username *string `json:"username,omitempty"`
            }

            // UserLoginResponseType ...
            type UserLoginResponseType struct {
            autorest.Response `json:"-"`
            AuthCode *string `json:"auth_code,omitempty"`
            Message *string `json:"message,omitempty"`
            RedirectURI *string `json:"redirect_uri,omitempty"`
            Success *bool `json:"success,omitempty"`
            }

            // UserUserType ...
            type UserUserType struct {
            autorest.Response `json:"-"`
            Attributes map[string]*string `json:"attributes"`
            CreatedOn *string `json:"created_on,omitempty"`
            ID *string `json:"id,omitempty"`
            LastTouch *string `json:"last_touch,omitempty"`
            ModifiedOn *string `json:"modified_on,omitempty"`
            Status *string `json:"status,omitempty"`
            TenantID *string `json:"tenant_id,omitempty"`
            Username *string `json:"username,omitempty"`
            }

        // MarshalJSON is the custom marshaler for UserUserType.
        func (uut UserUserType)MarshalJSON() ([]byte, error){
        objectMap := make(map[string]interface{})
                if(uut.Attributes != nil) {
                objectMap["attributes"] = uut.Attributes
                }
                if(uut.CreatedOn != nil) {
                objectMap["created_on"] = uut.CreatedOn
                }
                if(uut.ID != nil) {
                objectMap["id"] = uut.ID
                }
                if(uut.LastTouch != nil) {
                objectMap["last_touch"] = uut.LastTouch
                }
                if(uut.ModifiedOn != nil) {
                objectMap["modified_on"] = uut.ModifiedOn
                }
                if(uut.Status != nil) {
                objectMap["status"] = uut.Status
                }
                if(uut.TenantID != nil) {
                objectMap["tenant_id"] = uut.TenantID
                }
                if(uut.Username != nil) {
                objectMap["username"] = uut.Username
                }
                return json.Marshal(objectMap)
        }

