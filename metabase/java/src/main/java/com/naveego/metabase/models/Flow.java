/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import java.util.Map;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Flow model.
 */
public class Flow {
    /**
     * The id property.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * The version property.
     */
    @JsonProperty(value = "version")
    private Integer version;

    /**
     * The name property.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * The description property.
     */
    @JsonProperty(value = "description")
    private String description;

    /**
     * The nodes property.
     */
    @JsonProperty(value = "nodes")
    private Map<String, Node> nodes;

    /**
     * The edges property.
     */
    @JsonProperty(value = "edges")
    private Map<String, Edge> edges;

    /**
     * The createdAt property.
     */
    @JsonProperty(value = "createdAt")
    private DateTime createdAt;

    /**
     * The createdBy property.
     */
    @JsonProperty(value = "createdBy")
    private String createdBy;

    /**
     * The updatedAt property.
     */
    @JsonProperty(value = "updatedAt")
    private DateTime updatedAt;

    /**
     * The updatedBy property.
     */
    @JsonProperty(value = "updatedBy")
    private String updatedBy;

    /**
     * The deletedAt property.
     */
    @JsonProperty(value = "deletedAt")
    private DateTime deletedAt;

    /**
     * The deletedBy property.
     */
    @JsonProperty(value = "deletedBy")
    private String deletedBy;

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
     * @return the Flow object itself.
     */
    public Flow withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the version value.
     *
     * @return the version value
     */
    public Integer version() {
        return this.version;
    }

    /**
     * Set the version value.
     *
     * @param version the version value to set
     * @return the Flow object itself.
     */
    public Flow withVersion(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     * @return the Flow object itself.
     */
    public Flow withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the description value.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description value.
     *
     * @param description the description value to set
     * @return the Flow object itself.
     */
    public Flow withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the nodes value.
     *
     * @return the nodes value
     */
    public Map<String, Node> nodes() {
        return this.nodes;
    }

    /**
     * Set the nodes value.
     *
     * @param nodes the nodes value to set
     * @return the Flow object itself.
     */
    public Flow withNodes(Map<String, Node> nodes) {
        this.nodes = nodes;
        return this;
    }

    /**
     * Get the edges value.
     *
     * @return the edges value
     */
    public Map<String, Edge> edges() {
        return this.edges;
    }

    /**
     * Set the edges value.
     *
     * @param edges the edges value to set
     * @return the Flow object itself.
     */
    public Flow withEdges(Map<String, Edge> edges) {
        this.edges = edges;
        return this;
    }

    /**
     * Get the createdAt value.
     *
     * @return the createdAt value
     */
    public DateTime createdAt() {
        return this.createdAt;
    }

    /**
     * Set the createdAt value.
     *
     * @param createdAt the createdAt value to set
     * @return the Flow object itself.
     */
    public Flow withCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get the createdBy value.
     *
     * @return the createdBy value
     */
    public String createdBy() {
        return this.createdBy;
    }

    /**
     * Set the createdBy value.
     *
     * @param createdBy the createdBy value to set
     * @return the Flow object itself.
     */
    public Flow withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Get the updatedAt value.
     *
     * @return the updatedAt value
     */
    public DateTime updatedAt() {
        return this.updatedAt;
    }

    /**
     * Set the updatedAt value.
     *
     * @param updatedAt the updatedAt value to set
     * @return the Flow object itself.
     */
    public Flow withUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Get the updatedBy value.
     *
     * @return the updatedBy value
     */
    public String updatedBy() {
        return this.updatedBy;
    }

    /**
     * Set the updatedBy value.
     *
     * @param updatedBy the updatedBy value to set
     * @return the Flow object itself.
     */
    public Flow withUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    /**
     * Get the deletedAt value.
     *
     * @return the deletedAt value
     */
    public DateTime deletedAt() {
        return this.deletedAt;
    }

    /**
     * Set the deletedAt value.
     *
     * @param deletedAt the deletedAt value to set
     * @return the Flow object itself.
     */
    public Flow withDeletedAt(DateTime deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    /**
     * Get the deletedBy value.
     *
     * @return the deletedBy value
     */
    public String deletedBy() {
        return this.deletedBy;
    }

    /**
     * Set the deletedBy value.
     *
     * @param deletedBy the deletedBy value to set
     * @return the Flow object itself.
     */
    public Flow withDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
        return this;
    }

}
