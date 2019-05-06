package com.naveego.vault

import spray.json._


case class Secret[T](
                   data: Option[T],
                   auth: SecretAuth = null,
                   renewable: Boolean = false,
                   leaseDuration: Long = 0,
                   leaseId: String = null,
                   warnings: List[String] = null,
                   requestId: String = ""
                 ) {
  /**
    * Returns a new Secret with `newData` as the data.
    * @param newData
    * @tparam TOther
    * @return
    */
  def rewrap[TOther:JsonFormat](newData: TOther): Secret[TOther] = {
    this.copy[TOther](data = Some(newData))
  }


  implicit class JsonSecret(self: Secret[JsObject]) {
    /**
      * Returns a secret with the same field values but the data parsed
      * into TFormat.
      * @tparam TFormat
      * @return
      */
    def withParsedValue[TFormat: JsonFormat]() : Secret[TFormat] = {
      self.data match {
        case Some(j) => self.rewrap[TFormat](j.convertTo[TFormat])
        case None => self.copy[TFormat](data = None)
      }
    }
  }
}


case class SecretAuth(
                       clientToken: String,
                       renewable: Boolean = false,
                       leaseDuration: Long = 0,
                       policies: List[String] = List[String](),
                       metadata: Map[String, String] = null,
                       accessor: String = null
                     )

object NaveegoJsonProtocol extends DefaultJsonProtocol {


  implicit val secretAuth: RootJsonFormat[SecretAuth] = new RootJsonFormat[SecretAuth] {
    override def write(obj: SecretAuth): JsValue = {
      JsObject(
        "client_token" -> obj.clientToken.toJson,
        "accessor" -> obj.accessor.toJson,
        "policies" -> obj.policies.toJson,
        "metadata" -> obj.metadata.toJson,
        "lease_duration" -> obj.leaseDuration.toJson,
        "renewable" -> obj.renewable.toJson
      )
    }

    override def read(json: JsValue): SecretAuth = {
      if (json == null || json == JsNull) {
        return null
      }

      val obj = json.asJsObject

      new SecretAuth(
        obj.fields("client_token").convertTo[String],
        obj.fields("renewable").convertTo[Boolean],
        obj.fields("lease_duration").convertTo[Int],
        obj.fields("policies").convertTo[List[String]],
        obj.fields("metadata") match {
          case o: JsObject => o.convertTo[Map[String, String]]
          case _ => null
        },
        obj.fields("accessor").convertTo[String]
      )
    }
  }

  implicit def secret[T: JsonFormat] = new RootJsonFormat[Secret[T]] {
    override def write(obj: Secret[T]): JsValue = {
      JsObject(
        "data" -> obj.data.toJson,
        "auth" -> obj.auth.toJson,
        "request_id" -> obj.requestId.toJson,
        "lease_id" -> obj.leaseId.toJson,
        "lease_duration" -> obj.leaseDuration.toJson,
        "renewable" -> obj.renewable.toJson,
        "warnings" -> obj.warnings.toJson
      )
    }

    override def read(json: JsValue): Secret[T] = {
      val obj = json.asJsObject

      new Secret(
        obj.fields("data") match {
          case o: JsObject => Some(o.convertTo[T])
          case _ => None
        },
        obj.fields("auth") match {
          case o: JsObject => o.convertTo[SecretAuth]
          case _ => null
        },
        obj.fields("renewable").convertTo[Boolean],
        obj.fields("lease_duration").convertTo[Int],
        obj.fields("lease_id").convertTo[String],
        obj.fields("warnings") match {
          case o: JsArray => o.convertTo[List[String]]
          case _ => null
        },
        obj.fields("request_id").convertTo[String]
      )
    }
  }


}
