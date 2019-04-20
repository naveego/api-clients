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

    public partial class PropertyTrait
    {
        /// <summary>
        /// Initializes a new instance of the PropertyTrait class.
        /// </summary>
        public PropertyTrait()
        {
            CustomInit();
        }

        /// <summary>
        /// Initializes a new instance of the PropertyTrait class.
        /// </summary>
        public PropertyTrait(string propertyId = default(string), string id = default(string), string error = default(string), IDictionary<string, object> attributeValues = default(IDictionary<string, object>))
        {
            PropertyId = propertyId;
            Id = id;
            Error = error;
            AttributeValues = attributeValues;
            CustomInit();
        }

        /// <summary>
        /// An initialization method that performs custom operations like setting defaults
        /// </summary>
        partial void CustomInit();

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "propertyId")]
        public string PropertyId { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "id")]
        public string Id { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "error")]
        public string Error { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "attributeValues")]
        public IDictionary<string, object> AttributeValues { get; set; }

    }
}
