// <auto-generated>
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.
// </auto-generated>

namespace Naveego.Metabase.Models
{
    using Newtonsoft.Json;

    /// <summary>
    /// Defines values for ConnectionRole.
    /// </summary>
    /// <summary>
    /// Determine base value for a given allowed value if exists, else return
    /// the value itself
    /// </summary>
    [JsonConverter(typeof(ConnectionRoleConverter))]
    public struct ConnectionRole : System.IEquatable<ConnectionRole>
    {
        private ConnectionRole(string underlyingValue)
        {
            UnderlyingValue=underlyingValue;
        }

        public static readonly ConnectionRole Publisher = "publisher";

        public static readonly ConnectionRole Subscriber = "subscriber";


        /// <summary>
        /// Underlying value of enum ConnectionRole
        /// </summary>
        private readonly string UnderlyingValue;

        /// <summary>
        /// Returns string representation for ConnectionRole
        /// </summary>
        public override string ToString()
        {
            return UnderlyingValue == null ? null : UnderlyingValue.ToString();
        }

        /// <summary>
        /// Compares enums of type ConnectionRole
        /// </summary>
        public bool Equals(ConnectionRole e)
        {
            return UnderlyingValue.Equals(e.UnderlyingValue);
        }

        /// <summary>
        /// Implicit operator to convert string to ConnectionRole
        /// </summary>
        public static implicit operator ConnectionRole(string value)
        {
            return new ConnectionRole(value);
        }

        /// <summary>
        /// Implicit operator to convert ConnectionRole to string
        /// </summary>
        public static implicit operator string(ConnectionRole e)
        {
            return e.UnderlyingValue;
        }

        /// <summary>
        /// Overriding == operator for enum ConnectionRole
        /// </summary>
        public static bool operator == (ConnectionRole e1, ConnectionRole e2)
        {
            return e2.Equals(e1);
        }

        /// <summary>
        /// Overriding != operator for enum ConnectionRole
        /// </summary>
        public static bool operator != (ConnectionRole e1, ConnectionRole e2)
        {
            return !e2.Equals(e1);
        }

        /// <summary>
        /// Overrides Equals operator for ConnectionRole
        /// </summary>
        public override bool Equals(object obj)
        {
            return obj is ConnectionRole && Equals((ConnectionRole)obj);
        }

        /// <summary>
        /// Returns for hashCode ConnectionRole
        /// </summary>
        public override int GetHashCode()
        {
            return UnderlyingValue.GetHashCode();
        }

    }
}
