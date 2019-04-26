package naveego.vault

import java.util.TimerTask
import java.util.Timer
import spray.json._
import NaveegoJsonProtocol._

case class TransformedSecret[T](secret: Secret, data: T)

class LiveSecret[T](
                     label: String,
                     api: VaultApi,
                     getter: (VaultApi) => TransformedSecret[T]
                     ) extends log.LazyLogger {

  private var valueOrError : Either[String, T] = Left("not initialized")
  def value(): T = valueOrError match {
    case Left(err) => throw new Exception(err)
    case Right(v) => v
  }

  init()

  private def init(): Unit = {

    val self = this
    val initialInfo = getter(api)
    val secret = initialInfo.secret
    val initialValue = initialInfo.data
    this.valueOrError = Right(initialValue)


    if (secret.renewable)
    {
      // If the lease is renewable, the renewal action is to renew the lease and return
      // the original value provided by the getter.
      val halflife = (secret.leaseDuration * 1000) / 2

      val timer = new Timer()
      timer.schedule(new TimerTask {
        override def run(): Unit = {
          try {
            log.debug(s"Renewing live secret with label '$label'.")
            val payload = Map[String, String]().toJson
            api.write("sys/lease/renew", Map("lease_id" -> secret.leaseId).toJson)
          }
          catch {
            case e: Exception => {
              log.error(s"Renewing live secret with label '$label' failed with error $e")
              self.valueOrError = Left(e.toString)
            }
          }
        }
      }, halflife, halflife)
    }
    else if (secret.leaseDuration == 0)
    {
      log.debug(s"Lease for secret with label '$label' will never expire, no renewal work to do.");
    } else {
      // If the lease is not renewable, the only way to keep the secret fresh is to re-invoke the getter.
      val halflife = (secret.leaseDuration * 1000) / 2

      var timer = new Timer()
      timer.schedule(new TimerTask {
        override def run(): Unit = {
          try {
            log.debug(s"Re-acquiring live secret with label '$label'.")
            val result = getter(api)
            self.valueOrError = Right(result.data)
          }
          catch {
            case e: Exception => {
              log.error(s"Re-acquiring live secret with label '$label' failed with error $e")
              self.valueOrError = Left(e.toString)
            }
          }
        }
      }, halflife, halflife)
    }
  }













}
