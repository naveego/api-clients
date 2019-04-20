/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Batch model.
 */
public class Batch {
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
     * The jobId property.
     */
    @JsonProperty(value = "jobId", required = true)
    private String jobId;

    /**
     * The status property.
     */
    @JsonProperty(value = "status")
    private BatchStatus status;

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
     * @return the Batch object itself.
     */
    public Batch withId(String id) {
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
     * @return the Batch object itself.
     */
    public Batch withVersion(Integer version) {
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
     * @return the Batch object itself.
     */
    public Batch withName(String name) {
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
     * @return the Batch object itself.
     */
    public Batch withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the jobId value.
     *
     * @return the jobId value
     */
    public String jobId() {
        return this.jobId;
    }

    /**
     * Set the jobId value.
     *
     * @param jobId the jobId value to set
     * @return the Batch object itself.
     */
    public Batch withJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    /**
     * Get the status value.
     *
     * @return the status value
     */
    public BatchStatus status() {
        return this.status;
    }

    /**
     * Set the status value.
     *
     * @param status the status value to set
     * @return the Batch object itself.
     */
    public Batch withStatus(BatchStatus status) {
        this.status = status;
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
     * @return the Batch object itself.
     */
    public Batch withCreatedAt(DateTime createdAt) {
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
     * @return the Batch object itself.
     */
    public Batch withCreatedBy(String createdBy) {
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
     * @return the Batch object itself.
     */
    public Batch withUpdatedAt(DateTime updatedAt) {
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
     * @return the Batch object itself.
     */
    public Batch withUpdatedBy(String updatedBy) {
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
     * @return the Batch object itself.
     */
    public Batch withDeletedAt(DateTime deletedAt) {
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
     * @return the Batch object itself.
     */
    public Batch withDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
        return this;
    }

}
