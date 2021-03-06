/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

import java.util.Collection;

/**
 * Defines values for PropertyIdMeaning.
 */
public final class PropertyIdMeaning extends ExpandableStringEnum<PropertyIdMeaning> {
    /** Static value primaryDataPropertyId for PropertyIdMeaning. */
    public static final PropertyIdMeaning PRIMARY_DATA_PROPERTY_ID = fromString("primaryDataPropertyId");

    /** Static value schemaDataPropertyId for PropertyIdMeaning. */
    public static final PropertyIdMeaning SCHEMA_DATA_PROPERTY_ID = fromString("schemaDataPropertyId");

    /** Static value enrichedDataPropertyId for PropertyIdMeaning. */
    public static final PropertyIdMeaning ENRICHED_DATA_PROPERTY_ID = fromString("enrichedDataPropertyId");

    /**
     * Creates or finds a PropertyIdMeaning from its string representation.
     * @param name a name to look for
     * @return the corresponding PropertyIdMeaning
     */
    @JsonCreator
    public static PropertyIdMeaning fromString(String name) {
        return fromString(name, PropertyIdMeaning.class);
    }

    /**
     * @return known PropertyIdMeaning values
     */
    public static Collection<PropertyIdMeaning> values() {
        return values(PropertyIdMeaning.class);
    }
}
