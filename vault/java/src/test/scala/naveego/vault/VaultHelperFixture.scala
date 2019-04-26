package naveego.vault

import NaveegoJsonProtocol._
import org.scalatest.{FlatSpec, Matchers, OptionValues}
import spray.json._

class VaultHelperFixture extends FlatSpec with Matchers with OptionValues {

   val address = "http://vault.n5o.red"

  "org.naveego.vault.VaultHelper" should "authenticate, write and read with root token" in {
    val sut = vault.vault.withAddress(address)
      .withStrategies(TokenLoginStrategy("root"))
      .build()

    val data = Map[String, String](
      "a" -> "A"
    )
    sut.write[NoData]("secret/data/scala-test", data.toJson.asJsObject())

    val result = sut.read[Map[String,String]]("secret/data/scala-test")

    result.data.value should equal(data)
  }

  "org.naveego.vault.VaultHelper" should "keep own auth token fresh" in {

    var error: Exception = null

    val helperWithRootToken = vault.vault.withAddress(address)
      .withStrategies(TokenLoginStrategy("root"))
      .withErrorHandler(ex => error = ex)
      .build()

    val data = Map(
      "ttl" -> "2s",
      "explicit_max_ttl" -> "1m",
      "renewable" -> "true",
    )

    val secret = helperWithRootToken.write[NoData]("auth/token/create", data.toJson)

    val sut = vault.vault.withAddress(address)
      .withStrategies(TokenLoginStrategy(secret.auth.clientToken))
      .build()

    Thread.sleep(1500)

    error should be(null)

    val result = sut.read[NoData]("auth/token/lookup-self")

    result.data.value should not be(null)
  }

}
