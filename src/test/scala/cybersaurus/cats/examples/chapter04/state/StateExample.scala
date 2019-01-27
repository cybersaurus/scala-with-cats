package cybersaurus.cats.examples.chapter04.state

import cats.data.State

import org.scalatest.{Matchers, WordSpec}

class StateExample extends WordSpec with Matchers {
  "State" should {

    val testInstance: State[Int, String] = State { st =>
      (st, s"The state is: [$st].")
    }

    "run" in {
      testInstance.run(10).value shouldBe (10, "The state is: [10].")

      testInstance.runS(10).value shouldBe 10
      testInstance.runA(10).value shouldBe "The state is: [10]."
    }
  }

}
