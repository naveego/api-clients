package naveego.vault

import java.net.URI

import spray.json._
import DefaultJsonProtocol._
import com.softwaremill.sttp._
import io.lemonlabs.uri.Url

import scala.util.matching.Regex

object SecretGetters {


  def makeJwtGetter(role: String, ttlSeconds: Int, optionalClaims: JsObject = null): VaultApi => Either[String, Secret[String]] = {

    return (api: VaultApi) => {


      var claimFields = if (optionalClaims == null) Map[String, JsValue]() else optionalClaims.fields

      val path = s"jose/jwt/issue/$role"

      // expiration is a unix epoch in seconds
      val exp = (System.currentTimeMillis() / 1000) + ttlSeconds

      claimFields += ("exp" -> exp.toJson(DefaultJsonProtocol.LongJsonFormat))

      var claims = JsObject(claimFields)

      val payload = Map[String, JsValue](
        "token_ttl" -> ttlSeconds.toJson,
        "claims" -> claims
      )

      try {
        val secret = api.write(path, payload.toJson)

        val transformedSecret = secret.data match {
          case Some(m) => m.asJsObject().fields.get("token") match {
            case Some(token) => Right(secret.rewrap(token.convertTo[String]))
            case None => Left("No token found in secret data.")
          }
          case None => Left("No data in secret.")
        }

        transformedSecret

      } catch {
        case ex: Exception => Left(ex.toString)
      }
    }
  }


  /**
    * The getter returned by this method will resolve an embedded template by pulling values from a vault secret.
    * An example of an embedded template:
    * mongodb://(vault://database/creds/mongodb-admin?template={{.username}}:{{.password}})@mongodb:27017/go-between?readPreference=primary
    * The vault secret will be read from database/creds/mongodb-admin, then the "username" and "password"
    * values from the secret will be formatted using the template. Finally, the entire (vault:...) token
    * will be replaced with the result of the formatting. If the username and password were "user" and "pass",
    * the result would be:
    * mongodb://user:pass@mongodb:27017/go-between?readPreference=primary
    *
    * @param stringWithEmbeddedSecrets
    * @return
    */
  def makeSecretTemplateGetter(stringWithEmbeddedSecrets: String): VaultApi => Either[String, Secret[String]] = {

    val maybeUrl = parseSecretURI(stringWithEmbeddedSecrets)
    if (maybeUrl.isEmpty) {
      return _ => Right(Secret(Some(stringWithEmbeddedSecrets)))
    }

    return (api: VaultApi) => {
      val url = maybeUrl.get
      val path = url.path.toAbsolute.toString()

      try {
        val secret = api.read(path)
        val template = url.query.param("template")

        val result: Either[String, String] = (secret.data, template) match {
          case (None, _) => Left(s"Secret embedded in template '${stringWithEmbeddedSecrets}' was empty.")
          case (Some(data), None) => data.fields.count(_ => true) match {
            case 1 => Right(data.fields.values.head.convertTo[String])
            case _ => Left(s"Secret embedded in template '${stringWithEmbeddedSecrets}' did not have exactly one value (keys were [${data.fields.keys.mkString(",")}]).")
          }
          case (Some(data), Some(tmpl)) =>
            Right(templateReplacer.replaceAllIn(tmpl, m => {
              val token = m.group(1)

              data.fields.get(token) match {
                case Some(jv) => jv.convertTo[String]
                case None => throw new Exception(s"Secret at path '$path' did not have a value for key '$token'.")
              }
            }))
        }

        result.map(x => {
          val finalResult = secretReferenceParser.replaceFirstIn(stringWithEmbeddedSecrets, x)
          secret.rewrap(finalResult)
        })
      } catch {
        case ex: Exception => Left(s"Error resolving embedded secret in '${stringWithEmbeddedSecrets}': $ex")
      }

    }
  }

  private val secretReferenceParser = new Regex("""(?:^|\()vault:/?/?([^?)]+)(?:\?template=([^)]+))?(?:$|\))""")

  private val templateReplacer = new Regex("""\{\{\s*\.?([A-z]+)\s*\}\}""")

  private def parseSecretURI(secretUri: String): Option[Url] = {
    try {
      if (secretUri.isEmpty) {
        return None
      }

      var matches = secretReferenceParser.findFirstMatchIn(secretUri)

      val url = matches.map(m => {
        val raw = m.group(0).stripPrefix("(").stripSuffix(")").replace("vault://", "vault:")
        Url.parse(raw)
      })

      return url
    }
    catch {
      case ex: Exception => throw new Exception(s"Invalid secretURI ${secretUri}: $ex");
    }
  }

}

