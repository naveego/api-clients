/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.auth;

import com.microsoft.rest.RestException;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.naveego.auth.models.DiscoveryKeys;
import com.naveego.auth.models.DiscoveryKeysException;
import com.naveego.auth.models.OauthToken;
import com.naveego.auth.models.OauthTokenException;
import com.naveego.auth.models.SamlGenerateRequestResponse;
import com.naveego.auth.models.SamlGenerateRequestResponseException;
import com.naveego.auth.models.SamlSAMLSettings;
import com.naveego.auth.models.SamlSAMLSettingsException;
import com.naveego.auth.models.TenantConfiguration;
import com.naveego.auth.models.TenantConfigurationException;
import com.naveego.auth.models.UserAuthCodeResponse;
import com.naveego.auth.models.UserAuthCodeResponseException;
import com.naveego.auth.models.UserCreateUser;
import com.naveego.auth.models.UserLoginRequest;
import com.naveego.auth.models.UserLoginResponse;
import com.naveego.auth.models.UserLoginResponseException;
import com.naveego.auth.models.UserUser;
import com.naveego.auth.models.UserUserException;
import java.io.IOException;
import rx.Observable;
import com.microsoft.rest.RestClient;

/**
 * The interface for AuthService class.
 */
public interface AuthService {
    /**
     * Gets the REST client.
     *
     * @return the {@link RestClient} object.
    */
    RestClient restClient();

    /**
     * The default base URL.
     */
    String DEFAULT_BASE_URL = "https://";

    /**
     * get the configuration for a tenant.
     *
     * @param tenantId The tenant id
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws TenantConfigurationException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the TenantConfiguration object if successful.
     */
    TenantConfiguration getConfiguration(String tenantId);

    /**
     * get the configuration for a tenant.
     *
     * @param tenantId The tenant id
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<TenantConfiguration> getConfigurationAsync(String tenantId, final ServiceCallback<TenantConfiguration> serviceCallback);

    /**
     * get the configuration for a tenant.
     *
     * @param tenantId The tenant id
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the TenantConfiguration object
     */
    Observable<TenantConfiguration> getConfigurationAsync(String tenantId);

    /**
     * get the configuration for a tenant.
     *
     * @param tenantId The tenant id
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the TenantConfiguration object
     */
    Observable<ServiceResponse<TenantConfiguration>> getConfigurationWithServiceResponseAsync(String tenantId);

    /**
     * get jwks for key validation.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws DiscoveryKeysException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the DiscoveryKeys object if successful.
     */
    DiscoveryKeys discoverKeys();

    /**
     * get jwks for key validation.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<DiscoveryKeys> discoverKeysAsync(final ServiceCallback<DiscoveryKeys> serviceCallback);

    /**
     * get jwks for key validation.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the DiscoveryKeys object
     */
    Observable<DiscoveryKeys> discoverKeysAsync();

    /**
     * get jwks for key validation.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the DiscoveryKeys object
     */
    Observable<ServiceResponse<DiscoveryKeys>> discoverKeysWithServiceResponseAsync();

    /**
     * Oauth2 authorize endpoint.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    void authorize();

    /**
     * Oauth2 authorize endpoint.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<Void> authorizeAsync(final ServiceCallback<Void> serviceCallback);

    /**
     * Oauth2 authorize endpoint.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<Void> authorizeAsync();

    /**
     * Oauth2 authorize endpoint.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<ServiceResponse<Void>> authorizeWithServiceResponseAsync();

    /**
     * Oauth2 token endpoint.
     *
     * @param grantType The grant_type to use for obtaining a token
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws OauthTokenException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the OauthToken object if successful.
     */
    OauthToken token(String grantType);

    /**
     * Oauth2 token endpoint.
     *
     * @param grantType The grant_type to use for obtaining a token
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<OauthToken> tokenAsync(String grantType, final ServiceCallback<OauthToken> serviceCallback);

    /**
     * Oauth2 token endpoint.
     *
     * @param grantType The grant_type to use for obtaining a token
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the OauthToken object
     */
    Observable<OauthToken> tokenAsync(String grantType);

    /**
     * Oauth2 token endpoint.
     *
     * @param grantType The grant_type to use for obtaining a token
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the OauthToken object
     */
    Observable<ServiceResponse<OauthToken>> tokenWithServiceResponseAsync(String grantType);
    /**
     * Oauth2 token endpoint.
     *
     * @param grantType The grant_type to use for obtaining a token
     * @param username The username used with grant_type=password
     * @param password The password used with grant_type=password
     * @param code The code to use with grant_type=authorization_code
     * @param refreshToken The refresh token to use with grant_type=refresh_token
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws OauthTokenException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the OauthToken object if successful.
     */
    OauthToken token(String grantType, String username, String password, String code, String refreshToken);

