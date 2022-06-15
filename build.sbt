ThisBuild / version := "0.1.0-SNAPSHOT"

val scala2 = "2.13.8"
val scala3 = "3.2.0-RC1-bin-20220614-741587d-NIGHTLY"

lazy val root = Project(
  id = "root",
  base = file("root"),
).settings(
  scalaVersion := scala3
).dependsOn(lib)

lazy val lib = Project(
  id = "lib",
  base = file("lib"),
).settings(
  scalaVersion := scala2,
  crossScalaVersions := Seq(scala3)
)
