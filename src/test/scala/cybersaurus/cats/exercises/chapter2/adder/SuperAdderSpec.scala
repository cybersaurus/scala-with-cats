package cybersaurus.cats.exercises.chapter2.adder

import cats.implicits._
import org.scalatest.{Matchers, WordSpec}

class SuperAdderSpec extends WordSpec with Matchers {
  "SuperAdder" should {

    val testInstance = new SuperAdder

    "add Ints" in {
      testInstance.add(List(1,2,3,4)) shouldBe 10
    }

    "add Option[Int]s" in {
      testInstance.add(List(Option(1), Option(2), Option(3), Option(4))) shouldBe Some(10)
    }

    "add Option[Int]s, including Nones" in {
      testInstance.add(List(None, Some(1), Some(2), Some(3), None)) shouldBe Some(6)
    }

    "add Orders" in {
      testInstance.add(List(Order(100.0, 2.0), Order(50.0, 1.0))) shouldBe Order(150.0, 3.0)
    }
  }
}
