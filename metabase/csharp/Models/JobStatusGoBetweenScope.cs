// <auto-generated>
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.
// </auto-generated>

namespace Naveego.Metabase.Models
{
    using Newtonsoft.Json;
    using System.Linq;

    public partial class JobStatusGoBetweenScope
    {
        /// <summary>
        /// Initializes a new instance of the JobStatusGoBetweenScope class.
        /// </summary>
        public JobStatusGoBetweenScope()
        {
            CustomInit();
        }

        /// <summary>
        /// Initializes a new instance of the JobStatusGoBetweenScope class.
        /// </summary>
        public JobStatusGoBetweenScope(string resourceId = default(string), System.DateTime? updatedAt = default(System.DateTime?), string updatedBy = default(string), string error = default(string), string message = default(string), int? startCount = default(int?), int? successCount = default(int?), int? consecutiveFailureCount = default(int?), string state = default(string), System.DateTime? nextRunAt = default(System.DateTime?), System.DateTime? previousRunAt = default(System.DateTime?), string scheduledOn = default(string), System.DateTime? scheduledAt = default(System.DateTime?))
        {
            ResourceId = resourceId;
            UpdatedAt = updatedAt;
            UpdatedBy = updatedBy;
            Error = error;
            Message = message;
            StartCount = startCount;
            SuccessCount = successCount;
            ConsecutiveFailureCount = consecutiveFailureCount;
            State = state;
            NextRunAt = nextRunAt;
            PreviousRunAt = previousRunAt;
            ScheduledOn = scheduledOn;
            ScheduledAt = scheduledAt;
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
        [JsonProperty(PropertyName = "error")]
        public string Error { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "message")]
        public string Message { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "startCount")]
        public int? StartCount { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "successCount")]
        public int? SuccessCount { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "consecutiveFailureCount")]
        public int? ConsecutiveFailureCount { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "state")]
        public string State { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "nextRunAt")]
        public System.DateTime? NextRunAt { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "previousRunAt")]
        public System.DateTime? PreviousRunAt { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "scheduledOn")]
        public string ScheduledOn { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "scheduledAt")]
        public System.DateTime? ScheduledAt { get; set; }

    }
}
