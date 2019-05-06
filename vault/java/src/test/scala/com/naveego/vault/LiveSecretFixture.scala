package com.naveego.vault

import NaveegoJsonProtocol._
import org.scalamock.scalatest.MockFactory
import org.scalatest.{EitherValues, FlatSpec, Matchers}
import spray.json._

class LiveSecretFixture extends FlatSpec with Matchers with MockFactory with EitherValues {

  "secret with infinite lease" should "resolve once" in {
    val expected = "test-data"
    val spy = mockFunction[VaultApi, Either[String, Secret[String]]]
    spy expects * returning Right(Secret[String](Some(expected), null, false, 0))
    val sut = new LiveSecret("infinite-lease", mock[VaultApi], spy)
    sut.value.right.value should equal(expected)
  }

  "secret with renewable lease" should "be renewed" in {
    val expected = "test-data"
    val leaseID = "lease-id"
    val spy = mockFunction[VaultApi, Either[String, Secret[String]]]
    spy expects (*) returning Right(Secret[String](Some(expected), null, true, 1, leaseID))
    val api = stub[VaultApi]

    (api.write(_: String, _: JsObject)) when(*, *) returns Secret[JsObject](None)

    val sut = new LiveSecret("renewable-lease", api, spy)

    try {
      sut.value.right.value should equal(expected)
      Thread.sleep(750)
      (api.write(_: String, _: JsObject)) verify where {
        (path: String, payload: JsValue) =>
          path == "sys/lease/renew" && payload.asJsObject.fields("lease_id").convertTo[String].equals(leaseID)
      }
    }
    finally {
      sut.stop()
    }
  }


  "secret with non-renewable expiring lease" should "be re-acquired" in {
    val expected = "test-data"
    val leaseID = "lease-id"
    val spy = stubFunction[VaultApi, Either[String, Secret[String]]]
    spy when (*) returns Right(Secret[String](Some(expected), null, false, 1, leaseID))

    val api = mock[VaultApi]

    val sut = new LiveSecret("renewable-lease", api, spy)
    try {
      sut.value.right.value should equal(expected)
      Thread.sleep(750)
      spy verify * repeat 2
    } finally {
      sut.stop()
    }
  }

  "stopped secret" should "throw from value" in {
    val expected = "test-data"
    val leaseID = "lease-id"
    val spy = stubFunction[VaultApi, Either[String, Secret[String]]]
    spy when * returns Right(Secret[String](Some(expected), null, true, 100, leaseID))
    val api = stub[VaultApi]
    val sut = new LiveSecret("renewable-lease", api, spy)
    try {
      sut.value.right.value should equal(expected)
      sut.stop()
      sut.value.left.value should include ("stopped")
    }
    finally {
      sut.stop()
    }
  }


}
