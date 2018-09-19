all: install projects

install: build install_jaguar
	
build:
	cd .. && $(MAKE) prepare build_core

install_jaguar:
	@cp ../br.usp.each.saeg.jaguar.core/target/br.usp.each.saeg.jaguar.core-1.0.0-jar-with-dependencies.jar .
	@cp ../br.usp.each.saeg.jaguar.plugin/lib/jacocoagent.jar .

clean: clean_jar clean_output clean_projects

clean_jaguar:
	@rm br.usp.each.saeg.jaguar.core-1.0.0-jar-with-dependencies.jar jacocoagent.jar 2>/dev/null || true

clean_output:
	@rm output-* 2>/dev/null || true

clean_projects:
	@rm -rf jfreechart 2>/dev/null || true
	@rm -rf closure 2>/dev/null || true
	@rm -rf commons-lang 2>/dev/null || true
	@rm -rf commons-math 2>/dev/null || true
	@rm -rf mockito 2>/dev/null || true
	@rm -rf time 2>/dev/null || true

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
	$(MAKE) -f Makefile.jaguar run_closure
