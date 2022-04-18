ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.13.5"
ThisBuild / version      := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .aggregate(server, client, shared.jvm, shared.js)

lazy val server = project
  .settings(
    scalaJSProjects := Seq(client),
    Assets / pipelineStages  := Seq(scalaJSPipeline),
    pipelineStages := Seq(digest, gzip),
    // triggers scalaJSPipeline when using compile or continuous compilation
    Compile / compile := ((Compile / compile) dependsOn scalaJSPipeline).value,
    libraryDependencies += guice,
    libraryDependencies += "com.vmunier" %% "scalajs-scripts" % "1.2.0"
  )
  .enablePlugins(PlayScala, WebScalaJSBundlerPlugin)
  .dependsOn(shared.jvm)

lazy val client = project
  .settings(
    scalacOptions += "-Ymacro-annotations",
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies += "me.shadaj" %%% "slinky-web" % "0.7.0",
    libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.7.0",
    Compile / npmDependencies += "react" -> "16.12.0",
    Compile / npmDependencies += "react-dom" -> "16.12.0",
    Compile / npmDependencies += "react-proxy" -> "1.1.8",
  )
  .enablePlugins(ScalaJSPlugin, ScalaJSWeb, ScalaJSBundlerPlugin)
  .dependsOn(shared.js)

lazy val shared = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("shared"))
  .jsConfigure(_.enablePlugins(ScalaJSWeb, ScalaJSBundlerPlugin))

onLoad in Global := (onLoad in Global).value andThen {s: State => "project server" :: s}