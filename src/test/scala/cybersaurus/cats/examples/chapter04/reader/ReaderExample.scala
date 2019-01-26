package cybersaurus.cats.examples.chapter04.reader

import cats.data.Reader
import org.scalatest.{Matchers, WordSpec}

class ReaderExample extends WordSpec with Matchers {
  case class CatConfig(name: String, favouriteFood: String)

  "Reader" should {
    val catConfig = CatConfig("Mr Cat", "Chicken")

    val catNameReader: Reader[CatConfig, String] = Reader(catConfig => catConfig.name)

    "run" in {
      val catNameReader: Reader[CatConfig, String] = Reader(catConfig => catConfig.name)

      catNameReader.run(catConfig) shouldBe "Mr Cat"
    }

    "map" in {
      val greetKitty: Reader[CatConfig, String] = catNameReader.map{name => s"Hello [$name]."}

      greetKitty.run(catConfig) shouldBe "Hello [Mr Cat]."
    }

    "flatMap" in {
      val greetKitty: Reader[CatConfig, String] = catNameReader.map{name => s"Hello [$name]."}

      val feedKitty:  Reader[CatConfig, String] = Reader(catConfig => s"Have a nice bowl of [${catConfig.favouriteFood}].")

      val greetAndFeed: Reader[CatConfig, String] = for {
        greet <- greetKitty
        feed  <- feedKitty
      } yield s"$greet $feed"

      greetAndFeed.run(catConfig) shouldBe "Hello [Mr Cat]. Have a nice bowl of [Chicken]."
    }
  }

}
