import * as msRest from "@azure/ms-rest-js";
import * as Models from "./models";
import * as Mappers from "./models/mappers";
import { AuthAPIContext } from "./authAPIContext";
declare class AuthAPI extends AuthAPIContext {
    /**
     * Initializes a new instance of the AuthAPI class.
     * @param credentials Subscription credentials which uniquely identify client subscription.
     * @param [options] The parameter options
     */
    constructor(credentials: msRest.ServiceClientCredentials, options?: Models.AuthAPIOptions);
    /**
     * @summary get the configuration for a tenant
     * @param tenantId The tenant id
     * @param [options] The optional parameters
     * @returns Promise<Models.GetConfigurationResponse>
     */
    getConfiguration(tenantId: string, options?: msRest.RequestOptionsBase): Promise<Models.GetConfigurationResponse>;
    /**
     * @param tenantId The tenant id
     * @param callback The callback
     */
    getConfiguration(tenantId: string, callback: msRest.ServiceCallback<Models.TenantConfiguration>): void;
    /**
     * @param tenantId The tenant id
     * @param options The optional parameters
     * @param callback The callback
     */
    getConfiguration(tenantId: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.TenantConfiguration>): void;
    /**
     * @summary get jwks for key validation
     * @param [options] The optional parameters
     * @returns Promise<Models.DiscoverKeysResponse>
     */
    discoverKeys(options?: msRest.RequestOptionsBase): Promise<Models.DiscoverKeysResponse>;
    /**
     * @param callback The callback
     */
    discoverKeys(callback: msRest.ServiceCallback<Models.DiscoveryKeys>): void;
    /**
     * @param options The optional parameters
     * @param callback The callback
     */
    discoverKeys(options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.DiscoveryKeys>): void;
    /**
     * @summary Oauth2 authorize endpoint
     * @param [options] The optional parameters
     * @returns Promise<msRest.RestResponse>
     */
    authorize(options?: msRest.RequestOptionsBase): Promise<msRest.RestResponse>;
    /**
     * @param callback The callback
     */
    authorize(callback: msRest.ServiceCallback<void>): void;
    /**
     * @param options The optional parameters
     * @param callback The callback
     */
    authorize(options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<void>): void;
    /**
     * @summary Oauth2 token endpoint
     * @param grantType The grant_type to use for obtaining a token
     * @param [options] The optional parameters
     * @returns Promise<Models.TokenResponse>
     */
    token(grantType: string, options?: Models.AuthAPITokenOptionalParams): Promise<Models.TokenResponse>;
    /**
     * @param grantType The grant_type to use for obtaining a token
     * @param callback The callback
     */
    token(grantType: string, callback: msRest.ServiceCallback<Models.OauthToken>): void;
    /**
     * @param grantType The grant_type to use for obtaining a token
     * @param options The optional parameters
     * @param callback The callback
     */
    token(grantType: string, options: Models.AuthAPITokenOptionalParams, callback: msRest.ServiceCallback<Models.OauthToken>): void;
    /**
     * @summary Redirects user back to target login endpoint
     * @param tid The tenant id for this request
     * @param sAMLResponse The SAML AuthNResponse from the Identity Provider
     * @param relayState The relay state obtained from generate request process
     * @param [options] The optional parameters
     * @returns Promise<msRest.RestResponse>
     */
    generateRequest(tid: string, sAMLResponse: string, relayState: string, options?: msRest.RequestOptionsBase): Promise<msRest.RestResponse>;
    /**
     * @param tid The tenant id for this request
     * @param sAMLResponse The SAML AuthNResponse from the Identity Provider
     * @param relayState The relay state obtained from generate request process
     * @param callback The callback
     */
    generateRequest(tid: string, sAMLResponse: string, relayState: string, callback: msRest.ServiceCallback<void>): void;
    /**
     * @param tid The tenant id for this request
     * @param sAMLResponse The SAML AuthNResponse from the Identity Provider
     * @param relayState The relay state obtained from generate request process
     * @param options The optional parameters
     * @param callback The callback
     */
    generateRequest(tid: string, sAMLResponse: string, relayState: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<void>): void;
    /**
     * @summary Generates a SAML request
     * @param tid The tenant id for this request
     * @param clientId The Oauth2 client_id that is making the reqeust
     * @param [options] The optional parameters
     * @returns Promise<Models.GenerateRequest1Response>
     */
    generateRequest1(tid: string, clientId: string, options?: msRest.RequestOptionsBase): Promise<Models.GenerateRequest1Response>;
    /**
     * @param tid The tenant id for this request
     * @param clientId The Oauth2 client_id that is making the reqeust
     * @param callback The callback
     */
    generateRequest1(tid: string, clientId: string, callback: msRest.ServiceCallback<Models.SamlGenerateRequestResponse>): void;
    /**
     * @param tid The tenant id for this request
     * @param clientId The Oauth2 client_id that is making the reqeust
     * @param options The optional parameters
     * @param callback The callback
     */
    generateRequest1(tid: string, clientId: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.SamlGenerateRequestResponse>): void;
    /**
     * @summary Gets the SAML settings for this tenant
     * @param tid The tenant id for this request
     * @param [options] The optional parameters
     * @returns Promise<Models.GetSAMLSettingsResponse>
     */
    getSAMLSettings(tid: string, options?: msRest.RequestOptionsBase): Promise<Models.GetSAMLSettingsResponse>;
    /**
     * @param tid The tenant id for this request
     * @param callback The callback
     */
    getSAMLSettings(tid: string, callback: msRest.ServiceCallback<Models.SamlSAMLSettings>): void;
    /**
     * @param tid The tenant id for this request
     * @param options The optional parameters
     * @param callback The callback
     */
    getSAMLSettings(tid: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.SamlSAMLSettings>): void;
    /**
     * @summary Create a user.
     * @param body
     * @param [options] The optional parameters
     * @returns Promise<Models.CreateResponse>
     */
    create(body: Models.UserCreateUser, options?: msRest.RequestOptionsBase): Promise<Models.CreateResponse>;
    /**
     * @param body
     * @param callback The callback
     */
    create(body: Models.UserCreateUser, callback: msRest.ServiceCallback<Models.UserUser>): void;
    /**
     * @param body
     * @param options The optional parameters
     * @param callback The callback
     */
    create(body: Models.UserCreateUser, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.UserUser>): void;
    /**
     * @summary Provides a login endpoint that can generate an auth code for the user given valid user
     * credentials.
     * @param body
     * @param [options] The optional parameters
     * @returns Promise<Models.LoginUserResponse>
     */
    loginUser(body: Models.UserLoginRequest, options?: msRest.RequestOptionsBase): Promise<Models.LoginUserResponse>;
    /**
     * @param body
     * @param callback The callback
     */
    loginUser(body: Models.UserLoginRequest, callback: msRest.ServiceCallback<Models.UserLoginResponse>): void;
    /**
     * @param body
     * @param options The optional parameters
     * @param callback The callback
     */
    loginUser(body: Models.UserLoginRequest, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.UserLoginResponse>): void;
    /**
     * @summary Gets a user.
     * @param userId identifier of the user
     * @param [options] The optional parameters
     * @returns Promise<Models.GetResponse>
     */
    get(userId: string, options?: msRest.RequestOptionsBase): Promise<Models.GetResponse>;
    /**
     * @param userId identifier of the user
     * @param callback The callback
     */
    get(userId: string, callback: msRest.ServiceCallback<Models.UserUser>): void;
    /**
     * @param userId identifier of the user
     * @param options The optional parameters
     * @param callback The callback
     */
    get(userId: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.UserUser>): void;
    /**
     * @summary Updates a user.
     * @param userId identifier of the user
     * @param body
     * @param [options] The optional parameters
     * @returns Promise<Models.UpdateResponse>
     */
    update(userId: string, body: Models.UserUser, options?: msRest.RequestOptionsBase): Promise<Models.UpdateResponse>;
    /**
     * @param userId identifier of the user
     * @param body
     * @param callback The callback
     */
    update(userId: string, body: Models.UserUser, callback: msRest.ServiceCallback<Models.UserUser>): void;
    /**
     * @param userId identifier of the user
     * @param body
     * @param options The optional parameters
     * @param callback The callback
     */
    update(userId: string, body: Models.UserUser, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.UserUser>): void;
    /**
     * @summary Updates a user.
     * @param userId identifier of the user
     * @param [options] The optional parameters
     * @returns Promise<msRest.RestResponse>
     */
    update1(userId: string, options?: msRest.RequestOptionsBase): Promise<msRest.RestResponse>;
    /**
     * @param userId identifier of the user
     * @param callback The callback
     */
    update1(userId: string, callback: msRest.ServiceCallback<void>): void;
    /**
     * @param userId identifier of the user
     * @param options The optional parameters
     * @param callback The callback
     */
    update1(userId: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<void>): void;
    /**
     * @summary Gets an auth code for the user to use for logging in.
     * @param userId identifier of the user
     * @param [options] The optional parameters
     * @returns Promise<Models.GenerateAuthCodeResponse>
     */
    generateAuthCode(userId: string, options?: msRest.RequestOptionsBase): Promise<Models.GenerateAuthCodeResponse>;
    /**
     * @param userId identifier of the user
     * @param callback The callback
     */
    generateAuthCode(userId: string, callback: msRest.ServiceCallback<Models.UserAuthCodeResponse>): void;
    /**
     * @param userId identifier of the user
     * @param options The optional parameters
     * @param callback The callback
     */
    generateAuthCode(userId: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.UserAuthCodeResponse>): void;
}
export { AuthAPI, AuthAPIContext, Models as AuthAPIModels, Mappers as AuthAPIMappers };
//# sourceMappingURL=authAPI.d.ts.map