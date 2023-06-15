val scala2Version = "2.12.10"
val AkkaVersion = "2.7.0"
val AkkaHttpVersion = "10.5.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "jenhome-api",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala2Version,

    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
      "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
      "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
      "org.scalameta" %% "munit" % "0.7.29" % Test
    )
  )