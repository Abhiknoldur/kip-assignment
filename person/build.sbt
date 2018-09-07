organization in ThisBuild := "com.knoldus"
version in ThisBuild := "1.0-SNAPSHOT"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.12.4"


val scalaTest = "org.scalatest" %% "scalatest" % "3.0.4" % Test

val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "person",
    libraryDependencies += scalaTest % Test
  )
lazy val `person` = (project in file("."))
  .aggregate(`person-api`, `person-impl`)

lazy val `person-api` = (project in file("person-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `person-impl` = (project in file("person-impl"))
  .enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceCassandra,
      lagomScaladslKafkaBroker,
      lagomScaladslTestKit,
      macwire,
      scalaTest
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`person-api`)

//Define the external service’s host and port name.
lagomUnmanagedServices in ThisBuild := Map("external-service" -> "https://gist.githubusercontent.com")
