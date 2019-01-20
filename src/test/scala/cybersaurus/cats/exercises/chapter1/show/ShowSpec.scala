package cybersaurus.cats.exercises.chapter1.show

import cats.Show
import cats.implicits._
import cybersaurus.cats.exercises.chapter1.Cat
import org.scalatest.{Matchers, WordSpec}

class ShowSpec extends WordSpec with Matchers {

  "Show for Cat" should {
    val cat = Cat("Mr Cat", 15, "Orange & White")

    "render Cat as a string using Show.fromToString" in {
      implicit val toStringShow: Show[Cat] = Show.fromToString[Cat]

      cat.show shouldBe "Cat(Mr Cat,15,Orange & White)"
    }

    "render Cat as a string using Show.show" in {
      implicit val catShow: Show[Cat] = Show.show(cat => s"Cat is: name: [${cat.name}], age: [${cat.age}], colour: [${cat.colour}].")

      cat.show shouldBe "Cat is: name: [Mr Cat], age: [15], colour: [Orange & White]."
    }

    "render string using show string interpolator" in {
      import cybersaurus.cats.exercises.chapter1.show.CatInstances.showCat

      show"Interpolated string is: $cat" shouldBe "Interpolated string is: Mr Cat is a 15 year-old Orange & White cat."
    }
  }
}
