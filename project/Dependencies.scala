import sbt._

object Dependencies {
  val sparkVersion = "2.3.1"
  lazy val sparkCore = "org.apache.spark" %% "spark-core" % sparkVersion
  lazy val sparkMlLib = "org.apache.spark" %% "spark-mllib" % sparkVersion
  lazy val typesafeConfig = "com.typesafe" % "config" % "1.3.1"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val scalaMock = "org.scalamock" %% "scalamock" % "4.1.0"
  lazy val sbtAssembly = "com.eed3si9n" % "sbt-assembly" % "0.14.7"
  lazy val json4s = "org.json4s" %% "json4s-native" % "3.2.11"
}

