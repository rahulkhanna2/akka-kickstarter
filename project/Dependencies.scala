import sbt._

trait Versions {
  val typeConfVersion = "1.4.1"
  val AkkaVersion = "2.6.8"
  val AkkaHttpVersion = "10.2.7"
  val ScalaTestVersion = "3.3.0-SNAP3"
  val ScalaMockVersion = "5.1.0"
  val circeVersion = "0.15.0-M1"
  val scalaMatcher = "3.3.0-SNAP3"
  val macwireVersion = "2.5.2"
  val macwireAkkaVersion = "2.5.2"
  val slickScalaVersion = "3.4.0-M1"
  val slickVersion = "3.3.2"
  val postgresVersion = "42.2.5"
  val slickPgVersion = "0.18.0"
  val hikaricpVersion = "3.2.3"
  val flywayCoreVersion = "3.2.1"
  val slickCircePgVersion = "0.19.4"
}

object Dependencies extends Versions {
  val typeConf = "com.typesafe" % "config" % typeConfVersion

  val actor = "com.typesafe.akka" %% "akka-actor" % AkkaVersion
  val akkaStream = "com.typesafe.akka" %% "akka-stream" % AkkaVersion
  val akkaHttp = "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion
  //  val circeCore = "io.circe" %% "circe-core" % circeVersion
  //  val circeParser = "io.circe" %% "circe-parser" % circeVersion
  //  val circeGeneric = "io.circe" %% "circe-generic" % circeVersion
  val macwire = "com.softwaremill.macwire" %% "macros" % macwireVersion //% "provided"
  val macwireAkka = "com.softwaremill.macwire" %% "macrosakka" % macwireAkkaVersion //% "provided"

  val slick = "com.typesafe.slick" %% "slick" % slickScalaVersion
  val postgres = "org.postgresql" % "postgresql" % postgresVersion
  val slickPg = "com.github.tminglei" %% "slick-pg" % slickPgVersion
  val hikaricp = "com.typesafe.slick" %% "slick-hikaricp" % hikaricpVersion
  val slickCirce = "com.github.tminglei" %% "slick-pg_circe-json" % slickCircePgVersion
  val sprayJson = "com.typesafe.akka" %% "akka-http-spray-json" % "10.2.7"

  val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"


  //Testing
  val scalaMock = "org.scalamock" %% "scalamock" % "4.4.0"
  val scalaTest = "org.scalatest" %% "scalatest" % "3.0.8"
  val akkaTestKit = "com.typesafe.akka" %% "akka-testkit" % "2.6.8"

  val commonDependencies = List(
    typeConf,
    macwire,
    macwireAkka,
    sprayJson,
    logback,
    actor,
    akkaStream,
    akkaHttp
  )

  val dbDependencies = List(slick, slickPg, postgres, hikaricp, slickCirce)

}