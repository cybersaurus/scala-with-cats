package cybersaurus.cats.exercises.chapter04.reader

import cats.data.Reader

case class DbConfig(usernameDb: Map[Int, String],
                    passwordDb: Map[String, String])

object DbConfig {
  type DbReader[A] = Reader[DbConfig, A]

  def findUsername(userId: Int): DbReader[Option[String]] =
    Reader(dbConfig =>
      dbConfig
        .usernameDb
        .get(userId)
    )

  def checkPassword(username: String, password: String): DbReader[Boolean] =
    Reader(dbConfig =>
      dbConfig
        .passwordDb
        .get(username)
        .contains(password)
    )

  def checkLogin(userId: Int, password: String): DbReader[Boolean] = {
    findUsername(userId)
      .flatMap { usernameMaybe =>
        usernameMaybe match {
          case Some(username) => checkPassword(username, password)
          case None           => Reader(_ => false)
        }
      }
  }
}


