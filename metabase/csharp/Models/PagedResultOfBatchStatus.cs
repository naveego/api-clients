// <auto-generated>
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.
// </auto-generated>

namespace Naveego.Metabase.Models
{
    using Newtonsoft.Json;
    using System.Collections;
    using System.Collections.Generic;
    using System.Linq;

    public partial class PagedResultOfBatchStatus
    {
        /// <summary>
        /// Initializes a new instance of the PagedResultOfBatchStatus class.
        /// </summary>
        public PagedResultOfBatchStatus()
        {
            CustomInit();
        }

        /// <summary>
        /// Initializes a new instance of the PagedResultOfBatchStatus class.
        /// </summary>
        public PagedResultOfBatchStatus(int? pageSize = default(int?), long? currentPage = default(long?), long? totalItems = default(long?), IList<BatchStatus> items = default(IList<BatchStatus>))
        {
            PageSize = pageSize;
            CurrentPage = currentPage;
            TotalItems = totalItems;
            Items = items;
            CustomInit();
        }

        /// <summary>
        /// An initialization method that performs custom operations like setting defaults
        /// </summary>
        partial void CustomInit();

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "pageSize")]
        public int? PageSize { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "currentPage")]
        public long? CurrentPage { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "totalItems")]
        public long? TotalItems { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "items")]
        public IList<BatchStatus> Items { get; set; }

    }
}