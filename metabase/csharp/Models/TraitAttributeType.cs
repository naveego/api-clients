// <auto-generated>
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.
// </auto-generated>

namespace Naveego.Metabase.Models
{
    using Newtonsoft.Json;

    /// <summary>
    /// Defines values for TraitAttributeType.
    /// </summary>
    /// <summary>
    /// Determine base value for a given allowed value if exists, else return
    /// the value itself
    /// </summary>
    [JsonConverter(typeof(TraitAttributeTypeConverter))]
    public struct TraitAttributeType : System.IEquatable<TraitAttributeType>
    {
        private TraitAttributeType(string underlyingValue)
        {
            UnderlyingValue=underlyingValue;
        }

        public static readonly TraitAttributeType String = "string";

        public static readonly TraitAttributeType Count = "count";

        public static readonly TraitAttributeType Percent = "percent";

        public static readonly TraitAttributeType Statistic = "statistic";

        public static readonly TraitAttributeType Details = "details";

        public static readonly TraitAttributeType Histogram = "histogram";

        public static readonly TraitAttributeType Boxplot = "boxplot";


        /// <summary>
        /// Underlying value of enum TraitAttributeType
        /// </summary>
        private readonly string UnderlyingValue;

        /// <summary>
        /// Returns string representation for TraitAttributeType
        /// </summary>
        public override string ToString()
        {
            return UnderlyingValue == null ? null : UnderlyingValue.ToString();
        }

        /// <summary>
        /// Compares enums of type TraitAttributeType
        /// </summary>
        public bool Equals(TraitAttributeType e)
        {
            return UnderlyingValue.Equals(e.UnderlyingValue);
        }

        /// <summary>
        /// Implicit operator to convert string to TraitAttributeType
        /// </summary>
        public static implicit operator TraitAttributeType(string value)
        {
            return new TraitAttributeType(value);
        }

        /// <summary>
        /// Implicit operator to convert TraitAttributeType to string
        /// </summary>
        public static implicit operator string(TraitAttributeType e)
        {
            return e.UnderlyingValue;
        }

        /// <summary>
        /// Overriding == operator for enum TraitAttributeType
        /// </summary>
        public static bool operator == (TraitAttributeType e1, TraitAttributeType e2)
        {
            return e2.Equals(e1);
        }

        /// <summary>
        /// Overriding != operator for enum TraitAttributeType
        /// </summary>
        public static bool operator != (TraitAttributeType e1, TraitAttributeType e2)
        {
            return !e2.Equals(e1);
        }

        /// <summary>
        /// Overrides Equals operator for TraitAttributeType
        /// </summary>
        public override bool Equals(object obj)
        {
            return obj is TraitAttributeType && Equals((TraitAttributeType)obj);
        }

        /// <summary>
        /// Returns for hashCode TraitAttributeType
        /// </summary>
        public override int GetHashCode()
        {
            return UnderlyingValue.GetHashCode();
        }

    }
}