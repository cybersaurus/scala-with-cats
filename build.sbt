name := "scala-with-cats"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.typelevel" %% "cats-core" % "1.5.0"

lazy val testScope = "test"

libraryDependencies += "org.scalatest" %% "scalatest"   % "3.0.3"      % testScope
