import Dependencies.commonDependencies


name := "akka-kickstarter"
version := "0.1"
scalaVersion := "2.13.7"

lazy val commonSettings = Seq(
  organization := "demo.kickstarter",
  version := "0.1",
)


lazy val root = (project in file("."))
  .settings(
    name := "akka-kickstarter",
    libraryDependencies ++= commonDependencies,
    commonSettings
  )
