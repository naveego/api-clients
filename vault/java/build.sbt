name := "naveego.vault"

version := "0.1"

scalaVersion := "2.12.8"


libraryDependencies += "com.softwaremill.sttp" %% "core" % "1.0.5"
libraryDependencies += "io.spray" %% "spray-json" % "1.3.4"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "org.scalamock" %% "scalamock" % "4.1.0" % Test

libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.11.2"
libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.11.2"

libraryDependencies += "io.lemonlabs" %% "scala-uri" % "1.4.5"