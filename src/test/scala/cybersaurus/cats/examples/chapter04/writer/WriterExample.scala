package cybersaurus.cats.examples.chapter04.writer

import cats.data.Writer
import cats.instances.vector._
import cats.syntax.applicative._
import cats.syntax.writer._

import org.scalatest.{Matchers, WordSpec}

class WriterExample extends WordSpec with Matchers {
  type Logged[A] = Writer[Vector[String], A]

  "Writer" should {
    "map/flatMap via for-comprehension" in {
      val writer = for {
        a <- 10.pure[Logged]
        _ <- Vector("a", "b", "c").tell
        b <- 32.writer(Vector("x", "y", "z"))
      } yield a + b

      writer shouldBe Writer.apply(Vector("a","b","c", "x","y","z"), 42)
    }

    "map/flatMap" in {
      val writer = 10.pure[Logged]
        .flatMap(
          a => Vector("a", "b", "c").tell.flatMap(
            _ => 32.writer(Vector("x", "y", "z")).map(
              b => a + b
            )
          )
        )

      val written: Vector[String] = writer.written
      written should contain theSameElementsAs Vector("a","b","c", "x","y","z")

      val value: Int = writer.value
      value should be (42)
    }

    "bimap" in {
      val writer: Writer[Vector[String], Int] = Writer(Vector("a","b","c"), 10)

      val (l,v) = writer
        .bimap(
          l => l.map(_.toUpperCase),
          v => v * 10
        )
        .run

      l should contain theSameElementsAs Vector("A", "B", "C")
      v shouldBe 100
    }
  }

}
