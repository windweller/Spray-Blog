import sbtassembly.Plugin.AssemblyKeys._
import com.typesafe.sbt.SbtStartScript

name := "Spray-Blog"

organization  := "com.windweller"

version       := "0.1"

scalaVersion  := "2.10.3"

resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype snapshots"  at "https://oss.sonatype.org/content/repositories/snapshots/"
)

libraryDependencies ++= {
  val akkaV = "2.1.4"
  val sprayV = "1.1.1"
  Seq(
    "io.spray"            %   "spray-can"     % sprayV,
    "io.spray"            %   "spray-routing" % sprayV,
    "io.spray"            %%  "spray-json"    % "1.2.6",
    "org.json4s"          %% "json4s-native"  % "3.2.4",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %% "akka-slf4j"     % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.scalatest"       %% "scalatest"       % "2.1.5"  % "test",
    //add-ons
    "com.github.nscala-time" %% "nscala-time" % "1.2.0",
    //database
    "com.typesafe.slick" %%  "slick"         % "2.1.0",
    "postgresql" % "postgresql" % "9.1-901.jdbc4",
    "com.github.tminglei" %% "slick-pg" % "0.7.0"
  )
}

// Assembly settings
mainClass in Global := Some("com.blog.Boot")

jarName in assembly := "spray-blog-server.jar"

assemblySettings

// StartScript settings
seq(SbtStartScript.startScriptForClassesSettings: _*)

//Spray-Revolver Settings
Revolver.settings

