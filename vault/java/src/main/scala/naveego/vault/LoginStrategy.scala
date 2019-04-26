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
          .convertTo[Secret](NaveegoJsonProtocol.secret)

        val obj = secret.data

        val auth = new SecretAuth(
          obj.fields("id").convertTo[String],
          obj.fields("accessor").convertTo[String],
          obj.fields("policies").convertTo[List[String]],
          obj.fields.get("metadata") match {
            case Some(o) => o.convertTo[Map[String, String]]
            case _ => null
          },
          obj.fields("ttl").convertTo[Int],
          obj.fields("renewable").convertTo[Boolean],
        )

        auth
      })

    secret
  }
}
