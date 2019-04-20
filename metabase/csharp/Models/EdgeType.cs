// <auto-generated>
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.
// </auto-generated>

namespace Naveego.Metabase.Models
{
    using Newtonsoft.Json;

    /// <summary>
    /// Defines values for EdgeType.
    /// </summary>
    /// <summary>
    /// Determine base value for a given allowed value if exists, else return
    /// the value itself
    /// </summary>
    [JsonConverter(typeof(EdgeTypeConverter))]
    public struct EdgeType : System.IEquatable<EdgeType>
    {
        private EdgeType(string underlyingValue)
        {
            UnderlyingValue=underlyingValue;
        }

        public static readonly EdgeType Unknown = "unknown";

        public static readonly EdgeType InProcess = "inProcess";

        public static readonly EdgeType Kafka = "kafka";

        public static readonly EdgeType Http = "http";


        /// <summary>
        /// Underlying value of enum EdgeType
        /// </summary>
        private readonly string UnderlyingValue;

        /// <summary>
        /// Returns string representation for EdgeType
        /// </summary>
        public override string ToString()
        {
            return UnderlyingValue == null ? null : UnderlyingValue.ToString();
        }

        /// <summary>
        /// Compares enums of type EdgeType
        /// </summary>
        public bool Equals(EdgeType e)
        {
            return UnderlyingValue.Equals(e.UnderlyingValue);
        }

        /// <summary>
        /// Implicit operator to convert string to EdgeType
        /// </summary>
        public static implicit operator EdgeType(string value)
        {
            return new EdgeType(value);
        }

        /// <summary>
        /// Implicit operator to convert EdgeType to string
        /// </summary>
        public static implicit operator string(EdgeType e)
        {
            return e.UnderlyingValue;
        }

        /// <summary>
        /// Overriding == operator for enum EdgeType
        /// </summary>
        public static bool operator == (EdgeType e1, EdgeType e2)
        {
            return e2.Equals(e1);
        }

        /// <summary>
        /// Overriding != operator for enum EdgeType
        /// </summary>
        public static bool operator != (EdgeType e1, EdgeType e2)
        {
            return !e2.Equals(e1);
        }

        /// <summary>
        /// Overrides Equals operator for EdgeType
        /// </summary>
        public override bool Equals(object obj)
        {
            return obj is EdgeType && Equals((EdgeType)obj);
        }

        /// <summary>
        /// Returns for hashCode EdgeType
        /// </summary>
        public override int GetHashCode()
        {
            return UnderlyingValue.GetHashCode();
        }

    }
}
