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
 * Defines values for SchemaCapability.
 */
public final class SchemaCapability extends ExpandableStringEnum<SchemaCapability> {
    /** Static value read for SchemaCapability. */
    public static final SchemaCapability READ = fromString("read");

    /** Static value write for SchemaCapability. */
    public static final SchemaCapability WRITE = fromString("write");

    /** Static value readWrite for SchemaCapability. */
    public static final SchemaCapability READ_WRITE = fromString("readWrite");

    /** Static value qualityCheck for SchemaCapability. */
    public static final SchemaCapability QUALITY_CHECK = fromString("qualityCheck");

    /**
     * Creates or finds a SchemaCapability from its string representation.
     * @param name a name to look for
     * @return the corresponding SchemaCapability
     */
    @JsonCreator
    public static SchemaCapability fromString(String name) {
        return fromString(name, SchemaCapability.class);
    }

    /**
     * @return known SchemaCapability values
     */
    public static Collection<SchemaCapability> values() {
        return values(SchemaCapability.class);
    }
}
