lazy val commonSettings = Seq(
  organization := "sgrep",
  version := "0.1.0",
  scalaVersion := "2.11.2"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "SGrep",
    libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
  )


