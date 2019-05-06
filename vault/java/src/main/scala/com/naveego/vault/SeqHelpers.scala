package com.naveego.vault

import scala.collection.{GenIterable, Iterator}
import scala.util.{Either, Right}

object SeqHelpers {

  implicit class EitherSeq[Left, Right](self: Seq[Either[Left, Right]]) {

    /**
      * Iterates through the sequence, accumulating Left values
      * until a Right is encountered, then returning that Right.
      * If no Right is found, the accumulated Left will be returned.
      * *
      * @param fn
      * @return
      */
    def reduceLeftEither(seed: Left)(fn: (Left, Left) => Left) : Either[Left, Right] = {
      val i: Iterator[Either[Left, Right]] = self match {
        case it: Iterator[Either[Left, Right]] => it
        case _: GenIterable[_] => self.toIterator   // If it might be parallel, be sure to .seq or use iterator!
        case _ =>
          return Left(seed)
      }

      var acc = seed

      while(i.hasNext) {

        acc = i.next() match {
          case Left(x) => fn(acc, x)
          case Right(x) => return Right(x)
        }
      }

      Left(acc)
    }
  }

}
