package cybersaurus.cats.exercises.chapter2

import cats.instances.int._  // implicit Monoid[Int] instance
import cats.syntax.monoid._  // monoid.catsSyntaxMonoid, MonoidOps.combine, |+|

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
