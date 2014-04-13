organization  := "com.blog"

version       := "0.1"

scalaVersion  := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV = "2.1.4"
  val sprayV = "1.1.1"
  Seq(
    "io.spray"            %   "spray-can"     % sprayV,
    "io.spray"            %   "spray-routing" % sprayV,
    "io.spray"            %   "spray-testkit" % sprayV  % "test",
    "io.spray"            %%  "spray-json"    % "1.2.6",
    "org.json4s"          %% "json4s-native"  % "3.2.4",
    "com.typesafe.slick"  %%  "slick"         % "2.0.1",
    "mysql"               % "mysql-connector-java" % "5.1.12",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2"        % "2.2.3" % "test",
    "cc.mallet"           % "mallet"          % "2.0.7-RC2"
  )
}

Twirl.settings
