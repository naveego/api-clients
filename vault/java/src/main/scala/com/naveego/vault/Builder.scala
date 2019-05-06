package com.naveego.vault

import java.util.{Timer, TimerTask}

import com.naveego.vault.SeqHelpers._
import com.typesafe.scalalogging.LazyLogging


case class VaultHelperBuilder(
                               address: String,
                               secretAuth: SecretAuth,
                               onRefreshFailure: Exception => Unit,
                               strategies: Seq[LoginStrategy]
                             ) extends LazyLogging {
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

          logger.debug(s"Auth token with accessor ${
            auth.accessor
          } is renewable, with lease duration ${
            auth.leaseDuration
          }. Will renew every ${
            auth.leaseDuration / 2.0
          } seconds.")

          val timer = new Timer()
          timer.schedule(new TimerTask {
            override def run(): Unit = {
              logger.debug(s"Renewing auth token with accessor ${
                auth.accessor
              }")
              try {
                helper.write("auth/token/renew-self")
              }
              catch {
                case e: Exception => {
                  logger.error(s"Renewing auth token with accessor ${
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
