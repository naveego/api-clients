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
 * Defines values for EdgeType.
 */
public final class EdgeType extends ExpandableStringEnum<EdgeType> {
    /** Static value unknown for EdgeType. */
    public static final EdgeType UNKNOWN = fromString("unknown");

    /** Static value inProcess for EdgeType. */
    public static final EdgeType IN_PROCESS = fromString("inProcess");

    /** Static value kafka for EdgeType. */
    public static final EdgeType KAFKA = fromString("kafka");

    /** Static value http for EdgeType. */
    public static final EdgeType HTTP = fromString("http");

    /**
     * Creates or finds a EdgeType from its string representation.
     * @param name a name to look for
     * @return the corresponding EdgeType
     */
    @JsonCreator
    public static EdgeType fromString(String name) {
        return fromString(name, EdgeType.class);
    }

    /**
     * @return known EdgeType values
     */
    public static Collection<EdgeType> values() {
        return values(EdgeType.class);
    }
}
