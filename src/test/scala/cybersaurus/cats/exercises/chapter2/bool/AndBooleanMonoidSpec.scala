package cybersaurus.cats.exercises.chapter2.bool

import cats.Monoid
import org.scalatest.{Matchers, WordSpec}

class AndBooleanMonoidSpec extends WordSpec with Matchers {

  "AndBooleanMonoid" should {
    val testInstance: Monoid[Boolean] = new AndBooleanMonoid

    "satisfy identity for empty" in {
      testInstance.empty && true  shouldBe true
      testInstance.empty && false shouldBe false
    }

    "satisfy combine" in {
      testInstance.combine(true, true)   shouldBe true
      testInstance.combine(true, false)  shouldBe false
      testInstance.combine(false, true)  shouldBe false
      testInstance.combine(false, false) shouldBe false
    }
  }
}
