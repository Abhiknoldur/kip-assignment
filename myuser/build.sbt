name := "myuser"

version := "0.1"

scalaVersion := "2.12.6"

lagomCassandraEnabled in ThisBuild := false
lagomKafkaEnabled in ThisBuild := false

val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.4" % Test

lazy val `myuser` = (project in file("."))
  .aggregate(`myuser-api`, `myuser-impl`)

lazy val `myuser-api` = (project in file("myuser-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `myuser-impl` = (project in file("myuser-impl"))
  .enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslTestKit,
      macwire,
      scalaTest
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`myuser-api`)