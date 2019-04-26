package naveego.vault

import spray.json._

case class Secret(
                   requestId: String,
                   leaseId: String,
                   renewable: Boolean,
                   leaseDuration: Int,
                   warnings: List[String],
                   auth: SecretAuth,
                   data: JsObject,
                 )


case class SecretAuth(
                       clientToken: String,
                       accessor: String,
                       policies: List[String],
                       metadata: Map[String, String],
                       leaseDuration: Int,
                       renewable: Boolean,
                     )

case class NoData()

object NaveegoJsonProtocol extends DefaultJsonProtocol {

  implicit val secretAuth = new RootJsonFormat[SecretAuth] {
    override def write(obj: SecretAuth): JsValue = {
      JsObject(
        "client_token" -> obj.clientToken.toJson,
        "accessor" -> obj.accessor.toJson,
        "policies" -> obj.policies.toJson,
        "metadata" -> obj.metadata.toJson,
        "lease_duration" -> obj.leaseDuration.toJson,
        "renewable" -> obj.renewable.toJson,
      )
    }

    override def read(json: JsValue): SecretAuth = {
      if (json == null || json == JsNull) {
        return null
      }

      val obj = json.asJsObject

      new SecretAuth(
        obj.fields("client_token").convertTo[String],
        obj.fields("accessor").convertTo[String],
        obj.fields("policies").convertTo[List[String]],
        obj.fields("metadata") match {
          case o: JsObject => o.convertTo[Map[String, String]]
          case _ => null
        },
        obj.fields("lease_duration").convertTo[Int],
        obj.fields("renewable").convertTo[Boolean],
      )
    }
  }

  implicit val secret = new RootJsonFormat[Secret] {
    override def write(obj: Secret): JsValue = {
      JsObject(
        "data" -> obj.data.toJson,
        "auth" -> obj.auth.toJson,
        "request_id" -> obj.requestId.toJson,
        "lease_id" -> obj.leaseId.toJson,
        "lease_duration" -> obj.leaseDuration.toJson,
        "renewable" -> obj.renewable.toJson,
        "warnings" -> obj.warnings.toJson,
      )
    }

    override def read(json: JsValue): Secret = {
      val obj = json.asJsObject

      new Secret(
        obj.fields("request_id").convertTo[String],
        obj.fields("lease_id").convertTo[String],
        obj.fields("renewable").convertTo[Boolean],
        obj.fields("lease_duration").convertTo[Int],
        obj.fields("warnings") match {
          case o: JsArray => o.convertTo[List[String]]
          case _ => null
        },
        obj.fields("auth").convertTo[SecretAuth],
        obj.fields("data") match {
          case o: JsObject => o
          case _ => null
        },
      )
    }
  }


}
