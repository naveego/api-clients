/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import org.joda.time.DateTime;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The BatchStatusGoBetweenScope model.
 */
public class BatchStatusGoBetweenScope {
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
     * The startedOnAgent property.
     */
    @JsonProperty(value = "startedOnAgent")
    private String startedOnAgent;

    /**
     * The startedAt property.
     */
    @JsonProperty(value = "startedAt")
    private DateTime startedAt;

    /**
     * The expectedToEndBefore property.
     */
    @JsonProperty(value = "expectedToEndBefore")
    private DateTime expectedToEndBefore;

    /**
     * The endedAt property.
     */
    @JsonProperty(value = "endedAt")
    private DateTime endedAt;

    /**
     * The expectedCount property.
     */
    @JsonProperty(value = "expectedCount")
    private Integer expectedCount;

    /**
     * The dataPointsPerMinute property.
     */
    @JsonProperty(value = "dataPointsPerMinute")
    private Double dataPointsPerMinute;

    /**
     * The count property.
     */
    @JsonProperty(value = "count")
    private Integer count;

    /**
     * The filteredCount property.
     */
    @JsonProperty(value = "filteredCount")
    private Integer filteredCount;

    /**
     * The deflectedCount property.
     */
    @JsonProperty(value = "deflectedCount")
    private Integer deflectedCount;

    /**
     * The badRecordCount property.
     */
    @JsonProperty(value = "badRecordCount")
    private Integer badRecordCount;

    /**
     * The endedReason property.
     */
    @JsonProperty(value = "endedReason")
    private String endedReason;

    /**
     * The endedMessage property.
     */
    @JsonProperty(value = "endedMessage")
    private String endedMessage;

    /**
     * The badRecordSample property.
     */
    @JsonProperty(value = "badRecordSample")
    private List<Map<String, Object>> badRecordSample;

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
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withResourceId(String resourceId) {
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
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withUpdatedAt(DateTime updatedAt) {
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
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    /**
     * Get the startedOnAgent value.
     *
     * @return the startedOnAgent value
     */
    public String startedOnAgent() {
        return this.startedOnAgent;
    }

    /**
     * Set the startedOnAgent value.
     *
     * @param startedOnAgent the startedOnAgent value to set
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withStartedOnAgent(String startedOnAgent) {
        this.startedOnAgent = startedOnAgent;
        return this;
    }

    /**
     * Get the startedAt value.
     *
     * @return the startedAt value
     */
    public DateTime startedAt() {
        return this.startedAt;
    }

    /**
     * Set the startedAt value.
     *
     * @param startedAt the startedAt value to set
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withStartedAt(DateTime startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    /**
     * Get the expectedToEndBefore value.
     *
     * @return the expectedToEndBefore value
     */
    public DateTime expectedToEndBefore() {
        return this.expectedToEndBefore;
    }

    /**
     * Set the expectedToEndBefore value.
     *
     * @param expectedToEndBefore the expectedToEndBefore value to set
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withExpectedToEndBefore(DateTime expectedToEndBefore) {
        this.expectedToEndBefore = expectedToEndBefore;
        return this;
    }

    /**
     * Get the endedAt value.
     *
     * @return the endedAt value
     */
    public DateTime endedAt() {
        return this.endedAt;
    }

    /**
     * Set the endedAt value.
     *
     * @param endedAt the endedAt value to set
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withEndedAt(DateTime endedAt) {
        this.endedAt = endedAt;
        return this;
    }

    /**
     * Get the expectedCount value.
     *
     * @return the expectedCount value
     */
    public Integer expectedCount() {
        return this.expectedCount;
    }

    /**
     * Set the expectedCount value.
     *
     * @param expectedCount the expectedCount value to set
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withExpectedCount(Integer expectedCount) {
        this.expectedCount = expectedCount;
        return this;
    }

    /**
     * Get the dataPointsPerMinute value.
     *
     * @return the dataPointsPerMinute value
     */
    public Double dataPointsPerMinute() {
        return this.dataPointsPerMinute;
    }

    /**
     * Set the dataPointsPerMinute value.
     *
     * @param dataPointsPerMinute the dataPointsPerMinute value to set
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withDataPointsPerMinute(Double dataPointsPerMinute) {
        this.dataPointsPerMinute = dataPointsPerMinute;
        return this;
    }

    /**
     * Get the count value.
     *
     * @return the count value
     */
    public Integer count() {
        return this.count;
    }

    /**
     * Set the count value.
     *
     * @param count the count value to set
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withCount(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * Get the filteredCount value.
     *
     * @return the filteredCount value
     */
    public Integer filteredCount() {
        return this.filteredCount;
    }

    /**
     * Set the filteredCount value.
     *
     * @param filteredCount the filteredCount value to set
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withFilteredCount(Integer filteredCount) {
        this.filteredCount = filteredCount;
        return this;
    }

    /**
     * Get the deflectedCount value.
     *
     * @return the deflectedCount value
     */
    public Integer deflectedCount() {
        return this.deflectedCount;
    }

    /**
     * Set the deflectedCount value.
     *
     * @param deflectedCount the deflectedCount value to set
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withDeflectedCount(Integer deflectedCount) {
        this.deflectedCount = deflectedCount;
        return this;
    }

    /**
     * Get the badRecordCount value.
     *
     * @return the badRecordCount value
     */
    public Integer badRecordCount() {
        return this.badRecordCount;
    }

    /**
     * Set the badRecordCount value.
     *
     * @param badRecordCount the badRecordCount value to set
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withBadRecordCount(Integer badRecordCount) {
        this.badRecordCount = badRecordCount;
        return this;
    }

    /**
     * Get the endedReason value.
     *
     * @return the endedReason value
     */
    public String endedReason() {
        return this.endedReason;
    }

    /**
     * Set the endedReason value.
     *
     * @param endedReason the endedReason value to set
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withEndedReason(String endedReason) {
        this.endedReason = endedReason;
        return this;
    }

    /**
     * Get the endedMessage value.
     *
     * @return the endedMessage value
     */
    public String endedMessage() {
        return this.endedMessage;
    }

    /**
     * Set the endedMessage value.
     *
     * @param endedMessage the endedMessage value to set
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withEndedMessage(String endedMessage) {
        this.endedMessage = endedMessage;
        return this;
    }

    /**
     * Get the badRecordSample value.
     *
     * @return the badRecordSample value
     */
    public List<Map<String, Object>> badRecordSample() {
        return this.badRecordSample;
    }

    /**
     * Set the badRecordSample value.
     *
     * @param badRecordSample the badRecordSample value to set
     * @return the BatchStatusGoBetweenScope object itself.
     */
    public BatchStatusGoBetweenScope withBadRecordSample(List<Map<String, Object>> badRecordSample) {
        this.badRecordSample = badRecordSample;
        return this;
    }

}
