.PHONY:all
all: install projects

.PHONY:install
install: build install_jaguar

.PHONY:build
build:
	@cd .. && $(MAKE) prepare build_core

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
	@rm -rf jfreechart closure commons-lang commons-math mockito jodatime 2>/dev/null || true

# Download, compile and run tests of all projects available in defects4j
.PHONY:projects
projects:
	@echo -n Downloading JFreeChart; \
	defects4j checkout -p Chart -v 1b -w jfreechart; \
	cd jfreechart && defects4j compile && defects4j test

	@echo -n Downloading Closure; \
	defects4j checkout -p Closure -v 1b -w closure; \
	cd closure && defects4j compile && defects4j test

	@echo -n Downloading Commons-Lang; \
	defects4j checkout -p Lang -v 1b -w commons-lang; \
	cd commons-lang && defects4j compile && defects4j test

	@echo -n Downloading Commons-Math; \
	defects4j checkout -p Math -v 1b -w commons-math; \
	cd commons-math && defects4j compile && defects4j test

	@echo -n Downloading Mockito; \
	defects4j checkout -p Mockito -v 1b -w mockito; \
	cd mockito && defects4j compile && defects4j test

	@echo -n Downloading JodaTime; \
	defects4j checkout -p Time -v 1b -w jodatime; \
	cd jodatime && defects4j compile && defects4j test

.PHONY:run_jaguar
run_jaguar:
	@$(MAKE) -f Makefile.jaguar all &

.PHONY:jfreechart
jfreechart:
	@$(MAKE) -f Makefile.jaguar jfreechart &

.PHONY:closure
closure:
	@$(MAKE) -f Makefile.jaguar closure &

.PHONY:commons-lang
commons-lang:
	@$(MAKE) -f Makefile.jaguar commons-lang &

.PHONY:commons-math
commons-math:
	@$(MAKE) -f Makefile.jaguar commons-math &

.PHONY:mockito
mockito:
	@$(MAKE) -f Makefile.jaguar mockito &

.PHONY:jodatime
jodatime:
	@$(MAKE) -f Makefile.jaguar jodatime &
