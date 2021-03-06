/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The KafkaEdge model.
 */
public class KafkaEdge {
    /**
     * The topicTemplate property.
     */
    @JsonProperty(value = "topicTemplate")
    private String topicTemplate;

    /**
     * Get the topicTemplate value.
     *
     * @return the topicTemplate value
     */
    public String topicTemplate() {
        return this.topicTemplate;
    }

    /**
     * Set the topicTemplate value.
     *
     * @param topicTemplate the topicTemplate value to set
     * @return the KafkaEdge object itself.
     */
    public KafkaEdge withTopicTemplate(String topicTemplate) {
        this.topicTemplate = topicTemplate;
        return this;
    }

}
