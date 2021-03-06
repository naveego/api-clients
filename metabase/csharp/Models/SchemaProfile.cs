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

    public partial class SchemaProfile
    {
        /// <summary>
        /// Initializes a new instance of the SchemaProfile class.
        /// </summary>
        public SchemaProfile()
        {
            CustomInit();
        }

        /// <summary>
        /// Initializes a new instance of the SchemaProfile class.
        /// </summary>
        public SchemaProfile(string name, string id = default(string), int? version = default(int?), string description = default(string), int? schemaVersion = default(int?), string connectionId = default(string), long? count = default(long?), System.DateTime? startedOn = default(System.DateTime?), System.DateTime? completedOn = default(System.DateTime?), IList<TraitDefinition> traitDefinitions = default(IList<TraitDefinition>), IList<SchemaTrait> schemaTraits = default(IList<SchemaTrait>), IList<PropertyTrait> propertyTraits = default(IList<PropertyTrait>), System.DateTime? createdAt = default(System.DateTime?), string createdBy = default(string), System.DateTime? updatedAt = default(System.DateTime?), string updatedBy = default(string), System.DateTime? deletedAt = default(System.DateTime?), string deletedBy = default(string))
        {
            Id = id;
            Version = version;
            Name = name;
            Description = description;
            SchemaVersion = schemaVersion;
            ConnectionId = connectionId;
            Count = count;
            StartedOn = startedOn;
            CompletedOn = completedOn;
            TraitDefinitions = traitDefinitions;
            SchemaTraits = schemaTraits;
            PropertyTraits = propertyTraits;
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
        [JsonProperty(PropertyName = "schemaVersion")]
        public int? SchemaVersion { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "connectionId")]
        public string ConnectionId { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "count")]
        public long? Count { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "startedOn")]
        public System.DateTime? StartedOn { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "completedOn")]
        public System.DateTime? CompletedOn { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "traitDefinitions")]
        public IList<TraitDefinition> TraitDefinitions { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "schemaTraits")]
        public IList<SchemaTrait> SchemaTraits { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "propertyTraits")]
        public IList<PropertyTrait> PropertyTraits { get; set; }

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
