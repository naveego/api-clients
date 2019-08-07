/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * The SchemaTrait model.
 */
public class SchemaTrait {
    /**
     * The id property.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * The error property.
     */
    @JsonProperty(value = "error")
    private String error;

    /**
     * The attributeValues property.
     */
    @JsonProperty(value = "attributeValues")
    private Map<String, Object> attributeValues;

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
     * @return the SchemaTrait object itself.
     */
    public SchemaTrait withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the error value.
     *
     * @return the error value
     */
    public String error() {
        return this.error;
    }

    /**
     * Set the error value.
     *
     * @param error the error value to set
     * @return the SchemaTrait object itself.
     */
    public SchemaTrait withError(String error) {
        this.error = error;
        return this;
    }

    /**
     * Get the attributeValues value.
     *
     * @return the attributeValues value
     */
    public Map<String, Object> attributeValues() {
        return this.attributeValues;
    }

    /**
     * Set the attributeValues value.
     *
     * @param attributeValues the attributeValues value to set
     * @return the SchemaTrait object itself.
     */
    public SchemaTrait withAttributeValues(Map<String, Object> attributeValues) {
        this.attributeValues = attributeValues;
        return this;
    }

}