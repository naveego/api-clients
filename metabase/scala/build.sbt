
organization := "com.naveego"

name := "metabase-api"

version := "0.0.1"

scalaVersion := "2.11.8"

unmanagedSourceDirectories in Compile := (javaSource in Compile).value :: Nil

libraryDependencies += "com.microsoft.rest" % "client-runtime" % "1.6.4"

isSnapshot := true

awsProfile := Some("black")
s3region := com.amazonaws.services.s3.model.Region.US_Standard

publishMavenStyle := false

publishTo := {
  val target = if (isSnapshot.value) "snapshots" else "releases"
  Some(s3resolver.value(s"Maven S3 bucket", s3(s"maven.n5o.black/$target")) withIvyPatterns)
}