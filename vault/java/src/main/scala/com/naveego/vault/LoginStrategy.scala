package com.naveego.vault

import com.naveego.vault.NaveegoJsonProtocol._
import com.softwaremill.sttp._
import com.typesafe.scalalogging.LazyLogging
import spray.json._

import scala.io.Source

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
      .body match {
      case Left(err) => Left(err)
      case Right(body) =>
        val secret = body.parseJson

        val obj = secret.asJsObject().fields.get("data").get.asJsObject()

        val auth = new SecretAuth(
          obj.fields("id").convertTo[String],
          obj.fields("renewable").convertTo[Boolean],
          obj.fields("ttl").convertTo[Int],
          obj.fields("policies").convertTo[List[String]],
          null,
          obj.fields("accessor").convertTo[String]
        )

        Right(auth)
      }


    secret
  }
}

case class KubernetesLoginStrategy(role: String, mount: String = "auth/kubernetes", var jwt: String = "") extends LoginStrategy with LazyLogging {

  final val KubernetesTokenPath = "/var/run/secrets/kubernetes.io/serviceaccount/token"


  override def login(address: String): Either[String, SecretAuth] = {
    implicit val backend = HttpURLConnectionBackend()

    if (role == null || role.isEmpty) {
      return Left("Kubernetes role was null or empty.")
    }

    if (jwt == "") {
      logger.debug("Reading kubernetes service account token from file.")
      val file = new java.io.File(KubernetesTokenPath)
      if(!file.exists()){
        return Left(s"No token file found at $KubernetesTokenPath")
      }

      jwt = Source.fromFile(file).mkString
    }

    logger.debug(s"Logging in using Kubernetes role $role.")

    val path = s"v1/${mount.stripPrefix("/").stripSuffix("/")}/login"
    val url = uri"$address".path(path)
    val body = Map(
      "role"->role,
      "jwt"-> jwt
    )

    val response = sttp.post(url).body(body.toJson.toString()).send()

    val secret = response
      .body match {
      case Left(err) => Left(err)
      case Right(body) =>
        val secret = body.parseJson.convertTo[Secret[Map[String,String]]](NaveegoJsonProtocol.secret)
        Right(secret.auth)
      }

    secret
  }
}
