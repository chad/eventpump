name :="eventpump"

scalaVersion :="2.10.2"

version :="1.0"

mainClass := Some("com.wunderkinder.eventpump.Main")


libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.2.0"

libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "2.1.1" % "test"
  )

scalacOptions in Test ++= Seq("-Yrangepos")

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                    "releases"  at "http://oss.sonatype.org/content/repositories/releases")
