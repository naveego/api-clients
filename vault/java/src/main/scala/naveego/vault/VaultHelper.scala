package naveego.vault

import com.softwaremill.sttp._
import NaveegoJsonProtocol._
import spray.json.{JsValue, _}
import java.util.TimerTask
import java.util.Timer


package object vault {

  val vault = VaultHelperBuilder(
    null, null, null, null
  )

}

trait VaultApi {
  def read(path: String): Secret
  def write(path: String, payload: JsValue = null): Secret
}

case class VaultHelperBuilder(
                               address: String,
                               secretAuth: SecretAuth,
                               onRefreshFailure: Exception => Unit,
                               strategies: Seq[LoginStrategy],
                             ) extends log.LazyLogger {
  def withAddress(address: String): VaultHelperBuilder = this.copy(address)

  def withAuth(secretAuth: SecretAuth): VaultHelperBuilder = this.copy(secretAuth = secretAuth)

  def withStrategies(strategies: LoginStrategy*) = this.copy(strategies = this.strategies match {
    case s: Seq[LoginStrategy] => s ++ strategies
    case _ => strategies
  })

  def withErrorHandler(handler: Exception => Unit): VaultHelperBuilder = this.copy(onRefreshFailure = handler)

  def build(): VaultHelper = {

    val auth = secretAuth match {
      case a: SecretAuth => Right(a)
      case _ => strategies match {
        case s: Seq[LoginStrategy] =>
          s.map(_.login(address))
            .reduce((acc, e) => acc match {
              case Right(auth) => Right(auth)
              case Left(err) => e match {
                case Right(auth) => Right(auth)
                case Left(err2) => Left(err + "; " + err2)
              }
            })
        case _ => Left("No strategies defined")
      }
    }

    val helper = auth match {
      case Left(err) => throw new Exception(s"No strategy succeeded. Errors: $err")
      case Right(auth) => {

        val helper = new VaultHelper(address, auth)

        if (auth.renewable && auth.leaseDuration > 0) {

          val halflife = (auth.leaseDuration / 2.0 * 1000).asInstanceOf[Long]

          log.debug(s"Auth token with accessor ${
            auth.accessor
          } is renewable, with lease duration ${
            auth.leaseDuration
          }. Will renew every ${
            auth.leaseDuration / 2.0
          } seconds.")

          val timer = new Timer()
          timer.schedule(new TimerTask {
            override def run(): Unit = {
              log.debug(s"Renewing auth token with accessor ${
                auth.accessor
              }")
              try {
                helper.write("auth/token/renew-self")
              }
              catch {
                case e: Exception => {
                  log.error(s"Renewing auth token with accessor ${
                    auth.accessor
                  } failed: $e")
                  if (onRefreshFailure != null) {
                    onRefreshFailure(e)
                  }
                  timer.cancel()
                }
              }
            }
          }, halflife, halflife)
        }

        helper
      }
    }


    helper
  }
}


class VaultHelper(address: String, secretAuth: SecretAuth)
  extends VaultApi with log.LazyLogger {

  implicit val backend = HttpURLConnectionBackend()

  val token = secretAuth.clientToken

  def read(path: String): Secret = {

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
          .convertTo[Secret](NaveegoJsonProtocol.secret)
        return secret
      }
    }

    val secret = response
      .unsafeBody
      .parseJson
      .convertTo[Secret](NaveegoJsonProtocol.secret)

    secret
  }

  def write(path: String, payload: JsValue = null): Secret = {
    val url = uri"${address + "/v1/" + path}"
    var request = sttp.post(url)
      .headers(("X-Vault-Token", token))

    if(payload != null) {
      val body = payload.toString()
      request = request.body(body)
    }

    val response = request.send()

    if (response.isSuccess) {
      val body = response.unsafeBody
      if (!body.isEmpty) {
        val secret = body
          .parseJson
          .convertTo[Secret](NaveegoJsonProtocol.secret)
        return secret
      }
    }

    return null
  }


}
