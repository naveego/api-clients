/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The PropertyMergeRule model.
 */
public class PropertyMergeRule {
    /**
     * The propertyId property.
     */
    @JsonProperty(value = "propertyId")
    private String propertyId;

    /**
     * The connections property.
     */
    @JsonProperty(value = "connections")
    private List<String> connections;

    /**
     * Get the propertyId value.
     *
     * @return the propertyId value
     */
    public String propertyId() {
        return this.propertyId;
    }

    /**
     * Set the propertyId value.
     *
     * @param propertyId the propertyId value to set
     * @return the PropertyMergeRule object itself.
     */
    public PropertyMergeRule withPropertyId(String propertyId) {
        this.propertyId = propertyId;
        return this;
    }

    /**
     * Get the connections value.
     *
     * @return the connections value
     */
    public List<String> connections() {
        return this.connections;
    }

    /**
     * Set the connections value.
     *
     * @param connections the connections value to set
     * @return the PropertyMergeRule object itself.
     */
    public PropertyMergeRule withConnections(List<String> connections) {
        this.connections = connections;
        return this;
    }

}
