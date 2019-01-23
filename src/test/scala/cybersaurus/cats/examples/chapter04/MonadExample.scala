package cybersaurus.cats.examples.chapter04

import scala.language.higherKinds
import cats.{Id, Monad}
import cats.syntax.functor._
import cats.syntax.flatMap._
import org.scalatest.{Matchers, WordSpec}

class MonadExample extends WordSpec with Matchers {

  // Sum squares for ints wrapped in arbitrary Monad context,,,,
  def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] = for {
    x <- a
    y <- b
  } yield x*x + y*y

  "sumSquare" should {
    "sum for Option[Int]" in {
      import cats.instances.option._

      sumSquare(Option(3), Option(4)) shouldBe Some(25)
    }

    "sum for List[Int]" in {
      import cats.instances.list._

      sumSquare(List(2,3,4), List(5,6)) shouldBe List(29,40,34,45,41,52)
    }

    "sum for Id[Int]" in {
      import cats.instances.list._

      sumSquare(3: Id[Int], 4: Id[Int]) shouldBe 25
    }
  }

}
