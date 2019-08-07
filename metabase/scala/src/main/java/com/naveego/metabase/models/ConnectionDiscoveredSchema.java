/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The ConnectionDiscoveredSchema model.
 */
public class ConnectionDiscoveredSchema {
    /**
     * The discoveredSchemaId property.
     */
    @JsonProperty(value = "discoveredSchemaId")
    private String discoveredSchemaId;

    /**
     * The isAdvertised property.
     */
    @JsonProperty(value = "isAdvertised")
    private Boolean isAdvertised;

    /**
     * The advertisedSchemaId property.
     */
    @JsonProperty(value = "advertisedSchemaId")
    private String advertisedSchemaId;

    /**
     * Get the discoveredSchemaId value.
     *
     * @return the discoveredSchemaId value
     */
    public String discoveredSchemaId() {
        return this.discoveredSchemaId;
    }

    /**
     * Set the discoveredSchemaId value.
     *
     * @param discoveredSchemaId the discoveredSchemaId value to set
     * @return the ConnectionDiscoveredSchema object itself.
     */
    public ConnectionDiscoveredSchema withDiscoveredSchemaId(String discoveredSchemaId) {
        this.discoveredSchemaId = discoveredSchemaId;
        return this;
    }

    /**
     * Get the isAdvertised value.
     *
     * @return the isAdvertised value
     */
    public Boolean isAdvertised() {
        return this.isAdvertised;
    }

    /**
     * Set the isAdvertised value.
     *
     * @param isAdvertised the isAdvertised value to set
     * @return the ConnectionDiscoveredSchema object itself.
     */
    public ConnectionDiscoveredSchema withIsAdvertised(Boolean isAdvertised) {
        this.isAdvertised = isAdvertised;
        return this;
    }

    /**
     * Get the advertisedSchemaId value.
     *
     * @return the advertisedSchemaId value
     */
    public String advertisedSchemaId() {
        return this.advertisedSchemaId;
    }

    /**
     * Set the advertisedSchemaId value.
     *
     * @param advertisedSchemaId the advertisedSchemaId value to set
     * @return the ConnectionDiscoveredSchema object itself.
     */
    public ConnectionDiscoveredSchema withAdvertisedSchemaId(String advertisedSchemaId) {
        this.advertisedSchemaId = advertisedSchemaId;
        return this;
    }

}