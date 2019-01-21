package cybersaurus.cats.exercises.chapter2.set

import cats.Semigroup
import org.scalatest.{Matchers, WordSpec}

class SetUnionSemigroupSpec extends WordSpec with Matchers {

  "SetUnionSemigroup" should {

    implicit val testInstance: Semigroup[Set[Int]] = new SetUnionSemigroup[Int]

    "combine" in {
      testInstance.combine(Set(1,2,3), Set(3,4,5)) should contain theSameElementsAs Set(1,2,3,4,5)
    }

    "|+|" in {
      import cats.syntax.semigroup._ // |+|

      Set(1,2,3) |+| Set(3,4,5) should contain theSameElementsAs Set(1,2,3,4,5)
    }
  }

  "Pure Cats Set Union Semigroup" should {
    import cats.instances.set._
    import cats.syntax.semigroup._ // |+|

    "combine" in {
      Set(1,2,3) combine Set(3,4,5) should contain theSameElementsAs Set(1,2,3,4,5)
    }

    "|+|" in {
      Set(1,2,3) |+| Set(3,4,5) should contain theSameElementsAs Set(1,2,3,4,5)
    }
  }
}
