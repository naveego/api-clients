package naveego.vault

import java.util.TimerTask
import java.util.Timer

import spray.json._
import NaveegoJsonProtocol._

class LiveSecret[T](
                     label: String,
                     api: VaultApi,
                     getter: (VaultApi) => Secret[T]
                   ) extends log.LazyLogger {

  private var valueOrError: Either[String, T] = Left("not initialized")

  private val timer = new Timer()

  def value(): Either[String, T] = valueOrError

  init()

  private def init(): Unit = {


    val self = this
    var secret = getter(api)
    this.valueOrError = Right(secret.data.get)

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
            api.write[NoData]("sys/lease/renew", payload)
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
            secret = getter(api)
            self.valueOrError = Right(secret.data.get)
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

  def stop(): Unit = {
    timer.cancel()
    valueOrError = Left("Timer has been stopped.")
  }
}
