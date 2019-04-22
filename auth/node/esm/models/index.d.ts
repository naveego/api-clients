import { ServiceClientOptions } from "@azure/ms-rest-js";
import * as msRest from "@azure/ms-rest-js";
/**
 * An interface representing DiscoveryKey.
 */
export interface DiscoveryKey {
    alg: string;
    e: string;
    kid: string;
    kty: string;
    n: string;
    use: string;
    x5c: string[];
    x5t: string;
}
/**
 * An interface representing DiscoveryKeys.
 */
export interface DiscoveryKeys {
    keys: DiscoveryKey[];
}
/**
 * An interface representing OauthToken.
 */
export interface OauthToken {
    accessToken: string;
    expiresIn: number;
    id: string;
    issuedAt: number;
    refreshToken?: string;
}
/**
 * An interface representing SamlGenerateRequestResponse.
 */
export interface SamlGenerateRequestResponse {
    relayState: string;
    samlRequest: string;
}
/**
 * An interface representing SamlSAMLSettings.
 */
export interface SamlSAMLSettings {
    assertionConsumerServiceUrl: string;
    id: string;
    idpPublicCertPath: string;
    idpSsoDecriptorUrl: string;
    idpSsoUrl: string;
}
/**
 * An interface representing TenantConfiguration.
 */
export interface TenantConfiguration {
    id: string;
    name: string;
    provider: string;
    providerSettings: string;
}
/**
 * An interface representing UserAuthCodeResponse.
 */
export interface UserAuthCodeResponse {
    code: string;
}
/**
 * An interface representing UserUser.
 */
export interface UserUser {
    attributes?: {
        [propertyName: string]: string;
    };
    createdOn?: string;
    id?: string;
    lastTouch?: string;
    modifiedOn?: string;
    status?: string;
    tenantId?: string;
    username?: string;
}
/**
 * An interface representing UserCreateUser.
 */
export interface UserCreateUser {
    user: UserUser;
}
/**
 * An interface representing AuthAPIOptions.
 */
export interface AuthAPIOptions extends ServiceClientOptions {
    baseUri?: string;
}
/**
 * Optional Parameters.
 */
export interface AuthAPITokenOptionalParams extends msRest.RequestOptionsBase {
    /**
     * The username used with grant_type=password
     */
    username?: string;
    /**
     * The password used with grant_type=password
     */
    password?: string;
    /**
     * The code to use with grant_type=authorization_code
     */
    code?: string;
    /**
     * The refresh token to use with grant_type=refresh_token
     */
    refreshToken?: string;
}
/**
 * Contains response data for the getConfiguration operation.
 */
export declare type GetConfigurationResponse = TenantConfiguration & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: TenantConfiguration;
    };
};
/**
 * Contains response data for the discoverKeys operation.
 */
export declare type DiscoverKeysResponse = DiscoveryKeys & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: DiscoveryKeys;
    };
};
/**
 * Contains response data for the token operation.
 */
export declare type TokenResponse = OauthToken & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: OauthToken;
    };
};
/**
 * Contains response data for the generateRequest1 operation.
 */
export declare type GenerateRequest1Response = SamlGenerateRequestResponse & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: SamlGenerateRequestResponse;
    };
};
/**
 * Contains response data for the getSAMLSettings operation.
 */
export declare type GetSAMLSettingsResponse = SamlSAMLSettings & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: SamlSAMLSettings;
    };
};
/**
 * Contains response data for the create operation.
 */
export declare type CreateResponse = UserUser & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: UserUser;
    };
};
/**
 * Contains response data for the get operation.
 */
export declare type GetResponse = UserUser & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: UserUser;
    };
};
/**
 * Contains response data for the update operation.
 */
export declare type UpdateResponse = UserUser & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: UserUser;
    };
};
/**
 * Contains response data for the generateAuthCode operation.
 */
export declare type GenerateAuthCodeResponse = UserAuthCodeResponse & {
    /**
     * The underlying HTTP response.
     */
    _response: msRest.HttpResponse & {
        /**
         * The response body as text (string format)
         */
        bodyAsText: string;
        /**
         * The response body as parsed JSON or XML
         */
        parsedBody: UserAuthCodeResponse;
    };
};
//# sourceMappingURL=index.d.ts.map