// <auto-generated>
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.
// </auto-generated>

namespace Naveego.Metabase.Models
{
    using Newtonsoft.Json;
    using System.Linq;

    public partial class MapNode
    {
        /// <summary>
        /// Initializes a new instance of the MapNode class.
        /// </summary>
        public MapNode()
        {
            CustomInit();
        }

        /// <summary>
        /// Initializes a new instance of the MapNode class.
        /// </summary>
        public MapNode(string mappingId = default(string))
        {
            MappingId = mappingId;
            CustomInit();
        }

        /// <summary>
        /// An initialization method that performs custom operations like setting defaults
        /// </summary>
        partial void CustomInit();

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "mappingId")]
        public string MappingId { get; set; }

    }
}