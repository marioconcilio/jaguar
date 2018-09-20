.PHONY:all
all: install projects

.PHONY:install
install: build install_jaguar

.PHONY:build
build:
	@cd .. && @$(MAKE) prepare build_core

.PHONY:install_jaguar
install_jaguar:
	@cp ../br.usp.each.saeg.jaguar.core/target/br.usp.each.saeg.jaguar.core-1.0.0-jar-with-dependencies.jar .; \
	cp ../br.usp.each.saeg.jaguar.plugin/lib/jacocoagent.jar .

.PHONY:clean
clean: clean_jaguar clean_output clean_projects

.PHONY:clean_jaguar
clean_jaguar:
	@rm br.usp.each.saeg.jaguar.core-1.0.0-jar-with-dependencies.jar jacocoagent.jar 2>/dev/null || true

.PHONY:clean_output
clean_output:
	@rm output-* 2>/dev/null || true

.PHONY:clean_projects
clean_projects:
	@rm -rf jfreechart 2>/dev/null || true
	@rm -rf closure 2>/dev/null || true
	@rm -rf commons-lang 2>/dev/null || true
	@rm -rf commons-math 2>/dev/null || true
	@rm -rf mockito 2>/dev/null || true
	@rm -rf time 2>/dev/null || true

# Download, compile and run tests of all projects available in defects4j
.PHONY:projects
projects:
	@echo JFreeChart
	defects4j checkout -p Chart -v 1b -w jfreechart
	cd jfreechart && defects4j compile && defects4j test

	@echo Closure
	defects4j checkout -p Closure -v 1b -w closure
	cd closure && defects4j compile && defects4j test

	@echo Commons-Lang
	defects4j checkout -p Lang -v 1b -w commons-lang
	cd commons-lang && defects4j compile && defects4j test

	@echo Commons-Math
	defects4j checkout -p Math -v 1b -w commons-math
	cd commons-math && defects4j compile && defects4j test

	@echo Mockito
	defects4j checkout -p Mockito -v 1b -w mockito
	cd mockito && defects4j compile && defects4j test

	@echo Time
	defects4j checkout -p Time -v 1b -w time
	cd time && defects4j compile && defects4j test

.PHONY:run_jaguar
run_jaguar:
	@$(MAKE) -f Makefile.jaguar all &

.PHONY:jfreechart
jfreechart:
	@$(MAKE) -f Makefile.jaguar jfreechart &

.PHONY:closure
closure:
	@$(MAKE) -f Makefile.jaguar closure &

.PHONY:commons-math
commons-math:
	@$(MAKE) -f Makefile.jaguar commons-math &

.PHONY:mockito
mockito:
	@$(MAKE) -f Makefile.jaguar mockito &

.PHONY:time
time:
	@$(MAKE) -f Makefile.jaguar time &
