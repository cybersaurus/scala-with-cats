package cybersaurus.cats.exercises.chapter01.printable

// Exercise 1.3
trait Printable[A] {
  def format(a: A): String
}

object Printable {
  def format[A: Printable](a: A): String = implicitly[Printable[A]].format(a)

  def print[A: Printable](a: A): Unit = (implicitly[Printable[A]].format _ andThen println) (a)
}

object PrintableInstances {
  implicit val printableString: Printable[String] = new Printable[String] {
    override def format(a: String): String = s"Printable: ${a}"
  }
  implicit val printableInt: Printable[Int] = (a: Int) => a.toString
}

package syntax {
  object PrintableSyntax {
    implicit class PrintableOps[A](a: A) {
      def formatPrintable()(implicit pa: Printable[A]): String = pa.format(a)

      def printPrintable()(implicit pa: Printable[A]): Unit = Printable.print(a)
    }
  }
}