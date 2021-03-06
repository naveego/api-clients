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
 * Defines values for FilterRuleEffect.
 */
public final class FilterRuleEffect extends ExpandableStringEnum<FilterRuleEffect> {
    /** Static value include for FilterRuleEffect. */
    public static final FilterRuleEffect INCLUDE = fromString("include");

    /** Static value exclude for FilterRuleEffect. */
    public static final FilterRuleEffect EXCLUDE = fromString("exclude");

    /**
     * Creates or finds a FilterRuleEffect from its string representation.
     * @param name a name to look for
     * @return the corresponding FilterRuleEffect
     */
    @JsonCreator
    public static FilterRuleEffect fromString(String name) {
        return fromString(name, FilterRuleEffect.class);
    }

    /**
     * @return known FilterRuleEffect values
     */
    public static Collection<FilterRuleEffect> values() {
        return values(FilterRuleEffect.class);
    }
}
