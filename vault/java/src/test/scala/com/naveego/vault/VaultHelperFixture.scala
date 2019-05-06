package com.naveego.vault

import NaveegoJsonProtocol._
import com.naveego.vault
import org.scalatest.{EitherValues, FlatSpec, Matchers, OptionValues}
import spray.json._

class VaultHelperFixture extends FlatSpec with Matchers with OptionValues with EitherValues {

   val address = "http://vault.n5o.red"

  "org.naveego.vault.VaultHelper" should "authenticate, write and read with root token" in {
    val sut = vault.builder.withAddress(address)
      .withStrategies(TokenLoginStrategy("root"))
      .build()

    val data = Map[String, String](
      "a" -> "A"
    ).toJson.asJsObject()
    sut.write("secret/data/scala-test", data)

    val result = sut.read("secret/data/scala-test")

    result.data.value should equal(data)
  }

  // test disabled because it requires you to obtain a valid service account secret token
  ignore should "authenticate, write and read with kubernetes token" in {
    val sut = vault.builder.withAddress(address)
      .withStrategies(KubernetesLoginStrategy("matching", jwt = ???))
      .build()

    val data = Map[String, String](
      "a" -> "A"
    ).toJson.asJsObject()
    sut.write("naveego-secrets/matching/scala-test", data)

    val result = sut.read("naveego-secrets/matching/scala-test")

    result.data.value should equal(data)
  }

  "org.naveego.vault.VaultHelper" should "keep own auth token fresh" in {

    var error: Exception = null

    val helperWithRootToken = vault.builder.withAddress(address)
      .withStrategies(TokenLoginStrategy("root"))
      .withErrorHandler(ex => error = ex)
      .build()

    val data = Map(
      "ttl" -> "2s",
      "explicit_max_ttl" -> "1m",
      "renewable" -> "true"
    )

    val secret = helperWithRootToken.write("auth/token/create", data.toJson)

    val sut = vault.builder.withAddress(address)
      .withStrategies(TokenLoginStrategy(secret.auth.clientToken))
      .build()

    Thread.sleep(1500)

    error should be(null)

    val result = sut.read("auth/token/lookup-self")

    result.data.value should not be(null)
  }


  "VaultHelper" should "be able to resolve secret once" in {

    val sut = vault.builder.withAddress(address)
      .withStrategies(TokenLoginStrategy("root"))
      .build()

    val secretPath = "secret/test-scala-client/data"
    val data = Map(
      "username"->"user",
      "password"->"pass"
    )

    sut.write(secretPath, data.toJson)

    val actual =  sut.getDeadSecret(SecretGetters.makeSecretTemplateGetter("vault://secret/test-scala-client/data?template={{.username}}:{{.password}}"))

    actual shouldBe a [Right[_, _]]

    actual.right.value should equal("user:pass")
  }

  "VaultHelper" should "be able to resolve a live secret" in {

    val sut = vault.builder.withAddress(address)
      .withStrategies(TokenLoginStrategy("root"))
      .build()

    val secretPath = "secret/test-scala-client/data"
    val data = Map(
      "username"->"user",
      "password"->"pass"
    )

    sut.write(secretPath, data.toJson)

    val actual =  sut.getLiveSecret("test-secret", SecretGetters.makeSecretTemplateGetter("vault://secret/test-scala-client/data?template={{.username}}:{{.password}}"))

    actual.value().right.value should equal("user:pass")
  }

}
