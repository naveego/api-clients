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

  "org.naveego.vault.VaultHelper" should "authenticate, write and read with kubernetes token" in {
    val sut = vault.builder.withAddress(address)
      .withStrategies(KubernetesLoginStrategy("matching", jwt ="eyJhbGciOiJSUzI1NiIsImtpZCI6IiJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJ0ZW5hbnRzIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6Im1hdGNoaW5nLXRva2VuLXc4amtsIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6Im1hdGNoaW5nIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQudWlkIjoiYzdjNGI5ZDMtNmRkNC0xMWU5LTk5MTAtMDgwMDI3ZGYyZmRhIiwic3ViIjoic3lzdGVtOnNlcnZpY2VhY2NvdW50OnRlbmFudHM6bWF0Y2hpbmcifQ.sSFPwVBRVkWOD7Xrgd4L3c76jxiYYmdRZyUtTAsFOlckfQ6y-V45VZYdztZByGWQD2KQv8aJL8Pgryt09uygLtGmSu93qjJESysmhGLpQvkA_fB-wIYJrZZ_f-0v40AGX7KgAyf1F3IYyTgIHyXfuhtR28CkiC1ZduIsrhP63Czj1NKmuFC2iWfS3zicduvL38ZwkMUBnlrYbCx1yL0pO1dtGbCY7XRG8zkTuAD49mkNVLwlRUXoCp7lW2ty8GP6qp5kgHek7gV2s7bPXz8Oa5lhGjzh5W4ELDCOU3wPTNMCqzjyo6-vzfWxf3fLgnmMeYH8FMYyBMw_1pq_Ww-zog"))
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
