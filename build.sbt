name := "xcache"

version := "1.0"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalaVersion := "2.11.2"

mainClass in Compile := Some("com.pamu_nagarjuna.xcache.Main")

libraryDependencies ++= Seq("org.scalatest" % "scalatest_2.11" % "2.2.4" % "test")