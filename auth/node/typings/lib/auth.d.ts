import * as msRest from "ms-rest-js";
import * as Models from "./models";
import * as Mappers from "./models/mappers";
import { AuthContext } from "./authContext";
declare class Auth extends AuthContext {
    /**
     * @class
     * Initializes a new instance of the Auth class.
     * @constructor
     *
     * @param {string} [baseUri] - The base URI of the service.
     *
     * @param {object} [options] - The parameter options
     *
     * @param {Array} [options.filters] - Filters to be added to the request pipeline
     *
     * @param {object} [options.requestOptions] - The request options. Detailed info can be found at
     * {@link https://github.github.io/fetch/#Request Options doc}
     *
     * @param {boolean} [options.noRetryPolicy] - If set to true, turn off default retry policy
     *
     */
    constructor(credentials: msRest.ServiceClientCredentials, baseUri?: string, options?: msRest.ServiceClientOptions);
    /**
     * @summary get the configuration for a tenant
     *
     * @param {string} tenantId The tenant id
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @returns {Promise} A promise is returned
     *
     * @resolve {HttpOperationResponse} The deserialized result object.
     *
     * @reject {Error|ServiceError} The error object.
     */
    getConfigurationWithHttpOperationResponse(tenantId: string, options?: msRest.RequestOptionsBase): Promise<msRest.HttpOperationResponse<Models.TenantConfiguration>>;
    /**
     * @summary get jwks for key validation
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @returns {Promise} A promise is returned
     *
     * @resolve {HttpOperationResponse} The deserialized result object.
     *
     * @reject {Error|ServiceError} The error object.
     */
    discoverKeysWithHttpOperationResponse(options?: msRest.RequestOptionsBase): Promise<msRest.HttpOperationResponse<Models.DiscoveryKeys>>;
    /**
     * @summary Oauth2 authorize endpoint
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @returns {Promise} A promise is returned
     *
     * @resolve {HttpOperationResponse} The deserialized result object.
     *
     * @reject {Error|ServiceError} The error object.
     */
    authorizeWithHttpOperationResponse(options?: msRest.RequestOptionsBase): Promise<msRest.HttpOperationResponse<void>>;
    /**
     * @summary Oauth2 token endpoint
     *
     * @param {string} grantType The grant_type to use for obtaining a token
     *
     * @param {AuthTokenOptionalParams} [options] Optional Parameters.
     *
     * @returns {Promise} A promise is returned
     *
     * @resolve {HttpOperationResponse} The deserialized result object.
     *
     * @reject {Error|ServiceError} The error object.
     */
    tokenWithHttpOperationResponse(grantType: string, options?: Models.AuthTokenOptionalParams): Promise<msRest.HttpOperationResponse<Models.OauthToken>>;
    /**
     * @summary Redirects user back to target login endpoint
     *
     * @param {string} tid The tenant id for this request
     *
     * @param {string} sAMLResponse The SAML AuthNResponse from the Identity Provider
     *
     * @param {string} relayState The relay state obtained from generate request process
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @returns {Promise} A promise is returned
     *
     * @resolve {HttpOperationResponse} The deserialized result object.
     *
     * @reject {Error|ServiceError} The error object.
     */
    generateRequestWithHttpOperationResponse(tid: string, sAMLResponse: string, relayState: string, options?: msRest.RequestOptionsBase): Promise<msRest.HttpOperationResponse<void>>;
    /**
     * @summary Generates a SAML request
     *
     * @param {string} tid The tenant id for this request
     *
     * @param {string} clientId The Oauth2 client_id that is making the reqeust
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @returns {Promise} A promise is returned
     *
     * @resolve {HttpOperationResponse} The deserialized result object.
     *
     * @reject {Error|ServiceError} The error object.
     */
    generateRequest1WithHttpOperationResponse(tid: string, clientId: string, options?: msRest.RequestOptionsBase): Promise<msRest.HttpOperationResponse<Models.SamlGenerateRequestResponse>>;
    /**
     * @summary Gets the SAML settings for this tenant
     *
     * @param {string} tid The tenant id for this request
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @returns {Promise} A promise is returned
     *
     * @resolve {HttpOperationResponse} The deserialized result object.
     *
     * @reject {Error|ServiceError} The error object.
     */
    getSAMLSettingsWithHttpOperationResponse(tid: string, options?: msRest.RequestOptionsBase): Promise<msRest.HttpOperationResponse<Models.SamlSAMLSettings>>;
    /**
     * @summary Create a user.
     *
     * @param {UserCreateUser} body
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @returns {Promise} A promise is returned
     *
     * @resolve {HttpOperationResponse} The deserialized result object.
     *
     * @reject {Error|ServiceError} The error object.
     */
    createWithHttpOperationResponse(body: Models.UserCreateUser, options?: msRest.RequestOptionsBase): Promise<msRest.HttpOperationResponse<Models.UserUser>>;
    /**
     * @summary Gets a user.
     *
     * @param {string} userId identifier of the user
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @returns {Promise} A promise is returned
     *
     * @resolve {HttpOperationResponse} The deserialized result object.
     *
     * @reject {Error|ServiceError} The error object.
     */
    getWithHttpOperationResponse(userId: string, options?: msRest.RequestOptionsBase): Promise<msRest.HttpOperationResponse<Models.UserUser>>;
    /**
     * @summary Updates a user.
     *
     * @param {string} userId identifier of the user
     *
     * @param {UserUser} body
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @returns {Promise} A promise is returned
     *
     * @resolve {HttpOperationResponse} The deserialized result object.
     *
     * @reject {Error|ServiceError} The error object.
     */
    updateWithHttpOperationResponse(userId: string, body: Models.UserUser, options?: msRest.RequestOptionsBase): Promise<msRest.HttpOperationResponse<Models.UserUser>>;
    /**
     * @summary Updates a user.
     *
     * @param {string} userId identifier of the user
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @returns {Promise} A promise is returned
     *
     * @resolve {HttpOperationResponse} The deserialized result object.
     *
     * @reject {Error|ServiceError} The error object.
     */
    update1WithHttpOperationResponse(userId: string, options?: msRest.RequestOptionsBase): Promise<msRest.HttpOperationResponse<void>>;
    /**
     * @summary Gets an auth code for the user to use for logging in.
     *
     * @param {string} userId identifier of the user
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @returns {Promise} A promise is returned
     *
     * @resolve {HttpOperationResponse} The deserialized result object.
     *
     * @reject {Error|ServiceError} The error object.
     */
    generateAuthCodeWithHttpOperationResponse(userId: string, options?: msRest.RequestOptionsBase): Promise<msRest.HttpOperationResponse<Models.UserAuthCodeResponse>>;
    /**
     * @summary get the configuration for a tenant
     *
     * @param {string} tenantId The tenant id
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @param {ServiceCallback} callback The callback.
     *
     * @returns {ServiceCallback} callback(err, result, request, operationRes)
     *                      {Error|ServiceError}  err        - The Error object if an error occurred, null otherwise.
     *                      {Models.TenantConfiguration} [result]   - The deserialized result object if an error did not occur.
     *                      See {@link Models.TenantConfiguration} for more information.
     *                      {WebResource} [request]  - The HTTP Request object if an error did not occur.
     *                      {HttpOperationResponse} [response] - The HTTP Response stream if an error did not occur.
     */
    getConfiguration(tenantId: string): Promise<Models.TenantConfiguration>;
    getConfiguration(tenantId: string, options: msRest.RequestOptionsBase): Promise<Models.TenantConfiguration>;
    getConfiguration(tenantId: string, callback: msRest.ServiceCallback<Models.TenantConfiguration>): void;
    getConfiguration(tenantId: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.TenantConfiguration>): void;
    /**
     * @summary get jwks for key validation
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @param {ServiceCallback} callback The callback.
     *
     * @returns {ServiceCallback} callback(err, result, request, operationRes)
     *                      {Error|ServiceError}  err        - The Error object if an error occurred, null otherwise.
     *                      {Models.DiscoveryKeys} [result]   - The deserialized result object if an error did not occur.
     *                      See {@link Models.DiscoveryKeys} for more information.
     *                      {WebResource} [request]  - The HTTP Request object if an error did not occur.
     *                      {HttpOperationResponse} [response] - The HTTP Response stream if an error did not occur.
     */
    discoverKeys(): Promise<Models.DiscoveryKeys>;
    discoverKeys(options: msRest.RequestOptionsBase): Promise<Models.DiscoveryKeys>;
    discoverKeys(callback: msRest.ServiceCallback<Models.DiscoveryKeys>): void;
    discoverKeys(options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.DiscoveryKeys>): void;
    /**
     * @summary Oauth2 authorize endpoint
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @param {ServiceCallback} callback The callback.
     *
     * @returns {ServiceCallback} callback(err, result, request, operationRes)
     *                      {Error|ServiceError}  err        - The Error object if an error occurred, null otherwise.
     *                      {void} [result]   - The deserialized result object if an error did not occur.
     *
     *                      {WebResource} [request]  - The HTTP Request object if an error did not occur.
     *                      {HttpOperationResponse} [response] - The HTTP Response stream if an error did not occur.
     */
    authorize(): Promise<void>;
    authorize(options: msRest.RequestOptionsBase): Promise<void>;
    authorize(callback: msRest.ServiceCallback<void>): void;
    authorize(options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<void>): void;
    /**
     * @summary Oauth2 token endpoint
     *
     * @param {string} grantType The grant_type to use for obtaining a token
     *
     * @param {AuthTokenOptionalParams} [options] Optional Parameters.
     *
     * @param {ServiceCallback} callback The callback.
     *
     * @returns {ServiceCallback} callback(err, result, request, operationRes)
     *                      {Error|ServiceError}  err        - The Error object if an error occurred, null otherwise.
     *                      {Models.OauthToken} [result]   - The deserialized result object if an error did not occur.
     *                      See {@link Models.OauthToken} for more information.
     *                      {WebResource} [request]  - The HTTP Request object if an error did not occur.
     *                      {HttpOperationResponse} [response] - The HTTP Response stream if an error did not occur.
     */
    token(grantType: string): Promise<Models.OauthToken>;
    token(grantType: string, options: Models.AuthTokenOptionalParams): Promise<Models.OauthToken>;
    token(grantType: string, callback: msRest.ServiceCallback<Models.OauthToken>): void;
    token(grantType: string, options: Models.AuthTokenOptionalParams, callback: msRest.ServiceCallback<Models.OauthToken>): void;
    /**
     * @summary Redirects user back to target login endpoint
     *
     * @param {string} tid The tenant id for this request
     *
     * @param {string} sAMLResponse The SAML AuthNResponse from the Identity Provider
     *
     * @param {string} relayState The relay state obtained from generate request process
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @param {ServiceCallback} callback The callback.
     *
     * @returns {ServiceCallback} callback(err, result, request, operationRes)
     *                      {Error|ServiceError}  err        - The Error object if an error occurred, null otherwise.
     *                      {void} [result]   - The deserialized result object if an error did not occur.
     *
     *                      {WebResource} [request]  - The HTTP Request object if an error did not occur.
     *                      {HttpOperationResponse} [response] - The HTTP Response stream if an error did not occur.
     */
    generateRequest(tid: string, sAMLResponse: string, relayState: string): Promise<void>;
    generateRequest(tid: string, sAMLResponse: string, relayState: string, options: msRest.RequestOptionsBase): Promise<void>;
    generateRequest(tid: string, sAMLResponse: string, relayState: string, callback: msRest.ServiceCallback<void>): void;
    generateRequest(tid: string, sAMLResponse: string, relayState: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<void>): void;
    /**
     * @summary Generates a SAML request
     *
     * @param {string} tid The tenant id for this request
     *
     * @param {string} clientId The Oauth2 client_id that is making the reqeust
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @param {ServiceCallback} callback The callback.
     *
     * @returns {ServiceCallback} callback(err, result, request, operationRes)
     *                      {Error|ServiceError}  err        - The Error object if an error occurred, null otherwise.
     *                      {Models.SamlGenerateRequestResponse} [result]   - The deserialized result object if an error did not occur.
     *                      See {@link Models.SamlGenerateRequestResponse} for more information.
     *                      {WebResource} [request]  - The HTTP Request object if an error did not occur.
     *                      {HttpOperationResponse} [response] - The HTTP Response stream if an error did not occur.
     */
    generateRequest1(tid: string, clientId: string): Promise<Models.SamlGenerateRequestResponse>;
    generateRequest1(tid: string, clientId: string, options: msRest.RequestOptionsBase): Promise<Models.SamlGenerateRequestResponse>;
    generateRequest1(tid: string, clientId: string, callback: msRest.ServiceCallback<Models.SamlGenerateRequestResponse>): void;
    generateRequest1(tid: string, clientId: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.SamlGenerateRequestResponse>): void;
    /**
     * @summary Gets the SAML settings for this tenant
     *
     * @param {string} tid The tenant id for this request
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @param {ServiceCallback} callback The callback.
     *
     * @returns {ServiceCallback} callback(err, result, request, operationRes)
     *                      {Error|ServiceError}  err        - The Error object if an error occurred, null otherwise.
     *                      {Models.SamlSAMLSettings} [result]   - The deserialized result object if an error did not occur.
     *                      See {@link Models.SamlSAMLSettings} for more information.
     *                      {WebResource} [request]  - The HTTP Request object if an error did not occur.
     *                      {HttpOperationResponse} [response] - The HTTP Response stream if an error did not occur.
     */
    getSAMLSettings(tid: string): Promise<Models.SamlSAMLSettings>;
    getSAMLSettings(tid: string, options: msRest.RequestOptionsBase): Promise<Models.SamlSAMLSettings>;
    getSAMLSettings(tid: string, callback: msRest.ServiceCallback<Models.SamlSAMLSettings>): void;
    getSAMLSettings(tid: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.SamlSAMLSettings>): void;
    /**
     * @summary Create a user.
     *
     * @param {UserCreateUser} body
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @param {ServiceCallback} callback The callback.
     *
     * @returns {ServiceCallback} callback(err, result, request, operationRes)
     *                      {Error|ServiceError}  err        - The Error object if an error occurred, null otherwise.
     *                      {Models.UserUser} [result]   - The deserialized result object if an error did not occur.
     *                      See {@link Models.UserUser} for more information.
     *                      {WebResource} [request]  - The HTTP Request object if an error did not occur.
     *                      {HttpOperationResponse} [response] - The HTTP Response stream if an error did not occur.
     */
    create(body: Models.UserCreateUser): Promise<Models.UserUser>;
    create(body: Models.UserCreateUser, options: msRest.RequestOptionsBase): Promise<Models.UserUser>;
    create(body: Models.UserCreateUser, callback: msRest.ServiceCallback<Models.UserUser>): void;
    create(body: Models.UserCreateUser, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.UserUser>): void;
    /**
     * @summary Gets a user.
     *
     * @param {string} userId identifier of the user
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @param {ServiceCallback} callback The callback.
     *
     * @returns {ServiceCallback} callback(err, result, request, operationRes)
     *                      {Error|ServiceError}  err        - The Error object if an error occurred, null otherwise.
     *                      {Models.UserUser} [result]   - The deserialized result object if an error did not occur.
     *                      See {@link Models.UserUser} for more information.
     *                      {WebResource} [request]  - The HTTP Request object if an error did not occur.
     *                      {HttpOperationResponse} [response] - The HTTP Response stream if an error did not occur.
     */
    get(userId: string): Promise<Models.UserUser>;
    get(userId: string, options: msRest.RequestOptionsBase): Promise<Models.UserUser>;
    get(userId: string, callback: msRest.ServiceCallback<Models.UserUser>): void;
    get(userId: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.UserUser>): void;
    /**
     * @summary Updates a user.
     *
     * @param {string} userId identifier of the user
     *
     * @param {UserUser} body
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @param {ServiceCallback} callback The callback.
     *
     * @returns {ServiceCallback} callback(err, result, request, operationRes)
     *                      {Error|ServiceError}  err        - The Error object if an error occurred, null otherwise.
     *                      {Models.UserUser} [result]   - The deserialized result object if an error did not occur.
     *                      See {@link Models.UserUser} for more information.
     *                      {WebResource} [request]  - The HTTP Request object if an error did not occur.
     *                      {HttpOperationResponse} [response] - The HTTP Response stream if an error did not occur.
     */
    update(userId: string, body: Models.UserUser): Promise<Models.UserUser>;
    update(userId: string, body: Models.UserUser, options: msRest.RequestOptionsBase): Promise<Models.UserUser>;
    update(userId: string, body: Models.UserUser, callback: msRest.ServiceCallback<Models.UserUser>): void;
    update(userId: string, body: Models.UserUser, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.UserUser>): void;
    /**
     * @summary Updates a user.
     *
     * @param {string} userId identifier of the user
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @param {ServiceCallback} callback The callback.
     *
     * @returns {ServiceCallback} callback(err, result, request, operationRes)
     *                      {Error|ServiceError}  err        - The Error object if an error occurred, null otherwise.
     *                      {void} [result]   - The deserialized result object if an error did not occur.
     *
     *                      {WebResource} [request]  - The HTTP Request object if an error did not occur.
     *                      {HttpOperationResponse} [response] - The HTTP Response stream if an error did not occur.
     */
    update1(userId: string): Promise<void>;
    update1(userId: string, options: msRest.RequestOptionsBase): Promise<void>;
    update1(userId: string, callback: msRest.ServiceCallback<void>): void;
    update1(userId: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<void>): void;
    /**
     * @summary Gets an auth code for the user to use for logging in.
     *
     * @param {string} userId identifier of the user
     *
     * @param {RequestOptionsBase} [options] Optional Parameters.
     *
     * @param {ServiceCallback} callback The callback.
     *
     * @returns {ServiceCallback} callback(err, result, request, operationRes)
     *                      {Error|ServiceError}  err        - The Error object if an error occurred, null otherwise.
     *                      {Models.UserAuthCodeResponse} [result]   - The deserialized result object if an error did not occur.
     *                      See {@link Models.UserAuthCodeResponse} for more information.
     *                      {WebResource} [request]  - The HTTP Request object if an error did not occur.
     *                      {HttpOperationResponse} [response] - The HTTP Response stream if an error did not occur.
     */
    generateAuthCode(userId: string): Promise<Models.UserAuthCodeResponse>;
    generateAuthCode(userId: string, options: msRest.RequestOptionsBase): Promise<Models.UserAuthCodeResponse>;
    generateAuthCode(userId: string, callback: msRest.ServiceCallback<Models.UserAuthCodeResponse>): void;
    generateAuthCode(userId: string, options: msRest.RequestOptionsBase, callback: msRest.ServiceCallback<Models.UserAuthCodeResponse>): void;
}
export { Auth, Models as AuthModels, Mappers as AuthMappers };
