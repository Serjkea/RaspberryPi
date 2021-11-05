name := "raspberryProject"

version := "0.1"

scalaVersion := "2.12.12"

idePackagePrefix := Some("ru.raspberry")

libraryDependencies += {
  "com.pi4j" % "pi4j-core" % "2.0-SNAPSHOT"
  "com.pi4j" % "pi4j-plugin-linuxfs" % "2.0-SNAPSHOT"
  "com.pi4j" % "pi4j-plugin-raspberrypi" % "2.1.0"
}

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}