/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The PluginCapabilities model.
 */
public class PluginCapabilities {
    /**
     * The canAcceptQueryBasedSchemas property.
     */
    @JsonProperty(value = "canAcceptQueryBasedSchemas")
    private Boolean canAcceptQueryBasedSchemas;

    /**
     * The canConfigure property.
     */
    @JsonProperty(value = "canConfigure")
    private Boolean canConfigure;

    /**
     * The canConfigureConnection property.
     */
    @JsonProperty(value = "canConfigureConnection")
    private Boolean canConfigureConnection;

    /**
     * The canConfigureQualityCheck property.
     */
    @JsonProperty(value = "canConfigureQualityCheck")
    private Boolean canConfigureQualityCheck;

    /**
     * The canConfigureQuery property.
     */
    @JsonProperty(value = "canConfigureQuery")
    private Boolean canConfigureQuery;

    /**
     * The canConfigureRealTime property.
     */
    @JsonProperty(value = "canConfigureRealTime")
    private Boolean canConfigureRealTime;

    /**
     * The canConfigureWrite property.
     */
    @JsonProperty(value = "canConfigureWrite")
    private Boolean canConfigureWrite;

    /**
     * The canDiscoverShapes property.
     */
    @JsonProperty(value = "canDiscoverShapes")
    private Boolean canDiscoverShapes;

    /**
     * The canProduceMultipleSchemas property.
     */
    @JsonProperty(value = "canProduceMultipleSchemas")
    private Boolean canProduceMultipleSchemas;

    /**
     * The canPublish property.
     */
    @JsonProperty(value = "canPublish")
    private Boolean canPublish;

    /**
     * The canUseOAuth property.
     */
    @JsonProperty(value = "canUseOAuth")
    private Boolean canUseOAuth;

    /**
     * The canWrite property.
     */
    @JsonProperty(value = "canWrite")
    private Boolean canWrite;

    /**
     * Get the canAcceptQueryBasedSchemas value.
     *
     * @return the canAcceptQueryBasedSchemas value
     */
    public Boolean canAcceptQueryBasedSchemas() {
        return this.canAcceptQueryBasedSchemas;
    }

    /**
     * Set the canAcceptQueryBasedSchemas value.
     *
     * @param canAcceptQueryBasedSchemas the canAcceptQueryBasedSchemas value to set
     * @return the PluginCapabilities object itself.
     */
    public PluginCapabilities withCanAcceptQueryBasedSchemas(Boolean canAcceptQueryBasedSchemas) {
        this.canAcceptQueryBasedSchemas = canAcceptQueryBasedSchemas;
        return this;
    }

    /**
     * Get the canConfigure value.
     *
     * @return the canConfigure value
     */
    public Boolean canConfigure() {
        return this.canConfigure;
    }

    /**
     * Set the canConfigure value.
     *
     * @param canConfigure the canConfigure value to set
     * @return the PluginCapabilities object itself.
     */
    public PluginCapabilities withCanConfigure(Boolean canConfigure) {
        this.canConfigure = canConfigure;
        return this;
    }

    /**
     * Get the canConfigureConnection value.
     *
     * @return the canConfigureConnection value
     */
    public Boolean canConfigureConnection() {
        return this.canConfigureConnection;
    }

    /**
     * Set the canConfigureConnection value.
     *
     * @param canConfigureConnection the canConfigureConnection value to set
     * @return the PluginCapabilities object itself.
     */
    public PluginCapabilities withCanConfigureConnection(Boolean canConfigureConnection) {
        this.canConfigureConnection = canConfigureConnection;
        return this;
    }

    /**
     * Get the canConfigureQualityCheck value.
     *
     * @return the canConfigureQualityCheck value
     */
    public Boolean canConfigureQualityCheck() {
        return this.canConfigureQualityCheck;
    }

    /**
     * Set the canConfigureQualityCheck value.
     *
     * @param canConfigureQualityCheck the canConfigureQualityCheck value to set
     * @return the PluginCapabilities object itself.
     */
    public PluginCapabilities withCanConfigureQualityCheck(Boolean canConfigureQualityCheck) {
        this.canConfigureQualityCheck = canConfigureQualityCheck;
        return this;
    }

