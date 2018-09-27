#!/bin/bash

#
# Script to run jaguar on defects4j Commons-Lang
#

CP="$(defects4j export -p cp.test -w commons-lang)"
PROJECT_DIR="commons-lang"
CLASSES_DIR="target/classes/"
TESTS_DIR="target/tests/"
JAGUAR_JAR="br.usp.each.saeg.jaguar.core-1.0.0-jar-with-dependencies.jar"
JAGUAR_MAIN_CLASS="br.usp.each.saeg.jaguar.core.cli.JaguarRunner"
JACOCO_JAR="jacocoagent.jar"
HEURISTIC="Ochiai"
LOG_LEVEL="TRACE" # ALL / TRACE / DEBUG / INFO / WARN / ERROR

# CONTROL-FLOW

java -javaagent:$JACOCO_JAR=output=tcpserver -cp .:$CP:$JAGUAR_JAR:$JACOCO_JAR \
	$JAGUAR_MAIN_CLASS \
		--heuristic "$HEURISTIC" \
		--outputType H \
		--output "control-flow.xml" \
		--logLevel "$LOG_LEVEL" \
		--projectDir "$PROJECT_DIR" \
		--classesDir "$CLASSES_DIR" \
		--testsDir "$TESTS_DIR"

# DATA-FLOW

java -javaagent:$JACOCO_JAR=output=tcpserver,dataflow=true -cp .:$CP:$JAGUAR_JAR:$JACOCO_JAR \
	$JAGUAR_MAIN_CLASS \
		--dataflow \
		--heuristic "$HEURISTIC" \
		--outputType H \
		--output "data-flow.xml" \
		--logLevel "$LOG_LEVEL" \
		--projectDir "$PROJECT_DIR" \
		--classesDir "$CLASSES_DIR" \
		--testsDir "$TESTS_DIR"
