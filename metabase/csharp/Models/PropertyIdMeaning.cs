// <auto-generated>
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.
// </auto-generated>

namespace Naveego.Metabase.Models
{
    using Newtonsoft.Json;

    /// <summary>
    /// Defines values for PropertyIdMeaning.
    /// </summary>
    /// <summary>
    /// Determine base value for a given allowed value if exists, else return
    /// the value itself
    /// </summary>
    [JsonConverter(typeof(PropertyIdMeaningConverter))]
    public struct PropertyIdMeaning : System.IEquatable<PropertyIdMeaning>
    {
        private PropertyIdMeaning(string underlyingValue)
        {
            UnderlyingValue=underlyingValue;
        }

        public static readonly PropertyIdMeaning PrimaryDataPropertyId = "primaryDataPropertyId";

        public static readonly PropertyIdMeaning SchemaDataPropertyId = "schemaDataPropertyId";

        public static readonly PropertyIdMeaning EnrichedDataPropertyId = "enrichedDataPropertyId";


        /// <summary>
        /// Underlying value of enum PropertyIdMeaning
        /// </summary>
        private readonly string UnderlyingValue;

        /// <summary>
        /// Returns string representation for PropertyIdMeaning
        /// </summary>
        public override string ToString()
        {
            return UnderlyingValue == null ? null : UnderlyingValue.ToString();
        }

        /// <summary>
        /// Compares enums of type PropertyIdMeaning
        /// </summary>
        public bool Equals(PropertyIdMeaning e)
        {
            return UnderlyingValue.Equals(e.UnderlyingValue);
        }

        /// <summary>
        /// Implicit operator to convert string to PropertyIdMeaning
        /// </summary>
        public static implicit operator PropertyIdMeaning(string value)
        {
            return new PropertyIdMeaning(value);
        }

        /// <summary>
        /// Implicit operator to convert PropertyIdMeaning to string
        /// </summary>
        public static implicit operator string(PropertyIdMeaning e)
        {
            return e.UnderlyingValue;
        }

        /// <summary>
        /// Overriding == operator for enum PropertyIdMeaning
        /// </summary>
        public static bool operator == (PropertyIdMeaning e1, PropertyIdMeaning e2)
        {
            return e2.Equals(e1);
        }

        /// <summary>
        /// Overriding != operator for enum PropertyIdMeaning
        /// </summary>
        public static bool operator != (PropertyIdMeaning e1, PropertyIdMeaning e2)
        {
            return !e2.Equals(e1);
        }

        /// <summary>
        /// Overrides Equals operator for PropertyIdMeaning
        /// </summary>
        public override bool Equals(object obj)
        {
            return obj is PropertyIdMeaning && Equals((PropertyIdMeaning)obj);
        }

        /// <summary>
        /// Returns for hashCode PropertyIdMeaning
        /// </summary>
        public override int GetHashCode()
        {
            return UnderlyingValue.GetHashCode();
        }

    }
}
