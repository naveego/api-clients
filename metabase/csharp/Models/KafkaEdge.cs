// <auto-generated>
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.
// </auto-generated>

namespace Naveego.Metabase.Models
{
    using Newtonsoft.Json;
    using System.Linq;

    public partial class KafkaEdge
    {
        /// <summary>
        /// Initializes a new instance of the KafkaEdge class.
        /// </summary>
        public KafkaEdge()
        {
            CustomInit();
        }

        /// <summary>
        /// Initializes a new instance of the KafkaEdge class.
        /// </summary>
        public KafkaEdge(string topicTemplate = default(string))
        {
            TopicTemplate = topicTemplate;
            CustomInit();
        }

        /// <summary>
        /// An initialization method that performs custom operations like setting defaults
        /// </summary>
        partial void CustomInit();

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "topicTemplate")]
        public string TopicTemplate { get; set; }

    }
}
