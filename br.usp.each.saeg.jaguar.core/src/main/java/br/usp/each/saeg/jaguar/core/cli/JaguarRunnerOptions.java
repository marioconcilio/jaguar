package br.usp.each.saeg.jaguar.core.cli;

import java.io.File;
import java.nio.file.Paths;

import org.kohsuke.args4j.Option;

/**
 * Class to represent the Command Line Interface (CLI) options
 * and respective descriptions.
 * 
 * @author Mario Concilio
 *
 */
public class JaguarRunnerOptions {

	private File sourcePath;
	private File testPath;
   
    @Option(name = "--help", help = true,
    		usage = "show this help message")
	private Boolean help = false;

    @Option(name = "--dataflow", aliases = {"-df"}, 
    		usage = "collect data-flow information\n"
    				+ "when this parameter is not set control-flow information is collected")
	private Boolean dataFlow = false;
    
    @Option(name = "--outputType", aliases = {"-ot"}, 
    		usage = "the output type\n F = Flat, H = Hierarchical")
	private String outputType = "F";
    
    @Option(name = "--output", aliases = {"-o"}, 
    		usage = "the output file name\n")
	private String outputFileName = "codeforest";
    
    @Option(name = "--projectDir", aliases = {"-p"}, required = true,
    		usage = "the path where the project is located")
	private File projectPath = new File("");

	@Option(name = "--testsListFile", aliases = {"-tf"},
            usage = "the file containing the list of tests\n")
	private File testListFile = new File("\\temp\\junittempfilename.txt");
	
	@Option(name = "--testSuite", aliases = {"-s"},
			usage = "the test suite to run\n" +
					"if a test suite is specified, Jaguar runs it instead of all classes in testDir")
	private String testSuite;
    
    @Option(name = "--logLevel", aliases = {"-l"}, 
    		usage = "the log level\n ERROR, INFO, DEBUG, TRACE")
    private String logLevel = "INFO";
    
    public JaguarRunnerOptions() {
    	sourcePath = Paths.get(projectPath.getAbsolutePath(), "target", "classes").toFile();
    	testPath = Paths.get(projectPath.getAbsolutePath(), "target", "test-classes").toFile();
    }
    
    @Option(name = "--heuristic", aliases = {"-h"},
    		usage = "heuristic name\n"
    				+ "must be one of the heuristic in the package br.usp.each.saeg.jaguar.core.heuristic\n"
    				+ "must be the exact name of the class without the word Heuristic")
    private String heuristic = "Tarantula";
    
    @Option(name = "--classesDir", aliases = {"-c"},
            usage = "the path where the compiled classes are located relative to project root\n")
    public void setSourcePath(String path) {
    	this.sourcePath = new File(projectPath, path);
    }
    
    @Option(name = "--testsDir", aliases = {"-t", "-td"},
            usage = "the path where the compiled tests are located relative to project root\n")
    public void setTestPath(String path) {
    	this.testPath = new File(projectPath, path);
	}
    
    public Boolean isHelp() {
		return help;
	}

    public String getHeuristic() {
		return heuristic;
	}

	public File getProjectPath() {
		return projectPath;
	}

	public File getSourcePath() {
		return sourcePath;
	}

	public File getTestPath() {
		return testPath;
	}

	public File getTestListFile() {
		return testListFile;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public String getOutputType() {
		return outputType;
	}

	public String getTestSuite() {
		return testSuite;
	}
	
	public Boolean isDataFlow() {
		return dataFlow;
	}
	
	public String getLogLevel() {
		return logLevel;
	}
	
	@Override
	public String toString() {
		return "JaguarRunnerOptions \n"
				+ "help = " + help + "\n"
				+ "heuristic = " + heuristic + "\n"
				+ "projectPath = " + projectPath.getPath() + "\n"
				+ "sourcePath = " + sourcePath.getPath() + "\n"
				+ "testPath = " + testPath.getPath() + "\n"
				+ "testSuite = " + testSuite + "\n"
				+ "output = " + outputFileName + "\n"
				+ "outputType = " + outputType + "\n"
				+ "logLevel = " + logLevel + "\n"
				+ "dataflow = " + dataFlow ;
	}
	
}
