// <auto-generated>
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.
// </auto-generated>

namespace Naveego.Metabase.Models
{
    using Newtonsoft.Json;
    using System.Linq;

    public partial class FilterRule
    {
        /// <summary>
        /// Initializes a new instance of the FilterRule class.
        /// </summary>
        public FilterRule()
        {
            CustomInit();
        }

        /// <summary>
        /// Initializes a new instance of the FilterRule class.
        /// </summary>
        /// <param name="effect">Possible values include: 'include',
        /// 'exclude'</param>
        public FilterRule(FilterRuleEffect? effect = default(FilterRuleEffect?), string propertyId = default(string), string operatorId = default(string), object parameter = default(object))
        {
            Effect = effect;
            PropertyId = propertyId;
            OperatorId = operatorId;
            Parameter = parameter;
            CustomInit();
        }

        /// <summary>
        /// An initialization method that performs custom operations like setting defaults
        /// </summary>
        partial void CustomInit();

        /// <summary>
        /// Gets or sets possible values include: 'include', 'exclude'
        /// </summary>
        [JsonProperty(PropertyName = "effect")]
        public FilterRuleEffect? Effect { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "propertyId")]
        public string PropertyId { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "operatorId")]
        public string OperatorId { get; set; }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "parameter")]
        public object Parameter { get; set; }

    }
}
