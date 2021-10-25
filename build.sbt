val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Rubik'sCubeGroup",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    // libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
    libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-core" % "2.6.1",
    "org.typelevel" %% "cats-effect" % "3.1.1",
    )
  )
