package naveego.vault

import naveego.vault.NaveegoJsonProtocol._
import org.scalamock.scalatest.MockFactory
import org.scalatest.{EitherValues, FlatSpec, Matchers, OptionValues, WordSpec}
import spray.json._

class SecretGettersFixture extends WordSpec with Matchers with MockFactory with EitherValues with OptionValues {

  "Jwt getter" when {
    "JWT is returned from vault" should {
      "return secret containing JWT directly" in {
        val expectedJWT = "Fake.JWT"
        val api = new TestVaultApi()
        api.writeResponses += ("jose/jwt/issue/test" -> Secret[JsObject](Some(Map("token" -> expectedJWT).toJson.asJsObject()), null, false, 100))
        val claims = Map("tid" -> "test-tenant",
          "sub" -> "test-user").toJson.asJsObject()

        val ttlSeconds = 100
        val sut = SecretGetters.makeJwtGetter("test", ttlSeconds, claims)

        val actual = sut(api)

        actual.right.value.data.get should equal(expectedJWT)

        val expectedExp = (System.currentTimeMillis() / 1000) + ttlSeconds

        val actualPayload = api.writes("jose/jwt/issue/test").head.asJsObject()

        actualPayload.fields("token_ttl").convertTo[Long] should equal(ttlSeconds)

        val actualClaims = actualPayload.fields("claims").asJsObject()
        actualClaims.fields("tid").convertTo[String] should equal("test-tenant")
        actualClaims.fields("sub").convertTo[String] should equal("test-user")
        actualClaims.fields("exp").convertTo[Long] should equal(expectedExp)
      }
    }
  }

  "A secret template getter" when {

    trait VaultApiContext {
      val api = new TestVaultApi()
    }

    "path is not found" should {
      val testSecretPath = "invalid/path"

      "return left with error" in new VaultApiContext {
        val sut = SecretGetters.makeSecretTemplateGetter(s"secret-(vault:$testSecretPath)-embed")
        val actual = sut(api)
        actual.left.value should include("Nothing set")
      }
    }

    "no secret is embedded" should {
      val parameter = "no embedded secrets"
      "return secret containing value" in new VaultApiContext  {
        val sut = SecretGetters.makeSecretTemplateGetter(parameter)
        val actual = sut(api)
        actual.right.value.data.value should equal(parameter)
      }
    }

    "a secret path is present with no template" when {
      val path = "test/secret/path"
      val parameter = s"secret-(vault:$path)-embed"
      "the secret has no values" should {

        "return error" in new VaultApiContext {
          val secretMap = Map[String, String]()

          api.readResponses += (path -> Secret[JsObject](Some(secretMap.toJson.asJsObject())))
          val sut = SecretGetters.makeSecretTemplateGetter(parameter)
          val actual = sut(api)
          actual.left.value should include("did not have exactly one value")
        }
      }

      "the secret has one values" should {
        val secretMap = Map("username" -> "user")
        val expected = s"secret-user-embed"

        "return expected value" in new VaultApiContext {
          api.readResponses += (path -> Secret[JsObject](Some(secretMap.toJson.asJsObject())))

          val sut = SecretGetters.makeSecretTemplateGetter(parameter)
          val actual = sut(api)
          actual.right.value.data.value should equal(expected)
        }
      }

      "the secret has two values" should {
        val secretMap = Map("username" -> "user", "password" -> "pass")

        "return error" in new VaultApiContext  {
          api.readResponses += (path -> Secret[JsObject](Some(secretMap.toJson.asJsObject())))
          val sut = SecretGetters.makeSecretTemplateGetter(parameter)
          val actual = sut(api)
          actual.left.value should include("did not have exactly one value")
        }
      }
    }


    "a secret path with template is present" when {

      val path = "test/secret/path"
      val parameter = s"secret-(vault:$path?template={{.username}}:{{.password}})-embed"

      "the secret has no values" should {
        val secretMap = Map[String, String]()

        "return error" in new VaultApiContext {
          api.readResponses += (path -> Secret[JsObject](Some(secretMap.toJson.asJsObject())))
          val sut = SecretGetters.makeSecretTemplateGetter(parameter)
          val actual = sut(api)
          actual.left.value should include("did not have a value for key 'username'")
        }
      }

      "the secret has one values" should {
        val secretMap = Map("username" -> "user")
        val expected = s"secret-user-embed"

        "return expected value" in new VaultApiContext  {
          api.readResponses += (path -> Secret[JsObject](Some(secretMap.toJson.asJsObject())))
          val sut = SecretGetters.makeSecretTemplateGetter(parameter)
          val actual = sut(api)
          actual.left.value should include("did not have a value for key 'password'")
        }
      }

      "the secret has two values" should {
        val secretMap = Map("username" -> "user", "password" -> "pass")

        val expected = "secret-user:pass-embed"
        "return parameter with vault template replaced by secret value" in new VaultApiContext  {
          api.readResponses += (path -> Secret[JsObject](Some(secretMap.toJson.asJsObject())))
          val sut = SecretGetters.makeSecretTemplateGetter(parameter)
          val actual = sut(api)
          actual.right.value.data.value should equal(expected)
        }
      }
    }
  }
}

class TestVaultApi extends VaultApi {
  var readResponses = Map[String, Secret[JsObject]]()
  var writeResponses = Map[String, Secret[JsObject]]()
  var reads = Map[String, Int]()
  var writes = Map[String, Seq[JsValue]]()

  override def read(path: String): Secret[JsObject] = {
    val normalizedPath = path.stripPrefix("/")
    val curr = reads.getOrElse(normalizedPath, 0)
    reads += (normalizedPath -> (curr + 1))
    readResponses.get(normalizedPath) match {
      case Some(v) => v
      case None => throw new Exception(s"Nothing set in readResponses at key $normalizedPath")
    }
  }

  override def write(path: String, payload: JsValue = null): Secret[JsObject] = {
    val normalizedPath = path.stripPrefix("/")
    val curr = writes.getOrElse(normalizedPath, Seq())
    val updated = curr :+ payload
    writes += (normalizedPath -> updated)

    writeResponses.get(normalizedPath) match {
      case Some(v) => v
      case None => throw new Exception(s"Nothing set in readResponses at key $normalizedPath")
    }
  }

}