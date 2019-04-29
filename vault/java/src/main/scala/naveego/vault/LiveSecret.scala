package naveego.vault

import java.util.TimerTask
import java.util.Timer

import spray.json._
import NaveegoJsonProtocol._

/**
  * A LiveSecret acquires a secret and keeps renewing or re-acquiring it so that
  * the value will always be valid, until the <code>stop</code> method is called
  * on the instance. After stop has been called, the `valueOrThrow` method will
  * throw an exception. The `value` method will return an Either[String, T] where
  * Left is the error if the value is invalid.
  *
  * @param label A label that will be used when logging from this instance.
  * @param api The VaultApi which will be passed to the getter.
  * @param getter The getter function which will be invoked to get the secret. This function is responsible for
  *               obtaining the raw secret from the api and applying any transforms to it before returning it.
  * @tparam T
  */
class LiveSecret[T](
                     label: String,
                     api: VaultApi,
                     getter: (VaultApi) => Either[String, Secret[T]]
                   ) extends log.LazyLogger {

  private var valueOrError: Either[String, T] = Left("not initialized")

  private val timer = new Timer()

  def value(): Either[String, T] = valueOrError

  def valueOrThrow() : T = {
    valueOrError match {
      case Left(err) => throw new Exception(err)
      case Right(t) => t
    }
  }

  init()

  private def init(): Unit = {


    val self = this
    var maybeSecret = getter(api)

    this.setValue(maybeSecret)
    
    if (maybeSecret.isRight) {
      val secret = maybeSecret.right.get

      if (secret.leaseDuration == 0) {
        log.debug(s"Lease for secret with label '$label' will never expire, no renewal work to do.");
        return
      }

      val task = if (secret.renewable) {
        // If the lease is renewable, the renewal action is to renew the lease and return
        // the original value provided by the getter.
        new TimerTask {
          override def run(): Unit = {
            try {
              log.debug(s"Renewing live secret with label '$label'.")
              val payload = Map("lease_id" -> secret.leaseId).toJson(DefaultJsonProtocol.mapFormat)
              api.write("sys/lease/renew", payload)
            }
            catch {
              case e: Exception => {
                log.error(s"Renewing live secret with label '$label' failed with error $e")
                self.valueOrError = Left(e.toString)
              }
            }
          }
        }
      } else {
        // If the lease is not renewable, the only way to keep the secret fresh is to re-invoke the getter.
        new TimerTask {
          override def run(): Unit = {
            try {
              log.debug(s"Re-acquiring live secret with label '$label'.")
              maybeSecret = getter(api)
              self.setValue(maybeSecret)
            }
            catch {
              case e: Exception => {
                log.error(s"Re-acquiring live secret with label '$label' failed with error $e")
                self.valueOrError = Left(e.toString)
              }
            }
          }
        }
      }

      val halflife = (secret.leaseDuration * 1000) / 2

      timer.schedule(task, halflife, halflife)
    }


  }

  private def setValue(latest: Either[String, Secret[T]]) =
    this.valueOrError = latest match {
    case Left(error) => Left(error)
    case Right(s) => s.data match {
      case Some(t) => Right(t)
      case None => Left("No data.")
    }
  }

  def stop(): Unit = {
    timer.cancel()
    valueOrError = Left("Timer has been stopped.")
  }
}
