import de.johoop.cpd4sbt.CopyPasteDetector._
import de.johoop.cpd4sbt.{OutputType => CPDOutputType, ReportType => CPDReportType}
import de.johoop.findbugs4sbt._
import org.scalastyle.sbt.{PluginKeys, ScalastylePlugin}

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-Yrangepos",
  "-Xlint",
  //"-Xstrict-inference",
  "-Ywarn-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-inaccessible",
  //"-Ywarn-infer-any",//2.11
  "-Ywarn-nullary-override",
  "-Ywarn-nullary-unit",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard")

// Linter
//resolvers += "Linter Repository" at "https://hairyfotr.github.io/linteRepo/releases"

//addCompilerPlugin("com.foursquare.lint" %% "linter" % "0.1-SNAPSHOT")

//scalacOptions += "-P:linter:disable:UseHypot+CloseSourceFile"

// or...

//scalacOptions += "-Xplugin:../linteRepo/releases/com/foursquare/lint/linter_2.10/0.1-SNAPSHOT/linter_2.10-0.1-SNAPSHOT.jar"

//scalacOptions += "-Xplugin:../linteRepo/releases/com/foursquare/lint/linter_2.11/0.1-SNAPSHOT/linter_2.11-0.1-SNAPSHOT.jar"

// Wartremover
//addCompilerPlugin("org.brianmckenna" %% "wartremover" % "0.10")

//scalacOptions in (Compile, compile) += "-P:wartremover:only-warn-traverser:org.brianmckenna.wartremover.warts.Unsafe"

// Scalastyle
ScalastylePlugin.Settings

PluginKeys.config <<= baseDirectory { base => base / "sca" / "scalastyle-config.xml" }

// Findbugs (optionally put findbugs plugins (such as fb-contrib and findsecbugs) jars into ~/.findbugs/plugin)
findbugsSettings

findbugsEffort := Effort.Maximum

findbugsReportPath <<= baseDirectory { base => Some(base / "sca" / "findbugsoutput.xml") }

// CPD
cpdSettings

cpdTargetPath <<= baseDirectory { base => base / "sca" }

cpdReportName := "cpdoutput.txt"

cpdReportType := CPDReportType.Simple

cpdOutputType := CPDOutputType.Console
