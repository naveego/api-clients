package naveego.vault

import com.softwaremill.sttp._
import NaveegoJsonProtocol._
import spray.json.{JsValue, _}
import java.util.TimerTask
import java.util.Timer

import SeqHelpers._

package object vault {

  val builder = VaultHelperBuilder(
    null, null, null, null
  )

}


trait VaultApi {
  def read(path: String): Secret[JsObject]
  def write(path: String, payload: JsValue = null): Secret[JsObject]
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

  /**
    * Adds an error handler which will be called if the background job responsible for
    * renewing the helper's token experiences an error. The handler should probably shut
    * down the application, because there's no way to reset the helper or give it a new token.
    * @param handler
    * @return
    */
  def withErrorHandler(handler: Exception => Unit): VaultHelperBuilder = this.copy(onRefreshFailure = handler)

  /**
    * Builds the vault helper, and starts a timer which will keep
    * renewing the token acquired by first login strategy which worked.
    * @return
    */
  def build(): VaultHelper = {


    // Acquire an auth token using the registered strategies,
    // by invoking the strategies in order and collecting
    // the errors if they fail, or the first successful result.
    // If I knew scala better I would stop invoking strategies
    // once one succeeds, but I'm not sure how to do that.

    val auth = secretAuth match {
      case a: SecretAuth => Right(a)
      case _ => strategies match {
        case s: Seq[LoginStrategy] =>
          s.map(_.login(address))
            .reduceLeftEither("")((acc, e) => acc + "; " + e)
        case _ => Left("No strategies defined")
      }
    }

    val helper = auth match {
      case Left(err) => throw new Exception(s"No strategy succeeded. Errors: $err")
      case Right(auth) => {

        // create the helper
        val helper = new VaultHelper(address, auth)

        if (auth.renewable && auth.leaseDuration > 0) {

          // start a timer which will keep renewing the lease
          // on the token the helper is using.

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


/**
  * VaultHelper helps access Vault secrets. An instance should be obtained
  * using the `vault.builder` builder. An application probably only needs
  * a single vault helper.
  * @param address
  * @param secretAuth
  */
class VaultHelper(address: String, secretAuth: SecretAuth)
  extends VaultApi with log.LazyLogger {

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
    getter(this).flatMap(_.data match {
      case None => Left("No data.")
      case Some(t) => Right(t)
    })
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
