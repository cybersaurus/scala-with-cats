package cybersaurus.cats.exercises.chapter04.eval

import org.scalatest.{Matchers, WordSpec}

class FoldableSpec extends WordSpec with Matchers {
  "Foldable" should {
    val testInstance = new Foldable{}

    "foldRight with Int" in {
      val xs = List(1,2,3,4)

      val sumFn: (Int, Int) => Int = (cur, acc) => cur + acc

      testInstance.foldRight(xs, 0)(sumFn) shouldBe 10
    }

    "foldRight with String" in {
      val xs = List("a","b","c","d")

      val concatFn: (String, String) => String = _ + _

      testInstance.foldRight(xs, "")(concatFn) shouldBe "abcd"
    }
  }
}
