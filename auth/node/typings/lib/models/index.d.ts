import * as msRest from "ms-rest-js";
/**
 * @interface
 * An interface representing DiscoveryKey.
 */
export interface DiscoveryKey {
    /**
     * @member {string} alg
     */
    alg: string;
    /**
     * @member {string} e
     */
    e: string;
    /**
     * @member {string} kid
     */
    kid: string;
    /**
     * @member {string} kty
     */
    kty: string;
    /**
     * @member {string} n
     */
    n: string;
    /**
     * @member {string} use
     */
    use: string;
    /**
     * @member {string[]} x5c
     */
    x5c: string[];
    /**
     * @member {string} x5t
     */
    x5t: string;
}
/**
 * @interface
 * An interface representing DiscoveryKeys.
 */
export interface DiscoveryKeys {
    /**
     * @member {DiscoveryKey[]} keys
     */
    keys: DiscoveryKey[];
}
/**
 * @interface
 * An interface representing OauthToken.
 */
export interface OauthToken {
    /**
     * @member {string} accessToken
     */
    accessToken: string;
    /**
     * @member {number} expiresIn
     */
    expiresIn: number;
    /**
     * @member {string} id
     */
    id: string;
    /**
     * @member {number} issuedAt
     */
    issuedAt: number;
    /**
     * @member {string} [refreshToken]
     */
    refreshToken?: string;
}
/**
 * @interface
 * An interface representing SamlGenerateRequestResponse.
 */
export interface SamlGenerateRequestResponse {
    /**
     * @member {string} relayState
     */
    relayState: string;
    /**
     * @member {string} samlRequest
     */
    samlRequest: string;
}
/**
 * @interface
 * An interface representing SamlSAMLSettings.
 */
export interface SamlSAMLSettings {
    /**
     * @member {string} assertionConsumerServiceUrl
     */
    assertionConsumerServiceUrl: string;
    /**
     * @member {string} id
     */
    id: string;
    /**
     * @member {string} idpPublicCertPath
     */
    idpPublicCertPath: string;
    /**
     * @member {string} idpSsoDecriptorUrl
     */
    idpSsoDecriptorUrl: string;
    /**
     * @member {string} idpSsoUrl
     */
    idpSsoUrl: string;
}
/**
 * @interface
 * An interface representing TenantConfiguration.
 */
export interface TenantConfiguration {
    /**
     * @member {string} id
     */
    id: string;
    /**
     * @member {string} name
     */
    name: string;
    /**
     * @member {string} provider
     */
    provider: string;
    /**
     * @member {string} providerSettings
     */
    providerSettings: string;
}
/**
 * @interface
 * An interface representing UserAuthCodeResponse.
 */
export interface UserAuthCodeResponse {
    /**
     * @member {string} code
     */
    code: string;
}
/**
 * @interface
 * An interface representing UserUser.
 */
export interface UserUser {
    /**
     * @member {{ [propertyName: string]: string }} [attributes]
     */
    attributes?: {
        [propertyName: string]: string;
    };
    /**
     * @member {string} [createdOn]
     */
    createdOn?: string;
    /**
     * @member {string} [id]
     */
    id?: string;
    /**
     * @member {string} [lastTouch]
     */
    lastTouch?: string;
    /**
     * @member {string} [modifiedOn]
     */
    modifiedOn?: string;
    /**
     * @member {string} [status]
     */
    status?: string;
    /**
     * @member {string} [tenantId]
     */
    tenantId?: string;
    /**
     * @member {string} [username]
     */
    username?: string;
}
/**
 * @interface
 * An interface representing UserCreateUser.
 */
export interface UserCreateUser {
    /**
     * @member {UserUser} user
     */
    user: UserUser;
}
/**
 * @interface
 * An interface representing AuthAPITokenOptionalParams.
 * Optional Parameters.
 *
 * @extends RequestOptionsBase
 */
export interface AuthAPITokenOptionalParams extends msRest.RequestOptionsBase {
    /**
     * @member {string} [username] The username used with grant_type=password
     */
    username?: string;
    /**
     * @member {string} [password] The password used with grant_type=password
     */
    password?: string;
    /**
     * @member {string} [code] The code to use with grant_type=authorization_code
     */
    code?: string;
    /**
     * @member {string} [refreshToken] The refresh token to use with
     * grant_type=refresh_token
     */
    refreshToken?: string;
}
