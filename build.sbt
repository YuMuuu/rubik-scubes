val scala3Version = "3.1.0"
// val scala3Version = "3.0.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Rubik'sCubeGroup",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-core" % "2.6.1",
    "org.typelevel" %% "cats-effect" % "3.1.1",
    "com.github.julien-truffaut" %% "monocle-core" % "3.0.0-M6",
    // "com.github.julien-truffaut" %% "monocle-macro" % "3.0.0-M6",
    "com.novocode" % "junit-interface" % "0.11" % "test"
    )
  )
