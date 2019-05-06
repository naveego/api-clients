

organization := "com.naveego"
name := "vault"

version := "0.0.7"

scalaVersion := "2.11.8"

libraryDependencies += "com.softwaremill.sttp" %% "core" % "1.3.0"
libraryDependencies += "io.spray" %% "spray-json" % "1.3.4"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "org.scalamock" %% "scalamock" % "4.1.0" % Test

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"

libraryDependencies += "io.lemonlabs" %% "scala-uri" % "1.4.5"


isSnapshot := true

awsProfile := Some("black")
s3region := com.amazonaws.services.s3.model.Region.US_Standard

publishMavenStyle := false

publishTo := {
  val target = if (isSnapshot.value) "snapshots" else "releases"
  Some(s3resolver.value(s"Maven S3 bucket", s3(s"maven.n5o.black/$target")) withIvyPatterns)
}