    /**
     * Oauth2 token endpoint.
     *
     * @param grantType The grant_type to use for obtaining a token
     * @param username The username used with grant_type=password
     * @param password The password used with grant_type=password
     * @param code The code to use with grant_type=authorization_code
     * @param refreshToken The refresh token to use with grant_type=refresh_token
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<OauthToken> tokenAsync(String grantType, String username, String password, String code, String refreshToken, final ServiceCallback<OauthToken> serviceCallback);

    /**
     * Oauth2 token endpoint.
     *
     * @param grantType The grant_type to use for obtaining a token
     * @param username The username used with grant_type=password
     * @param password The password used with grant_type=password
     * @param code The code to use with grant_type=authorization_code
     * @param refreshToken The refresh token to use with grant_type=refresh_token
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the OauthToken object
     */
    Observable<OauthToken> tokenAsync(String grantType, String username, String password, String code, String refreshToken);

    /**
     * Oauth2 token endpoint.
     *
     * @param grantType The grant_type to use for obtaining a token
     * @param username The username used with grant_type=password
     * @param password The password used with grant_type=password
     * @param code The code to use with grant_type=authorization_code
     * @param refreshToken The refresh token to use with grant_type=refresh_token
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the OauthToken object
     */
    Observable<ServiceResponse<OauthToken>> tokenWithServiceResponseAsync(String grantType, String username, String password, String code, String refreshToken);

    /**
     * Redirects user back to target login endpoint.
     *
     * @param tid The tenant id for this request
     * @param sAMLResponse The SAML AuthNResponse from the Identity Provider
     * @param relayState The relay state obtained from generate request process
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    void generateRequest(String tid, String sAMLResponse, String relayState);

    /**
     * Redirects user back to target login endpoint.
     *
     * @param tid The tenant id for this request
     * @param sAMLResponse The SAML AuthNResponse from the Identity Provider
     * @param relayState The relay state obtained from generate request process
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<Void> generateRequestAsync(String tid, String sAMLResponse, String relayState, final ServiceCallback<Void> serviceCallback);

    /**
     * Redirects user back to target login endpoint.
     *
     * @param tid The tenant id for this request
     * @param sAMLResponse The SAML AuthNResponse from the Identity Provider
     * @param relayState The relay state obtained from generate request process
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<Void> generateRequestAsync(String tid, String sAMLResponse, String relayState);

    /**
     * Redirects user back to target login endpoint.
     *
     * @param tid The tenant id for this request
     * @param sAMLResponse The SAML AuthNResponse from the Identity Provider
     * @param relayState The relay state obtained from generate request process
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<ServiceResponse<Void>> generateRequestWithServiceResponseAsync(String tid, String sAMLResponse, String relayState);

    /**
     * Generates a SAML request.
     *
     * @param tid The tenant id for this request
     * @param clientId The Oauth2 client_id that is making the reqeust
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws SamlGenerateRequestResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the SamlGenerateRequestResponse object if successful.
     */
    SamlGenerateRequestResponse generateRequest1(String tid, String clientId);

    /**
     * Generates a SAML request.
     *
     * @param tid The tenant id for this request
     * @param clientId The Oauth2 client_id that is making the reqeust
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<SamlGenerateRequestResponse> generateRequest1Async(String tid, String clientId, final ServiceCallback<SamlGenerateRequestResponse> serviceCallback);

    /**
     * Generates a SAML request.
     *
     * @param tid The tenant id for this request
     * @param clientId The Oauth2 client_id that is making the reqeust
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the SamlGenerateRequestResponse object
     */
    Observable<SamlGenerateRequestResponse> generateRequest1Async(String tid, String clientId);

    /**
     * Generates a SAML request.
     *
     * @param tid The tenant id for this request
     * @param clientId The Oauth2 client_id that is making the reqeust
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the SamlGenerateRequestResponse object
     */
    Observable<ServiceResponse<SamlGenerateRequestResponse>> generateRequest1WithServiceResponseAsync(String tid, String clientId);

    /**
     * Gets the SAML settings for this tenant.
     *
     * @param tid The tenant id for this request
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws SamlSAMLSettingsException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the SamlSAMLSettings object if successful.
     */
    SamlSAMLSettings getSAMLSettings(String tid);

    /**
     * Gets the SAML settings for this tenant.
     *
     * @param tid The tenant id for this request
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<SamlSAMLSettings> getSAMLSettingsAsync(String tid, final ServiceCallback<SamlSAMLSettings> serviceCallback);

    /**
     * Gets the SAML settings for this tenant.
     *
     * @param tid The tenant id for this request
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the SamlSAMLSettings object
     */
    Observable<SamlSAMLSettings> getSAMLSettingsAsync(String tid);

    /**
     * Gets the SAML settings for this tenant.
     *
     * @param tid The tenant id for this request
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the SamlSAMLSettings object
     */
    Observable<ServiceResponse<SamlSAMLSettings>> getSAMLSettingsWithServiceResponseAsync(String tid);

