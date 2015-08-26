name := "xcache"

version := "1.0"

//javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

scalaVersion := "2.11.2"

mainClass in Compile := Some("com.pamu_nagarjuna.xcache.Main")

libraryDependencies ++= Seq("org.scalatest" % "scalatest_2.11" % "2.2.4" % "test","org.mockito" % "mockito-core" % "1.9.5")