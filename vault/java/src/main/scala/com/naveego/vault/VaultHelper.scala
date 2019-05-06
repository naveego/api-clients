package com.naveego.vault

import com.naveego.vault.NaveegoJsonProtocol._
import com.softwaremill.sttp._
import com.typesafe.scalalogging.LazyLogging
import spray.json.{JsValue, _}


trait VaultApi {
  def read(path: String): Secret[JsObject]
  def write(path: String, payload: JsValue = null): Secret[JsObject]
}



/**
  * VaultHelper helps access Vault secrets. An instance should be obtained
  * using the `vault.builder` builder. An application probably only needs
  * a single vault helper.
  * @param address
  * @param secretAuth
  */
class VaultHelper(address: String, secretAuth: SecretAuth)
  extends VaultApi with LazyLogging {

  implicit val backend = HttpURLConnectionBackend()

  val token = secretAuth.clientToken

  /**
    * Reads the secret at the provided path.
    * @param path
    * @return
    */
  def read(path: String): Secret[JsObject] = {

    val url = uri"${address + "/v1/" + path}"
    val request = sttp.get(url)
      .headers(("X-Vault-Token", token))


    val response = request
      .send()

    if (response.isSuccess) {
      val body = response.unsafeBody
      if (!body.isEmpty) {
        val secret = body
            .parseJson
          .convertTo[Secret[JsObject]](NaveegoJsonProtocol.secret[JsObject])
        return secret
      }
    }

    val secret = response
      .unsafeBody
      .parseJson
      .convertTo[Secret[JsObject]](NaveegoJsonProtocol.secret[JsObject])
    secret
  }

  /**
    * Writes the payload to the provided path, and returns the secret returned by Vault.
    * @param path
    * @param payload
    * @return
    */
  def write(path: String, payload: JsValue = null): Secret[JsObject] = {
    val url = uri"${address + "/v1/" + path}"
    var request = sttp.post(url)
      .headers(("X-Vault-Token", token))

    if(payload != null) {
      val body = payload.toJson.toString()
      request = request.body(body)
    }

    val response = request.mapResponse(x => if (x.isEmpty) {
      null
    } else {
      x.parseJson.convertTo[Secret[JsObject]]
    })
      .send()


    response.unsafeBody
  }

  /**
    * Resolves a secret using the provided getter. The secret will not be renewed.
    * Some useful getters are defined on the SecretGetters object.
    * @param getter
    * @tparam T
    * @return
    */
  def getDeadSecret[T](getter: (VaultApi) =>  Either[String, Secret[T]]) : Either[String, T] = {
    getter(this) match {
      case Left(err) => Left(err)
      case Right(secret) => secret.data match {
      case None => Left("No data.")
      case Some(t) => Right(t)
      }
    }
  }

  /**
    * Resolves a secret using the provided getter. The returned LiveSecret will keep the secret renewed.
    * Some useful getters are defined on the SecretGetters object.
    * @param label Used for logging by the LiveSecret.
    * @param getter
    * @tparam T
    * @return
    */
  def getLiveSecret[T](label: String, getter: (VaultApi) => Either[String, Secret[T]]): LiveSecret[T] = {
    val liveSecret = new LiveSecret[T](label, this, getter)

    liveSecret
  }


}
