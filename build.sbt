import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.12",
      version := "1.0.0"
    )),
    name := "example-spark",
    libraryDependencies ++= Seq(
      sparkCore % Provided,
      sparkMlLib % Provided,
      json4s,
      typesafeConfig,
      scalaTest % Test,
      scalaMock % Test
    )
  )