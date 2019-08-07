/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

/**
 * The JobStatus model.
 */
public class JobStatus {
    /**
     * The resourceId property.
     */
    @JsonProperty(value = "resourceId")
    private String resourceId;

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
     * The goBetween property.
     */
    @JsonProperty(value = "goBetween")
    private JobStatusGoBetweenScope goBetween;

    /**
     * The realTime property.
     */
    @JsonProperty(value = "realTime")
    private RealTimeStateScope realTime;

    /**
     * Get the resourceId value.
     *
     * @return the resourceId value
     */
    public String resourceId() {
        return this.resourceId;
    }

    /**
     * Set the resourceId value.
     *
     * @param resourceId the resourceId value to set
     * @return the JobStatus object itself.
     */
    public JobStatus withResourceId(String resourceId) {
        this.resourceId = resourceId;
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
     * @return the JobStatus object itself.
     */
    public JobStatus withUpdatedAt(DateTime updatedAt) {
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
     * @return the JobStatus object itself.
     */
    public JobStatus withUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    /**
     * Get the goBetween value.
     *
     * @return the goBetween value
     */
    public JobStatusGoBetweenScope goBetween() {
        return this.goBetween;
    }

    /**
     * Set the goBetween value.
     *
     * @param goBetween the goBetween value to set
     * @return the JobStatus object itself.
     */
    public JobStatus withGoBetween(JobStatusGoBetweenScope goBetween) {
        this.goBetween = goBetween;
        return this;
    }

    /**
     * Get the realTime value.
     *
     * @return the realTime value
     */
    public RealTimeStateScope realTime() {
        return this.realTime;
    }

    /**
     * Set the realTime value.
     *
     * @param realTime the realTime value to set
     * @return the JobStatus object itself.
     */
    public JobStatus withRealTime(RealTimeStateScope realTime) {
        this.realTime = realTime;
        return this;
    }

}
