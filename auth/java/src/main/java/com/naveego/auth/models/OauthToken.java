/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.auth.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The OauthToken model.
 */
public class OauthToken {
    /**
     * The accessToken property.
     */
    @JsonProperty(value = "access_token", required = true)
    private String accessToken;

    /**
     * The expiresIn property.
     */
    @JsonProperty(value = "expires_in", required = true)
    private int expiresIn;

    /**
     * The id property.
     */
    @JsonProperty(value = "id", required = true)
    private String id;

    /**
     * The issuedAt property.
     */
    @JsonProperty(value = "issued_at", required = true)
    private long issuedAt;

    /**
     * The refreshToken property.
     */
    @JsonProperty(value = "refresh_token")
    private String refreshToken;

    /**
     * Get the accessToken value.
     *
     * @return the accessToken value
     */
    public String accessToken() {
        return this.accessToken;
    }

    /**
     * Set the accessToken value.
     *
     * @param accessToken the accessToken value to set
     * @return the OauthToken object itself.
     */
    public OauthToken withAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    /**
     * Get the expiresIn value.
     *
     * @return the expiresIn value
     */
    public int expiresIn() {
        return this.expiresIn;
    }

    /**
     * Set the expiresIn value.
     *
     * @param expiresIn the expiresIn value to set
     * @return the OauthToken object itself.
     */
    public OauthToken withExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    /**
     * Get the id value.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id value.
     *
     * @param id the id value to set
     * @return the OauthToken object itself.
     */
    public OauthToken withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the issuedAt value.
     *
     * @return the issuedAt value
     */
    public long issuedAt() {
        return this.issuedAt;
    }

    /**
     * Set the issuedAt value.
     *
     * @param issuedAt the issuedAt value to set
     * @return the OauthToken object itself.
     */
    public OauthToken withIssuedAt(long issuedAt) {
        this.issuedAt = issuedAt;
        return this;
    }

    /**
     * Get the refreshToken value.
     *
     * @return the refreshToken value
     */
    public String refreshToken() {
        return this.refreshToken;
    }

    /**
     * Set the refreshToken value.
     *
     * @param refreshToken the refreshToken value to set
     * @return the OauthToken object itself.
     */
    public OauthToken withRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

}
