name := "xls-to-json-converter"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test
libraryDependencies += "org.apache.poi" % "poi" % "4.0.1"
libraryDependencies += "org.apache.poi" % "poi-ooxml" % "4.0.1"
libraryDependencies ++= Seq(
  "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % "0.39.0" % Compile,
  "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "0.39.0" % Provided // required only in compile-time
)
