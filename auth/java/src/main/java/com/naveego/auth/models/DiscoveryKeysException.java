/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.auth.models;

import com.microsoft.rest.RestException;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Exception thrown for an invalid response with DiscoveryKeys information.
 */
public class DiscoveryKeysException extends RestException {
    /**
     * Initializes a new instance of the DiscoveryKeysException class.
     *
     * @param message the exception message or the response content if a message is not available
     * @param response the HTTP response
     */
    public DiscoveryKeysException(final String message, final Response<ResponseBody> response) {
        super(message, response);
    }

    /**
     * Initializes a new instance of the DiscoveryKeysException class.
     *
     * @param message the exception message or the response content if a message is not available
     * @param response the HTTP response
     * @param body the deserialized response body
     */
    public DiscoveryKeysException(final String message, final Response<ResponseBody> response, final DiscoveryKeys body) {
        super(message, response, body);
    }

    @Override
    public DiscoveryKeys body() {
        return (DiscoveryKeys) super.body();
    }
}
