package naveego.vault

import org.scalamock.scalatest.MockFactory
import org.scalatest.{EitherValues, FlatSpec, Matchers, WordSpec}
import naveego.vault.SeqHelpers._

class SeqHelpersFixture extends WordSpec with Matchers with EitherValues {

  "EitherSeq.reduceLeftEither" when {
    "seq is empty" should {
      "return seed" in {
        val result = Seq[Either[Int, String]]().reduceLeftEither(0)((acc, x) => acc + x)
        result.left.value should be (0)
      }
    }

    "seq is all left" should {
      "return accumulated" in {
        val result = Seq[Either[Int, String]](Left(1), Left(2), Left(3)).reduceLeftEither(0)((acc, x) => acc + x)
        result.left.value should be (6)
      }
    }

    "seq has right" should {
      "return first right" in {
        val result = Seq[Either[Int, String]](Left(1), Left(2), Right("ok")).reduceLeftEither(0)((acc, x) => acc + x)
        result.right.value should be ("ok")
      }
    }

    "seq has left after right" should {
      "return first right" in {
        val result = Seq[Either[Int, String]](Left(1), Right("ok"), Left(2)).reduceLeftEither(0)((acc, x) => acc + x)
        result.right.value should be ("ok")
      }
    }

    "seq has right after right" should {
      "return first right" in {
        val result = Seq[Either[Int, String]](Left(1), Right("ok"), Right("bad")).reduceLeftEither(0)((acc, x) => acc + x)
        result.right.value should be ("ok")
      }
    }

  }
}