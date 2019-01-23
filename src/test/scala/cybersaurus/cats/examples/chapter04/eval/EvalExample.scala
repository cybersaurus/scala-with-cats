package cybersaurus.cats.examples.chapter04.eval

import java.time.Instant

import cats.Eval
import org.scalatest.{Matchers, WordSpec}

import scala.util.Random

class EvalExample extends WordSpec with Matchers {
  "Eval" should {
    "now"    in testEval(Eval.now(Instant.now),    isEager = true,  isMemorized = true)
    "later"  in testEval(Eval.later(Instant.now),  isEager = false, isMemorized = true)
    "always" in testEval(Eval.always(Instant.now), isEager = false, isMemorized = false)

    "memorize" in {
      val eval = Eval.always(Random.nextInt)

      eval.value should not be eval.value

      val memorizedEval = eval.memoize

      memorizedEval.value shouldBe memorizedEval.value
    }

  }

  private def testEval(eval: Eval[Instant], isEager: Boolean, isMemorized: Boolean): Unit = {
    def v(eval: Eval[Instant]): Instant = {Thread.sleep(5); eval.value}

    Thread.sleep(5)

    val checkpoint = Instant.now

    val value1 = v(eval)

    value1 isBefore checkpoint shouldBe isEager

    val value2 = v(eval)

    value2 == value1 shouldBe isMemorized
  }

  private def testMap(eval: Eval[Instant], isEager: Boolean, isMemorized: Boolean): Unit = {

  }
}
