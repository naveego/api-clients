package naveego.vault

import com.softwaremill.sttp._
import NaveegoJsonProtocol._
import spray.json._

trait LoginStrategy {
  def login(address: String): Either[String, SecretAuth]
}

case class TokenLoginStrategy(token: String) extends LoginStrategy {

  override def login(address: String): Either[String, SecretAuth] = {
    implicit val backend = HttpURLConnectionBackend()

    val request = sttp.post(uri"$address/v1/auth/token/lookup-self")
      .headers(("X-Vault-Token", token))

    val response = request
      .auth.bearer(token)
      .send()

    val secret = response
      .body
      .map(body => {
        val secret = body.parseJson

        val obj = secret.asJsObject().fields.get("data").get.asJsObject()

        val auth = new SecretAuth(
          obj.fields("id").convertTo[String],
          obj.fields("renewable").convertTo[Boolean],
          obj.fields("ttl").convertTo[Int],
          obj.fields("policies").convertTo[List[String]],
          null,
          obj.fields("accessor").convertTo[String],
        )

        auth
      })

    secret
  }
}
