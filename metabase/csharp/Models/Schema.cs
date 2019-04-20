// <auto-generated>
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.
// </auto-generated>

namespace Naveego.Metabase.Models
{
    using Microsoft.Rest;
    using Newtonsoft.Json;
    using System.Collections;
    using System.Collections.Generic;
    using System.Linq;

    public partial class Schema
    {
        /// <summary>
        /// Initializes a new instance of the Schema class.
        /// </summary>
        public Schema()
        {
            CustomInit();
        }

        /// <summary>
        /// Initializes a new instance of the Schema class.
        /// </summary>
        /// <param name="capability">Possible values include: 'read', 'write',
        /// 'readWrite', 'qualityCheck'</param>
        public Schema(string name, string id = default(string), int? version = default(int?), string description = default(string), string discoveredId = default(string), string discoveredName = default(string), string discoveredDescription = default(string), bool? isUserDefined = default(bool?), IList<SchemaProperty> properties = default(IList<SchemaProperty>), IDictionary<string, string> labels = default(IDictionary<string, string>), string query = default(string), string connectionId = default(string), string profilingJobId = default(string), bool? hasProfile = default(bool?), string publisherMetaJson = default(string), SchemaCapability? capability = default(SchemaCapability?), SchemaForm form = default(SchemaForm), IDictionary<string, string> templateDimensions = default(IDictionary<string, string>), System.DateTime? createdAt = default(System.DateTime?), string createdBy = default(string), System.DateTime? updatedAt = default(System.DateTime?), string updatedBy = default(string), System.DateTime? deletedAt = default(System.DateTime?), string deletedBy = default(string))
        {
            Id = id;
            Version = version;
            Name = name;
            Description = description;
            DiscoveredId = discoveredId;
            DiscoveredName = discoveredName;
            DiscoveredDescription = discoveredDescription;
            IsUserDefined = isUserDefined;
            Properties = properties;
            Labels = labels;
            Query = query;
            ConnectionId = connectionId;
            ProfilingJobId = profilingJobId;
            HasProfile = hasProfile;
            PublisherMetaJson = publisherMetaJson;
            Capability = capability;
            Form = form;
            TemplateDimensions = templateDimensions;
            CreatedAt = createdAt;
            CreatedBy = createdBy;
            UpdatedAt = updatedAt;
            UpdatedBy = updatedBy;
            DeletedAt = deletedAt;
            DeletedBy = deletedBy;
            CustomInit();
        }

        /// <summary>
        /// An initialization method that performs custom operations like setting defaults
        /// </summary>
        partial void CustomInit();

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "id")]
        public string Id { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "version")]
        public int? Version { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "name")]
        public string Name { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "description")]
        public string Description { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "discoveredId")]
        public string DiscoveredId { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "discoveredName")]
        public string DiscoveredName { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "discoveredDescription")]
        public string DiscoveredDescription { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "isUserDefined")]
        public bool? IsUserDefined { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "properties")]
        public IList<SchemaProperty> Properties { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "labels")]
        public IDictionary<string, string> Labels { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "query")]
        public string Query { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "connectionId")]
        public string ConnectionId { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "profilingJobId")]
        public string ProfilingJobId { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "hasProfile")]
        public bool? HasProfile { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "publisherMetaJson")]
        public string PublisherMetaJson { get; set; }

        /// <summary>
        /// Gets or sets possible values include: 'read', 'write', 'readWrite',
        /// 'qualityCheck'
        /// </summary>
        [JsonProperty(PropertyName = "capability")]
        public SchemaCapability? Capability { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "form")]
        public SchemaForm Form { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "templateDimensions")]
        public IDictionary<string, string> TemplateDimensions { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "createdAt")]
        public System.DateTime? CreatedAt { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "createdBy")]
        public string CreatedBy { get; set; }

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
        [JsonProperty(PropertyName = "deletedAt")]
        public System.DateTime? DeletedAt { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "deletedBy")]
        public string DeletedBy { get; set; }

        /// <summary>
        /// Validate the object.
        /// </summary>
        /// <exception cref="ValidationException">
        /// Thrown if validation fails
        /// </exception>
        public virtual void Validate()
        {
            if (Name == null)
            {
                throw new ValidationException(ValidationRules.CannotBeNull, "Name");
            }
        }
    }
}
