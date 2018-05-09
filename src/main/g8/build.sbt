name := "kafka-custom-serdes"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(

  //kafka
  "org.apache.kafka" % "kafka-clients" % "1.0.0",

  //log4j
  "log4j" % "log4j" % "1.2.17",

  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",

  //slf4j
  "org.slf4j" % "slf4j-simple" % "1.7.25",

  //typesafe
  "com.typesafe" % "config" % "1.2.1"
)
