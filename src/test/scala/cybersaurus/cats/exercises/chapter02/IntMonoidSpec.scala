package cybersaurus.cats.exercises.chapter02

import cats.instances.int._
import cats.syntax.monoid._
import org.scalatest.{Matchers, WordSpec}

class IntMonoidSpec extends WordSpec with Matchers {

  "Cats Monoid[Int]" should {
    "combine" in {
      1 combine 2 shouldBe 3
    }

    "|+|" in {
      1 |+| 2 shouldBe 3
    }

    "empty" in {
      cats.Monoid[Int].empty shouldBe 0
    }
  }

}
