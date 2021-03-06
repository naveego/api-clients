// <auto-generated>
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.
// </auto-generated>

namespace Naveego.Metabase.Models
{
    using Newtonsoft.Json;

    /// <summary>
    /// Defines values for ScheduleType.
    /// </summary>
    /// <summary>
    /// Determine base value for a given allowed value if exists, else return
    /// the value itself
    /// </summary>
    [JsonConverter(typeof(ScheduleTypeConverter))]
    public struct ScheduleType : System.IEquatable<ScheduleType>
    {
        private ScheduleType(string underlyingValue)
        {
            UnderlyingValue=underlyingValue;
        }

        public static readonly ScheduleType Never = "never";

        public static readonly ScheduleType Immediate = "immediate";

        public static readonly ScheduleType OnDemand = "onDemand";

        public static readonly ScheduleType Once = "once";

        public static readonly ScheduleType Interval = "interval";

        public static readonly ScheduleType Cron = "cron";

        public static readonly ScheduleType RealTime = "realTime";

        public static readonly ScheduleType Always = "always";


        /// <summary>
        /// Underlying value of enum ScheduleType
        /// </summary>
        private readonly string UnderlyingValue;

        /// <summary>
        /// Returns string representation for ScheduleType
        /// </summary>
        public override string ToString()
        {
            return UnderlyingValue == null ? null : UnderlyingValue.ToString();
        }

        /// <summary>
        /// Compares enums of type ScheduleType
        /// </summary>
        public bool Equals(ScheduleType e)
        {
            return UnderlyingValue.Equals(e.UnderlyingValue);
        }

        /// <summary>
        /// Implicit operator to convert string to ScheduleType
        /// </summary>
        public static implicit operator ScheduleType(string value)
        {
            return new ScheduleType(value);
        }

        /// <summary>
        /// Implicit operator to convert ScheduleType to string
        /// </summary>
        public static implicit operator string(ScheduleType e)
        {
            return e.UnderlyingValue;
        }

        /// <summary>
        /// Overriding == operator for enum ScheduleType
        /// </summary>
        public static bool operator == (ScheduleType e1, ScheduleType e2)
        {
            return e2.Equals(e1);
        }

        /// <summary>
        /// Overriding != operator for enum ScheduleType
        /// </summary>
        public static bool operator != (ScheduleType e1, ScheduleType e2)
        {
            return !e2.Equals(e1);
        }

        /// <summary>
        /// Overrides Equals operator for ScheduleType
        /// </summary>
        public override bool Equals(object obj)
        {
            return obj is ScheduleType && Equals((ScheduleType)obj);
        }

        /// <summary>
        /// Returns for hashCode ScheduleType
        /// </summary>
        public override int GetHashCode()
        {
            return UnderlyingValue.GetHashCode();
        }

    }
}
