/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.auth.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The UserLoginRequest model.
 */
public class UserLoginRequest {
    /**
     * The password property.
     */
    @JsonProperty(value = "password", required = true)
    private String password;

    /**
     * The username property.
     */
    @JsonProperty(value = "username", required = true)
    private String username;

    /**
     * Get the password value.
     *
     * @return the password value
     */
    public String password() {
        return this.password;
    }

    /**
     * Set the password value.
     *
     * @param password the password value to set
     * @return the UserLoginRequest object itself.
     */
    public UserLoginRequest withPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Get the username value.
     *
     * @return the username value
     */
    public String username() {
        return this.username;
    }

    /**
     * Set the username value.
     *
     * @param username the username value to set
     * @return the UserLoginRequest object itself.
     */
    public UserLoginRequest withUsername(String username) {
        this.username = username;
        return this;
    }

}