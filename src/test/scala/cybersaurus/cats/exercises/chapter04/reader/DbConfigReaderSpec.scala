package cybersaurus.cats.exercises.chapter04.reader

import org.scalatest.{Matchers, WordSpec}

class DbConfigReaderSpec extends WordSpec with Matchers {
  "DbConfig Reader" should {

    val dbConfig = DbConfig(
      Map(1 -> "Tom", 2 -> "Fred", 3 -> "Harry"),
      Map("Tom" -> "abc", "Fred" -> "def", "Harry" -> "ghi")
    )

    "findUsername" in {
      DbConfig.findUsername(1).run(dbConfig) shouldBe Some("Tom")
      DbConfig.findUsername(0).run(dbConfig) shouldBe None
    }

    "checkPassword" in {
      DbConfig.checkPassword("Tom", "abc").run(dbConfig) shouldBe true
      DbConfig.checkPassword("Tom", "123").run(dbConfig) shouldBe false
      DbConfig.checkPassword("Tim", "abc").run(dbConfig) shouldBe false
    }

    "checkLogin" in {
      DbConfig.checkLogin(1, "abc").run(dbConfig) shouldBe true
      DbConfig.checkLogin(1, "123").run(dbConfig) shouldBe false
      DbConfig.checkLogin(0, "abc").run(dbConfig) shouldBe false
    }
  }
}