    /**
     * Create a user.
     *
     * @param body the UserCreateUser value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the UserUser object if successful.
     */
    UserUser create(UserCreateUser body);

    /**
     * Create a user.
     *
     * @param body the UserCreateUser value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<UserUser> createAsync(UserCreateUser body, final ServiceCallback<UserUser> serviceCallback);

    /**
     * Create a user.
     *
     * @param body the UserCreateUser value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the UserUser object
     */
    Observable<UserUser> createAsync(UserCreateUser body);

    /**
     * Create a user.
     *
     * @param body the UserCreateUser value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the UserUser object
     */
    Observable<ServiceResponse<UserUser>> createWithServiceResponseAsync(UserCreateUser body);

    /**
     * Provides a login endpoint that can generate an auth code for the user given valid user credentials.
     *
     * @param body the UserLoginRequest value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws UserLoginResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the UserLoginResponse object if successful.
     */
    UserLoginResponse loginUser(UserLoginRequest body);

    /**
     * Provides a login endpoint that can generate an auth code for the user given valid user credentials.
     *
     * @param body the UserLoginRequest value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<UserLoginResponse> loginUserAsync(UserLoginRequest body, final ServiceCallback<UserLoginResponse> serviceCallback);

    /**
     * Provides a login endpoint that can generate an auth code for the user given valid user credentials.
     *
     * @param body the UserLoginRequest value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the UserLoginResponse object
     */
    Observable<UserLoginResponse> loginUserAsync(UserLoginRequest body);

    /**
     * Provides a login endpoint that can generate an auth code for the user given valid user credentials.
     *
     * @param body the UserLoginRequest value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the UserLoginResponse object
     */
    Observable<ServiceResponse<UserLoginResponse>> loginUserWithServiceResponseAsync(UserLoginRequest body);

    /**
     * Gets a user.
     *
     * @param userId identifier of the user
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws UserUserException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the UserUser object if successful.
     */
    UserUser get(String userId);

    /**
     * Gets a user.
     *
     * @param userId identifier of the user
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<UserUser> getAsync(String userId, final ServiceCallback<UserUser> serviceCallback);

    /**
     * Gets a user.
     *
     * @param userId identifier of the user
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the UserUser object
     */
    Observable<UserUser> getAsync(String userId);

    /**
     * Gets a user.
     *
     * @param userId identifier of the user
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the UserUser object
     */
    Observable<ServiceResponse<UserUser>> getWithServiceResponseAsync(String userId);

    /**
     * Updates a user.
     *
     * @param userId identifier of the user
     * @param body the UserUser value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws UserUserException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the UserUser object if successful.
     */
    UserUser update(String userId, UserUser body);

    /**
     * Updates a user.
     *
     * @param userId identifier of the user
     * @param body the UserUser value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<UserUser> updateAsync(String userId, UserUser body, final ServiceCallback<UserUser> serviceCallback);

    /**
     * Updates a user.
     *
     * @param userId identifier of the user
     * @param body the UserUser value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the UserUser object
     */
    Observable<UserUser> updateAsync(String userId, UserUser body);

    /**
     * Updates a user.
     *
     * @param userId identifier of the user
     * @param body the UserUser value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the UserUser object
     */
    Observable<ServiceResponse<UserUser>> updateWithServiceResponseAsync(String userId, UserUser body);

    /**
     * Updates a user.
     *
     * @param userId identifier of the user
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    void update1(String userId);

    /**
     * Updates a user.
     *
     * @param userId identifier of the user
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<Void> update1Async(String userId, final ServiceCallback<Void> serviceCallback);

    /**
     * Updates a user.
     *
     * @param userId identifier of the user
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<Void> update1Async(String userId);

    /**
     * Updates a user.
     *
     * @param userId identifier of the user
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<ServiceResponse<Void>> update1WithServiceResponseAsync(String userId);

    /**
     * Gets an auth code for the user to use for logging in.
     *
     * @param userId identifier of the user
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws UserAuthCodeResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the UserAuthCodeResponse object if successful.
     */
    UserAuthCodeResponse generateAuthCode(String userId);

    /**
     * Gets an auth code for the user to use for logging in.
     *
     * @param userId identifier of the user
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<UserAuthCodeResponse> generateAuthCodeAsync(String userId, final ServiceCallback<UserAuthCodeResponse> serviceCallback);

    /**
     * Gets an auth code for the user to use for logging in.
     *
     * @param userId identifier of the user
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the UserAuthCodeResponse object
     */
    Observable<UserAuthCodeResponse> generateAuthCodeAsync(String userId);

    /**
     * Gets an auth code for the user to use for logging in.
     *
     * @param userId identifier of the user
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the UserAuthCodeResponse object
     */
    Observable<ServiceResponse<UserAuthCodeResponse>> generateAuthCodeWithServiceResponseAsync(String userId);

}
