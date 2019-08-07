/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Writeback model.
 */
public class Writeback {
    /**
     * The writebackId property.
     */
    @JsonProperty(value = "writebackId", required = true)
    private String writebackId;

    /**
     * Get the writebackId value.
     *
     * @return the writebackId value
     */
    public String writebackId() {
        return this.writebackId;
    }

    /**
     * Set the writebackId value.
     *
     * @param writebackId the writebackId value to set
     * @return the Writeback object itself.
     */
    public Writeback withWritebackId(String writebackId) {
        this.writebackId = writebackId;
        return this;
    }

}
