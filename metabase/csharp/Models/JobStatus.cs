// <auto-generated>
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.
// </auto-generated>

namespace Naveego.Metabase.Models
{
    using Newtonsoft.Json;
    using System.Linq;

    public partial class JobStatus
    {
        /// <summary>
        /// Initializes a new instance of the JobStatus class.
        /// </summary>
        public JobStatus()
        {
            CustomInit();
        }

        /// <summary>
        /// Initializes a new instance of the JobStatus class.
        /// </summary>
        public JobStatus(string resourceId = default(string), System.DateTime? updatedAt = default(System.DateTime?), string updatedBy = default(string), JobStatusGoBetweenScope goBetween = default(JobStatusGoBetweenScope), RealTimeStateScope realTime = default(RealTimeStateScope))
        {
            ResourceId = resourceId;
            UpdatedAt = updatedAt;
            UpdatedBy = updatedBy;
            GoBetween = goBetween;
            RealTime = realTime;
            CustomInit();
        }

        /// <summary>
        /// An initialization method that performs custom operations like setting defaults
        /// </summary>
        partial void CustomInit();

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "resourceId")]
        public string ResourceId { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "updatedAt")]
        public System.DateTime? UpdatedAt { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "updatedBy")]
        public string UpdatedBy { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "goBetween")]
        public JobStatusGoBetweenScope GoBetween { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "realTime")]
        public RealTimeStateScope RealTime { get; set; }

    }
}