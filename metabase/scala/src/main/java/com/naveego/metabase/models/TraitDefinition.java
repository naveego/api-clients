/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The TraitDefinition model.
 */
public class TraitDefinition {
    /**
     * The id property.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * The name property.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * The family property.
     */
    @JsonProperty(value = "family")
    private String family;

    /**
     * The order property.
     */
    @JsonProperty(value = "order")
    private Integer order;

    /**
     * The description property.
     */
    @JsonProperty(value = "description")
    private String description;

    /**
     * The help property.
     */
    @JsonProperty(value = "help")
    private String help;

    /**
     * The attributes property.
     */
    @JsonProperty(value = "attributes")
    private List<TraitAttributeDefinition> attributes;

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
     * @return the TraitDefinition object itself.
     */
    public TraitDefinition withId(String id) {
        this.id = id;
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
     * @return the TraitDefinition object itself.
     */
    public TraitDefinition withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the family value.
     *
     * @return the family value
     */
    public String family() {
        return this.family;
    }

    /**
     * Set the family value.
     *
     * @param family the family value to set
     * @return the TraitDefinition object itself.
     */
    public TraitDefinition withFamily(String family) {
        this.family = family;
        return this;
    }

    /**
     * Get the order value.
     *
     * @return the order value
     */
    public Integer order() {
        return this.order;
    }

    /**
     * Set the order value.
     *
     * @param order the order value to set
     * @return the TraitDefinition object itself.
     */
    public TraitDefinition withOrder(Integer order) {
        this.order = order;
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
     * @return the TraitDefinition object itself.
     */
    public TraitDefinition withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the help value.
     *
     * @return the help value
     */
    public String help() {
        return this.help;
    }

    /**
     * Set the help value.
     *
     * @param help the help value to set
     * @return the TraitDefinition object itself.
     */
    public TraitDefinition withHelp(String help) {
        this.help = help;
        return this;
    }

    /**
     * Get the attributes value.
     *
     * @return the attributes value
     */
    public List<TraitAttributeDefinition> attributes() {
        return this.attributes;
    }

    /**
     * Set the attributes value.
     *
     * @param attributes the attributes value to set
     * @return the TraitDefinition object itself.
     */
    public TraitDefinition withAttributes(List<TraitAttributeDefinition> attributes) {
        this.attributes = attributes;
        return this;
    }

}
