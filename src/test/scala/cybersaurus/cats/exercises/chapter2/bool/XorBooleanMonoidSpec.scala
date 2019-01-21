package cybersaurus.cats.exercises.chapter2.bool

import cats.Monoid
import org.scalatest.{Matchers, WordSpec}


class XorBooleanMonoidSpec extends WordSpec with Matchers {

  "XorBooleanMonoid" should {
    val testInstance: Monoid[Boolean] = new XorBooleanMonoid

    "satisfy identity for empty" in {
      testInstance.empty ^ true  shouldBe true
      testInstance.empty ^ false shouldBe false
    }

    "satisfy combine" in {
      testInstance.combine(true, true)   shouldBe false
      testInstance.combine(true, false)  shouldBe true
      testInstance.combine(false, true)  shouldBe true
      testInstance.combine(false, false) shouldBe false
    }
  }
}