    /**
     * Get the canConfigureQuery value.
     *
     * @return the canConfigureQuery value
     */
    public Boolean canConfigureQuery() {
        return this.canConfigureQuery;
    }

    /**
     * Set the canConfigureQuery value.
     *
     * @param canConfigureQuery the canConfigureQuery value to set
     * @return the PluginCapabilities object itself.
     */
    public PluginCapabilities withCanConfigureQuery(Boolean canConfigureQuery) {
        this.canConfigureQuery = canConfigureQuery;
        return this;
    }

    /**
     * Get the canConfigureRealTime value.
     *
     * @return the canConfigureRealTime value
     */
    public Boolean canConfigureRealTime() {
        return this.canConfigureRealTime;
    }

    /**
     * Set the canConfigureRealTime value.
     *
     * @param canConfigureRealTime the canConfigureRealTime value to set
     * @return the PluginCapabilities object itself.
     */
    public PluginCapabilities withCanConfigureRealTime(Boolean canConfigureRealTime) {
        this.canConfigureRealTime = canConfigureRealTime;
        return this;
    }

    /**
     * Get the canConfigureWrite value.
     *
     * @return the canConfigureWrite value
     */
    public Boolean canConfigureWrite() {
        return this.canConfigureWrite;
    }

    /**
     * Set the canConfigureWrite value.
     *
     * @param canConfigureWrite the canConfigureWrite value to set
     * @return the PluginCapabilities object itself.
     */
    public PluginCapabilities withCanConfigureWrite(Boolean canConfigureWrite) {
        this.canConfigureWrite = canConfigureWrite;
        return this;
    }

    /**
     * Get the canDiscoverShapes value.
     *
     * @return the canDiscoverShapes value
     */
    public Boolean canDiscoverShapes() {
        return this.canDiscoverShapes;
    }

    /**
     * Set the canDiscoverShapes value.
     *
     * @param canDiscoverShapes the canDiscoverShapes value to set
     * @return the PluginCapabilities object itself.
     */
    public PluginCapabilities withCanDiscoverShapes(Boolean canDiscoverShapes) {
        this.canDiscoverShapes = canDiscoverShapes;
        return this;
    }

    /**
     * Get the canProduceMultipleSchemas value.
     *
     * @return the canProduceMultipleSchemas value
     */
    public Boolean canProduceMultipleSchemas() {
        return this.canProduceMultipleSchemas;
    }

    /**
     * Set the canProduceMultipleSchemas value.
     *
     * @param canProduceMultipleSchemas the canProduceMultipleSchemas value to set
     * @return the PluginCapabilities object itself.
     */
    public PluginCapabilities withCanProduceMultipleSchemas(Boolean canProduceMultipleSchemas) {
        this.canProduceMultipleSchemas = canProduceMultipleSchemas;
        return this;
    }

    /**
     * Get the canPublish value.
     *
     * @return the canPublish value
     */
    public Boolean canPublish() {
        return this.canPublish;
    }

    /**
     * Set the canPublish value.
     *
     * @param canPublish the canPublish value to set
     * @return the PluginCapabilities object itself.
     */
    public PluginCapabilities withCanPublish(Boolean canPublish) {
        this.canPublish = canPublish;
        return this;
    }

    /**
     * Get the canUseOAuth value.
     *
     * @return the canUseOAuth value
     */
    public Boolean canUseOAuth() {
        return this.canUseOAuth;
    }

    /**
     * Set the canUseOAuth value.
     *
     * @param canUseOAuth the canUseOAuth value to set
     * @return the PluginCapabilities object itself.
     */
    public PluginCapabilities withCanUseOAuth(Boolean canUseOAuth) {
        this.canUseOAuth = canUseOAuth;
        return this;
    }

    /**
     * Get the canWrite value.
     *
     * @return the canWrite value
     */
    public Boolean canWrite() {
        return this.canWrite;
    }

    /**
     * Set the canWrite value.
     *
     * @param canWrite the canWrite value to set
     * @return the PluginCapabilities object itself.
     */
    public PluginCapabilities withCanWrite(Boolean canWrite) {
        this.canWrite = canWrite;
        return this;
    }

}