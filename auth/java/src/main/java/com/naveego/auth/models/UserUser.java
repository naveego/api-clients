/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.auth.models;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The UserUser model.
 */
public class UserUser {
    /**
     * The attributes property.
     */
    @JsonProperty(value = "attributes")
    private Map<String, String> attributes;

    /**
     * The createdOn property.
     */
    @JsonProperty(value = "created_on")
    private String createdOn;

    /**
     * The id property.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * The lastTouch property.
     */
    @JsonProperty(value = "last_touch")
    private String lastTouch;

    /**
     * The modifiedOn property.
     */
    @JsonProperty(value = "modified_on")
    private String modifiedOn;

    /**
     * The status property.
     */
    @JsonProperty(value = "status")
    private String status;

    /**
     * The tenantId property.
     */
    @JsonProperty(value = "tenant_id")
    private String tenantId;

    /**
     * The username property.
     */
    @JsonProperty(value = "username")
    private String username;

    /**
     * Get the attributes value.
     *
     * @return the attributes value
     */
    public Map<String, String> attributes() {
        return this.attributes;
    }

    /**
     * Set the attributes value.
     *
     * @param attributes the attributes value to set
     * @return the UserUser object itself.
     */
    public UserUser withAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * Get the createdOn value.
     *
     * @return the createdOn value
     */
    public String createdOn() {
        return this.createdOn;
    }

    /**
     * Set the createdOn value.
     *
     * @param createdOn the createdOn value to set
     * @return the UserUser object itself.
     */
    public UserUser withCreatedOn(String createdOn) {
        this.createdOn = createdOn;
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
     * @return the UserUser object itself.
     */
    public UserUser withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the lastTouch value.
     *
     * @return the lastTouch value
     */
    public String lastTouch() {
        return this.lastTouch;
    }

    /**
     * Set the lastTouch value.
     *
     * @param lastTouch the lastTouch value to set
     * @return the UserUser object itself.
     */
    public UserUser withLastTouch(String lastTouch) {
        this.lastTouch = lastTouch;
        return this;
    }

    /**
     * Get the modifiedOn value.
     *
     * @return the modifiedOn value
     */
    public String modifiedOn() {
        return this.modifiedOn;
    }

    /**
     * Set the modifiedOn value.
     *
     * @param modifiedOn the modifiedOn value to set
     * @return the UserUser object itself.
     */
    public UserUser withModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    /**
     * Get the status value.
     *
     * @return the status value
     */
    public String status() {
        return this.status;
    }

    /**
     * Set the status value.
     *
     * @param status the status value to set
     * @return the UserUser object itself.
     */
    public UserUser withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get the tenantId value.
     *
     * @return the tenantId value
     */
    public String tenantId() {
        return this.tenantId;
    }

    /**
     * Set the tenantId value.
     *
     * @param tenantId the tenantId value to set
     * @return the UserUser object itself.
     */
    public UserUser withTenantId(String tenantId) {
        this.tenantId = tenantId;
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
     * @return the UserUser object itself.
     */
    public UserUser withUsername(String username) {
        this.username = username;
        return this;
    }

}
