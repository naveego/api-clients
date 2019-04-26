package naveego.vault

import NaveegoJsonProtocol._
import org.scalatest.{FlatSpec, Matchers}
import spray.json._

class VaultHelperFixture extends FlatSpec with Matchers {

   val address = "http://vault.n5o.red"

  "org.naveego.vault.VaultHelper" should "authenticate, write and read with root token" in {
    val sut = vault.vault.withAddress(address)
      .withStrategies(TokenLoginStrategy("root"))
      .build()

    val data = Map[String, String](
      "a" -> "A"
    ).toJson.asJsObject()
    sut.write("secret/data/scala-test", data)

    val result = sut.read("secret/data/scala-test")

    result.data should equal(data)
  }

  "org.naveego.vault.VaultHelper" should "keep own auth token fresh" in {

    var error: Exception = null

    val helperWithRootToken = vault.vault.withAddress(address)
      .withStrategies(TokenLoginStrategy("root"))
      .withErrorHandler(ex => error = ex)
      .build()

    val data = Map(
      "ttl" -> "1s",
      "explicit_max_ttl" -> "1m",
      "renewable" -> "true",
    )

    val secret = helperWithRootToken.write("auth/token/create", data.toJson)

    val sut = vault.vault.withAddress(address)
      .withStrategies(TokenLoginStrategy(secret.auth.clientToken))
      .build()

    Thread.sleep(1000)

    error should be(null)

    val result = sut.read("auth/token/lookup-self")

    result.data should not be(null)
  }

}
