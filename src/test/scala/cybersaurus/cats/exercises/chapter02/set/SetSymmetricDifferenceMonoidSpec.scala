package cybersaurus.cats.exercises.chapter02.set

import cats.Monoid
import org.scalatest.{Matchers, WordSpec}

class SetSymmetricDifferenceMonoidSpec extends WordSpec with Matchers {

  "SetSymmetricDifferenceMonoid" should {

    implicit val testInstance: Monoid[Set[Int]] = new SetSymmetricDifferenceMonoid[Int]

    "empty" in {
      testInstance.empty shouldBe Set()
      testInstance.combine(testInstance.empty, Set(1,2,3)) should contain theSameElementsAs Set(1,2,3)
    }

    "combine" in {
      testInstance.combine(Set(1,2,3), Set(3,4,5)) should contain theSameElementsAs Set(1,2,4,5)
    }

    "|+|" in {
      import cats.syntax.semigroup._ // |+|

      Set(1,2,3) |+| Set(3,4,5) should contain theSameElementsAs Set(1,2,4,5)
    }
  }
}
