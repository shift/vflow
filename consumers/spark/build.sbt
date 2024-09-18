import AssemblyKeys._

name := "vflow_spark_consumer"

version := "1.0"

scalaVersion := "2.13.8"



libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-streaming-kafka-0-10" % "3.2.1",
  "org.apache.spark" %% "spark-core" % "3.5.3",
  "org.apache.spark" %% "spark-streaming" % "3.2.1",
  "org.apache.spark" %% "spark-sql" % "3.2.1"
)

assemblySettings

mergeStrategy in assembly := {
  case m if m.toLowerCase.endsWith("manifest.mf")          => MergeStrategy.discard
  case m if m.toLowerCase.matches("meta-inf.*\\.sf$")      => MergeStrategy.discard
  case "log4j.properties"                                  => MergeStrategy.discard
  case m if m.toLowerCase.startsWith("meta-inf/services/") => MergeStrategy.filterDistinctLines
  case "reference.conf"                                    => MergeStrategy.concat
  case _                                                   => MergeStrategy.first
}