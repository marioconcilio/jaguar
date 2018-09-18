all: prepare projects

prepare:
	cd .. && $(MAKE) prepare build_core
	cp ../br.usp.each.saeg.jaguar.core/target/br.usp.each.saeg.jaguar.core-1.0.0-jar-with-dependencies.jar .
	cp ../br.usp.each.saeg.jaguar.plugin/lib/jacocoagent.jar .

# Download, compile and run tests of all projects available in defects4j
projects:
	# JFreeChart
	defects4j checkout -p Chart -v 1b -w jfreechart
	cd jfreechart && defects4j compile && defects4j test

	# Closure
	defects4j checkout -p Closure -v 1b -w closure
	cd closure && defects4j compile && defects4j test

	# Commons-Lang
	defects4j checkout -p Lang -v 1b -w commons-lang
	cd commons-lang && defects4j compile && defects4j test

	# Commons-Math
	defects4j checkout -p Math -v 1b -w commons-math
	cd commons-math && defects4j compile && defects4j test

	# Mockito
	defects4j checkout -p Mockito -v 1b -w mockito
	cd mockito && defects4j compile && defects4j test

	# Time
	defects4j checkout -p Time -v 1b -w time
	cd time && defects4j compile && defects4j test

run_closure:
	nohup nice time ./run_closure.sh > output-closure 2>&1 &
