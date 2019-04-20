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

    public partial class Shape
    {
        /// <summary>
        /// Initializes a new instance of the Shape class.
        /// </summary>
        public Shape()
        {
            CustomInit();
        }

        /// <summary>
        /// Initializes a new instance of the Shape class.
        /// </summary>
        public Shape(string name, string id = default(string), int? version = default(int?), string description = default(string), IList<ShapeProperty> properties = default(IList<ShapeProperty>), IDictionary<string, string> labels = default(IDictionary<string, string>), bool? isMdmShape = default(bool?), MatchRule matchRule = default(MatchRule), MergeRule mergeRule = default(MergeRule), string copiedFromSchemaId = default(string), System.DateTime? createdAt = default(System.DateTime?), string createdBy = default(string), System.DateTime? updatedAt = default(System.DateTime?), string updatedBy = default(string), System.DateTime? deletedAt = default(System.DateTime?), string deletedBy = default(string))
        {
            Id = id;
            Version = version;
            Name = name;
            Description = description;
            Properties = properties;
            Labels = labels;
            IsMdmShape = isMdmShape;
            MatchRule = matchRule;
            MergeRule = mergeRule;
            CopiedFromSchemaId = copiedFromSchemaId;
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
        [JsonProperty(PropertyName = "properties")]
        public IList<ShapeProperty> Properties { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "labels")]
        public IDictionary<string, string> Labels { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "isMdmShape")]
        public bool? IsMdmShape { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "matchRule")]
        public MatchRule MatchRule { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "mergeRule")]
        public MergeRule MergeRule { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "copiedFromSchemaId")]
        public string CopiedFromSchemaId { get; set; }

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
            if (MatchRule != null)
            {
                MatchRule.Validate();
            }
        }
    }
}
