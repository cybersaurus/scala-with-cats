package cybersaurus.cats.exercises.chapter01.printable

import cybersaurus.cats.exercises.chapter01.Cat
import org.scalatest.{Matchers, WordSpec}

class PrintableSpec extends WordSpec with Matchers {

  "Printable" should {
    "format String" in {
      import PrintableInstances.printableString

      Printable.format("my string") shouldBe "Printable: my string"
    }

    "format Int" in {
      import PrintableInstances.printableInt

      Printable.format(666) shouldBe "666"
    }

    "format MyType" in {
      val mrCat = Cat("Mr Cat", 15, "Orange & White")

      implicit val printableCat = new Printable[Cat] {
        override def format(cat: Cat): String = s"Cat: [name=${cat.name}, age=${cat.age}, colour=${cat.colour}]."
      }
      Printable.format(mrCat) shouldBe "Cat: [name=Mr Cat, age=15, colour=Orange & White]."
    }
  }
}
