package cybersaurus.cats.exercises.chapter1.eq

import cats.Eq
import cats.implicits._
import cybersaurus.cats.exercises.chapter1.Cat
import org.scalatest.{Matchers, WordSpec}

class EqSpec extends WordSpec with Matchers {

  "Eq for Cat" should {
    import CatInstances.eqCat

    val mrCat      = Cat("Mr Cat",      15, "Orange & White")
    val charlieCat = Cat("Charlie Cat",  8, "Tabby")

    "return equal for Eq.eqv" in {
      eqCat.eqv(mrCat, mrCat) shouldBe true
    }

    "return equal for EqOps.eqv" in {
      mrCat.eqv(mrCat) shouldBe true
    }

    "return equal for EqOps.===" in {
      // This should work, but doesn't :-(
      // === appears to be masked by org.scalactic.TripleEquals.
      //  mrCat === mrCat shouldBe true
      //
      cats.syntax.eq.catsSyntaxEq[Cat] (mrCat) === mrCat  shouldBe true
    }

    "return not equal for Eq.neqv" in {
      eqCat.neqv(mrCat, charlieCat) shouldBe true
    }

    "return not equal for EqOps.=!=" in {
      // org.scalactic.TripleEquals defines !==, so no masking as for === above.
      mrCat =!= charlieCat shouldBe true
    }
  }

  "Eq for Option[Cat]" should {
    import cats.instances.option._
    import CatInstances.eqCat

    val mrCatMaybe      = Option(Cat("Mr Cat",      15, "Orange & White"))
    val charlieCatMaybe = Option(Cat("Charlie Cat",  8, "Tabby"))

    "return equal for Eq.eqv" in {
      catsKernelStdEqForOption[Cat].eqv(mrCatMaybe, mrCatMaybe) shouldBe true
    }

    "return equal for EqOps.eqv" in {
      mrCatMaybe.eqv(mrCatMaybe) shouldBe true
    }

    "return equal for EqOps.===" in {
      cats.syntax.eq.catsSyntaxEq[Option[Cat]] (mrCatMaybe) === mrCatMaybe  shouldBe true
    }

    "return not equal for Eq.neqv" in {
      catsKernelStdEqForOption[Cat].neqv(mrCatMaybe, charlieCatMaybe) shouldBe true
    }

    "return not equal for EqOps.=!=" in {
      mrCatMaybe =!= charlieCatMaybe shouldBe true
    }
  }
}
