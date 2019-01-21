package cybersaurus.cats.exercises.chapter2.set

import cats.Semigroup
import org.scalatest.{Matchers, WordSpec}

class SetSymmetricDifferenceSemigroupSpec extends WordSpec with Matchers {

  "SetSymmetricDifferenceSemigroup" should {

    implicit val testInstance: Semigroup[Set[Int]] = new SetSymmetricDifferenceSemigroup[Int]

    "combine" in {
      testInstance.combine(Set(1,2,3), Set(3,4,5)) should contain theSameElementsAs Set(1,2,4,5)
    }

    "|+|" in {
      import cats.syntax.semigroup._ // |+|

      Set(1,2,3) |+| Set(3,4,5) should contain theSameElementsAs Set(1,2,4,5)
    }
  }
}
