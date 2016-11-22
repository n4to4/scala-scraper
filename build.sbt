import scalariform.formatter.preferences._

name := "scala-scraper"
organization := "net.ruippeixotog"
version := "1.1.1-SNAPSHOT"

scalaVersion := "2.11.8"

crossScalaVersions := Seq(scalaVersion.value, "2.12.0")

resolvers ++= Seq(
  Resolver.sonatypeRepo("snapshots"),
  "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases")

libraryDependencies ++= Seq(
  "com.github.nscala-time"     %% "nscala-time"          % "2.14.0",
  "com.typesafe"                % "config"               % "1.3.1",
  "net.sourceforge.htmlunit"    % "htmlunit"             % "2.23",
  "org.jsoup"                   % "jsoup"                % "1.10.1",
  "org.scalaz"                 %% "scalaz-core"          % "7.2.7",
  "org.http4s"                 %% "http4s-blaze-server"  % "0.15.0-SNAPSHOT"      % "test",
  "org.http4s"                 %% "http4s-dsl"           % "0.15.0-SNAPSHOT"      % "test",
  "org.slf4j"                   % "slf4j-nop"            % "1.7.21"               % "test",
  "org.specs2"                 %% "specs2-core"          % "3.8.6"                % "test")

scalariformPreferences := scalariformPreferences.value
  .setPreference(DanglingCloseParenthesis, Prevent)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, true)

scalacOptions ++= Seq(
  "-Ywarn-unused-import",
  "-deprecation",
  "-unchecked",
  "-feature",
  "-language:implicitConversions",
  "-language:higherKinds")

publishTo <<= version { v =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := { _ => false }

licenses := Seq("MIT License" -> url("http://www.opensource.org/licenses/mit-license.php"))
homepage := Some(url("https://github.com/ruippeixotog/scala-scraper"))
pomExtra :=
  <scm>
    <url>https://github.com/ruippeixotog/scala-scraper</url>
    <connection>scm:git:https://github.com/ruippeixotog/scala-scraper.git</connection>
  </scm>
  <developers>
    <developer>
      <id>ruippeixotog</id>
      <name>Rui Gonçalves</name>
      <url>http://www.ruippeixotog.net</url>
    </developer>
  </developers>
