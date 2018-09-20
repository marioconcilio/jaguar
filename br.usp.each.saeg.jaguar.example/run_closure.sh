#!/bin/bash

#
# Script to run jaguar on defects4j Closure
#

CP="$(defects4j export -p cp.test -w closure)"
PROJECT_DIR="closure"
CLASSES_DIR="build/classes/"
TESTS_DIR="build/test/"
JAGUAR_JAR="br.usp.each.saeg.jaguar.core-1.0.0-jar-with-dependencies.jar"
JAGUAR_MAIN_CLASS="br.usp.each.saeg.jaguar.core.cli.JaguarRunner"
JACOCO_JAR="jacocoagent.jar"
HEURISTIC="Ochiai"
LOG_LEVEL="DEBUG" # ALL / TRACE / DEBUG / INFO / WARN / ERROR

# CONTROL-FLOW

nohup nice time java -javaagent:$JACOCO_JAR=output=tcpserver -cp .:$CP:$JAGUAR_JAR:$JACOCO_JAR \
	$JAGUAR_MAIN_CLASS \
		--heuristic "$HEURISTIC" \
		--outputType H \
		--output "control-flow.xml" \
		--logLevel "$LOG_LEVEL" \
		--projectDir "$PROJECT_DIR" \
		--classesDir "$CLASSES_DIR" \
		--testsDir "$TESTS_DIR" \
		--testSuite "$TEST_SUITE" >& output-closure-cf

# DATA-FLOW

nohup nice time java -javaagent:$JACOCO_JAR=output=tcpserver,dataflow=true -cp .:$CP:$JAGUAR_JAR:$JACOCO_JAR \
	$JAGUAR_MAIN_CLASS \
		--dataflow \
		--heuristic "$HEURISTIC" \
		--outputType H \
		--output "data-flow.xml" \
		--logLevel "$LOG_LEVEL" \
		--projectDir "$PROJECT_DIR" \
		--classesDir "$CLASSES_DIR" \
		--testsDir "$TESTS_DIR" \
		--testSuite "$TEST_SUITE" >& output-closure-df
