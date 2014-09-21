organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += "spray" at "http://repo.spray.io/"

libraryDependencies ++= {
  val akkaV = "2.3.0"
  val sprayV = "1.3.1"
  Seq(
    "io.spray"            %   "spray-can"      % sprayV,
    "io.spray"            %   "spray-httpx"    % sprayV,
    "io.spray"            %%  "spray-json" % "1.2.6",
    "io.spray"            %   "spray-routing"  % sprayV,
    "io.spray"            %   "spray-client"   % sprayV,
    "io.spray"            %   "spray-testkit"  % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"     % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"   % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"    % "2.3.7" % "test",
    "org.mockito"         % "mockito-all"      % "1.9.5" % "test"
  )
}
