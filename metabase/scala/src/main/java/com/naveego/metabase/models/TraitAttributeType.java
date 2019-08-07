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
 * Defines values for TraitAttributeType.
 */
public final class TraitAttributeType extends ExpandableStringEnum<TraitAttributeType> {
    /** Static value string for TraitAttributeType. */
    public static final TraitAttributeType STRING = fromString("string");

    /** Static value count for TraitAttributeType. */
    public static final TraitAttributeType COUNT = fromString("count");

    /** Static value percent for TraitAttributeType. */
    public static final TraitAttributeType PERCENT = fromString("percent");

    /** Static value statistic for TraitAttributeType. */
    public static final TraitAttributeType STATISTIC = fromString("statistic");

    /** Static value details for TraitAttributeType. */
    public static final TraitAttributeType DETAILS = fromString("details");

    /** Static value histogram for TraitAttributeType. */
    public static final TraitAttributeType HISTOGRAM = fromString("histogram");

    /** Static value boxplot for TraitAttributeType. */
    public static final TraitAttributeType BOXPLOT = fromString("boxplot");

    /**
     * Creates or finds a TraitAttributeType from its string representation.
     * @param name a name to look for
     * @return the corresponding TraitAttributeType
     */
    @JsonCreator
    public static TraitAttributeType fromString(String name) {
        return fromString(name, TraitAttributeType.class);
    }

    /**
     * @return known TraitAttributeType values
     */
    public static Collection<TraitAttributeType> values() {
        return values(TraitAttributeType.class);
    }
}
