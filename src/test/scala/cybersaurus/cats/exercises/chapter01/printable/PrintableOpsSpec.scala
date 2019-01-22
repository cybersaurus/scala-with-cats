package cybersaurus.cats.exercises.chapter01.printable

import cybersaurus.cats.exercises.chapter01.Cat
import cybersaurus.cats.exercises.chapter01.printable.syntax.PrintableSyntax.PrintableOps
import org.scalatest.{Matchers, WordSpec}

class PrintableOpsSpec extends WordSpec with Matchers {

  "PrintableOps" should {
    "format String" in {
      import PrintableInstances.printableString

      "my string".formatPrintable() shouldBe "Printable: my string"
    }

    "format Int" in {
      import PrintableInstances.printableInt

      666.formatPrintable() shouldBe "666"
    }

    "format Cat" in {
      val mrCat = Cat("Mr Cat", 15, "Orange & White")

      implicit val printableCat = new Printable[Cat] {
        override def format(cat: Cat): String = s"Cat: [name=${cat.name}, age=${cat.age}, colour=${cat.colour}]."
      }

      mrCat.formatPrintable() shouldBe "Cat: [name=Mr Cat, age=15, colour=Orange & White]."
    }
  }
}
