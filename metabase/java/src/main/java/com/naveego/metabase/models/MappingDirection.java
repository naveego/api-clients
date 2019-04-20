/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for MappingDirection.
 */
public final class MappingDirection extends ExpandableStringEnum<MappingDirection> {
    /** Static value schemaToShape for MappingDirection. */
    public static final MappingDirection SCHEMA_TO_SHAPE = fromString("schemaToShape");

    /** Static value shapeToSchema for MappingDirection. */
    public static final MappingDirection SHAPE_TO_SCHEMA = fromString("shapeToSchema");

    /**
     * Creates or finds a MappingDirection from its string representation.
     * @param name a name to look for
     * @return the corresponding MappingDirection
     */
    @JsonCreator
    public static MappingDirection fromString(String name) {
        return fromString(name, MappingDirection.class);
    }

    /**
     * @return known MappingDirection values
     */
    public static Collection<MappingDirection> values() {
        return values(MappingDirection.class);
    }
}
