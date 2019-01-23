package cybersaurus.cats.examples.chapter04

import cats.syntax.either._ // asRight

import org.scalatest.{Matchers, WordSpec}

class EitherExample extends WordSpec with Matchers {

  val e1: Either[String,  Int] = 3.asRight[String]
  val e2: Either[Nothing, Int] = 4.asRight

  "Either with explicit right projection" in {
    (for {
      v1 <- e1.right
      v2 <- e2.right
    } yield v1 + v2) shouldBe Right(7)
  }

  "EitherMonad" should {
    "support right-bias" in {
      import cats.instances.either._ // Monad

      (for {
        v1 <- e1
        v2 <- e2
      } yield v1 + v2) shouldBe Right(7)
    }

    "ensure" in {
       1.asRight[String].ensure("Must be non-negative")(_ > 0) shouldBe Right(1)
       0.asRight[String].ensure("Must be non-negative")(_ > 0) shouldBe Left("Must be non-negative")
    }

    "getOrElse" in {
      "error".asLeft.getOrElse(2) shouldBe 2
    }

    "orElse" in {
      "error".asLeft.orElse(2.asRight) shouldBe Right(2)
    }

    "recover" in {
      "error".asLeft[Int].recover {
        case _: String => 1
      }
    }

    "swap" in {
      123.asRight.swap shouldBe Left(123)
    }

  }
}
