package cybersaurus.cats.exercises.chapter2.set

import cats.Semigroup
import org.scalatest.{Matchers, WordSpec}

class SetIntersectionSemigroupSpec extends WordSpec with Matchers {

  "SetIntersectionSemigroup" should {

    implicit val testInstance: Semigroup[Set[Int]] = new SetIntersectionSemigroup[Int]

    "combine" in {
      testInstance.combine(Set(1,2,3), Set(3,4,5)) should contain theSameElementsAs Set(3)
    }

    "|+|" in {
      import cats.syntax.semigroup._ // |+|

      Set(1,2,3) |+| Set(3,4,5) should contain theSameElementsAs Set(3)
    }
  }
}
