/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.naveego.metabase.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The PagedResultOfBatchStatus model.
 */
public class PagedResultOfBatchStatus {
    /**
     * The pageSize property.
     */
    @JsonProperty(value = "pageSize")
    private Integer pageSize;

    /**
     * The currentPage property.
     */
    @JsonProperty(value = "currentPage")
    private Long currentPage;

    /**
     * The totalItems property.
     */
    @JsonProperty(value = "totalItems")
    private Long totalItems;

    /**
     * The items property.
     */
    @JsonProperty(value = "items")
    private List<BatchStatus> items;

    /**
     * Get the pageSize value.
     *
     * @return the pageSize value
     */
    public Integer pageSize() {
        return this.pageSize;
    }

    /**
     * Set the pageSize value.
     *
     * @param pageSize the pageSize value to set
     * @return the PagedResultOfBatchStatus object itself.
     */
    public PagedResultOfBatchStatus withPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    /**
     * Get the currentPage value.
     *
     * @return the currentPage value
     */
    public Long currentPage() {
        return this.currentPage;
    }

    /**
     * Set the currentPage value.
     *
     * @param currentPage the currentPage value to set
     * @return the PagedResultOfBatchStatus object itself.
     */
    public PagedResultOfBatchStatus withCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    /**
     * Get the totalItems value.
     *
     * @return the totalItems value
     */
    public Long totalItems() {
        return this.totalItems;
    }

    /**
     * Set the totalItems value.
     *
     * @param totalItems the totalItems value to set
     * @return the PagedResultOfBatchStatus object itself.
     */
    public PagedResultOfBatchStatus withTotalItems(Long totalItems) {
        this.totalItems = totalItems;
        return this;
    }

    /**
     * Get the items value.
     *
     * @return the items value
     */
    public List<BatchStatus> items() {
        return this.items;
    }

    /**
     * Set the items value.
     *
     * @param items the items value to set
     * @return the PagedResultOfBatchStatus object itself.
     */
    public PagedResultOfBatchStatus withItems(List<BatchStatus> items) {
        this.items = items;
        return this;
    }

}
