/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Filter model.
 */
public class Filter {
    /**
     * The rules property.
     */
    @JsonProperty(value = "rules")
    private List<FilterRule> rules;

    /**
     * Get the rules value.
     *
     * @return the rules value
     */
    public List<FilterRule> rules() {
        return this.rules;
    }

    /**
     * Set the rules value.
     *
     * @param rules the rules value to set
     * @return the Filter object itself.
     */
    public Filter withRules(List<FilterRule> rules) {
        this.rules = rules;
        return this;
    }

}
