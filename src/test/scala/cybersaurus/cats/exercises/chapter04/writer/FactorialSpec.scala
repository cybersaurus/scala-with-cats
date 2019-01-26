package cybersaurus.cats.exercises.chapter04.writer

import org.scalatest.{Matchers, WordSpec}

class FactorialSpec extends WordSpec with Matchers {
  "Factorial" should {
    val testInstance = new Factorial

    "wrap result in Writer" in {
      val (logs,fact) = testInstance.factorial(5).run

      logs should contain theSameElementsAs Vector(
        "fact 0 1",
        "fact 1 1",
        "fact 2 2",
        "fact 3 6",
        "fact 4 24",
        "fact 5 120"
      )
      fact shouldBe 120
    }
  }

}
