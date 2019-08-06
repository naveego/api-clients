/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.util.List;

/**
 * The SchemaProfile model.
 */
public class SchemaProfile {
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
     * The schemaVersion property.
     */
    @JsonProperty(value = "schemaVersion")
    private Integer schemaVersion;

    /**
     * The connectionId property.
     */
    @JsonProperty(value = "connectionId")
    private String connectionId;

    /**
     * The count property.
     */
    @JsonProperty(value = "count")
    private Long count;

    /**
     * The startedOn property.
     */
    @JsonProperty(value = "startedOn")
    private DateTime startedOn;

    /**
     * The completedOn property.
     */
    @JsonProperty(value = "completedOn")
    private DateTime completedOn;

    /**
     * The traitDefinitions property.
     */
    @JsonProperty(value = "traitDefinitions")
    private List<TraitDefinition> traitDefinitions;

    /**
     * The schemaTraits property.
     */
    @JsonProperty(value = "schemaTraits")
    private List<SchemaTrait> schemaTraits;

    /**
     * The propertyTraits property.
     */
    @JsonProperty(value = "propertyTraits")
    private List<PropertyTrait> propertyTraits;

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
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withId(String id) {
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
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withVersion(Integer version) {
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
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withName(String name) {
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
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the schemaVersion value.
     *
     * @return the schemaVersion value
     */
    public Integer schemaVersion() {
        return this.schemaVersion;
    }

    /**
     * Set the schemaVersion value.
     *
     * @param schemaVersion the schemaVersion value to set
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withSchemaVersion(Integer schemaVersion) {
        this.schemaVersion = schemaVersion;
        return this;
    }

    /**
     * Get the connectionId value.
     *
     * @return the connectionId value
     */
    public String connectionId() {
        return this.connectionId;
    }

    /**
     * Set the connectionId value.
     *
     * @param connectionId the connectionId value to set
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withConnectionId(String connectionId) {
        this.connectionId = connectionId;
        return this;
    }

    /**
     * Get the count value.
     *
     * @return the count value
     */
    public Long count() {
        return this.count;
    }

    /**
     * Set the count value.
     *
     * @param count the count value to set
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withCount(Long count) {
        this.count = count;
        return this;
    }

    /**
     * Get the startedOn value.
     *
     * @return the startedOn value
     */
    public DateTime startedOn() {
        return this.startedOn;
    }

    /**
     * Set the startedOn value.
     *
     * @param startedOn the startedOn value to set
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withStartedOn(DateTime startedOn) {
        this.startedOn = startedOn;
        return this;
    }

    /**
     * Get the completedOn value.
     *
     * @return the completedOn value
     */
    public DateTime completedOn() {
        return this.completedOn;
    }

    /**
     * Set the completedOn value.
     *
     * @param completedOn the completedOn value to set
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withCompletedOn(DateTime completedOn) {
        this.completedOn = completedOn;
        return this;
    }

    /**
     * Get the traitDefinitions value.
     *
     * @return the traitDefinitions value
     */
    public List<TraitDefinition> traitDefinitions() {
        return this.traitDefinitions;
    }

    /**
     * Set the traitDefinitions value.
     *
     * @param traitDefinitions the traitDefinitions value to set
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withTraitDefinitions(List<TraitDefinition> traitDefinitions) {
        this.traitDefinitions = traitDefinitions;
        return this;
    }

    /**
     * Get the schemaTraits value.
     *
     * @return the schemaTraits value
     */
    public List<SchemaTrait> schemaTraits() {
        return this.schemaTraits;
    }

    /**
     * Set the schemaTraits value.
     *
     * @param schemaTraits the schemaTraits value to set
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withSchemaTraits(List<SchemaTrait> schemaTraits) {
        this.schemaTraits = schemaTraits;
        return this;
    }

    /**
     * Get the propertyTraits value.
     *
     * @return the propertyTraits value
     */
    public List<PropertyTrait> propertyTraits() {
        return this.propertyTraits;
    }

    /**
     * Set the propertyTraits value.
     *
     * @param propertyTraits the propertyTraits value to set
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withPropertyTraits(List<PropertyTrait> propertyTraits) {
        this.propertyTraits = propertyTraits;
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
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withCreatedAt(DateTime createdAt) {
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
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withCreatedBy(String createdBy) {
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
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withUpdatedAt(DateTime updatedAt) {
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
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withUpdatedBy(String updatedBy) {
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
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withDeletedAt(DateTime deletedAt) {
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
     * @return the SchemaProfile object itself.
     */
    public SchemaProfile withDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
        return this;
    }

}
