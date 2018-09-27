package br.usp.each.saeg.jaguar.core.runner;

import org.jacoco.core.data.AbstractExecutionDataStore;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.usp.each.saeg.jaguar.core.JaCoCoClient;
import br.usp.each.saeg.jaguar.core.Jaguar;

import java.io.IOException;

public class JaguarRunListener extends RunListener {

	private static Logger logger = LoggerFactory.getLogger("JaguarLogger");
	private final Jaguar jaguar;

	private final JaCoCoClient client;

	private boolean currentTestFailed;

	public JaguarRunListener(Jaguar jaguar, JaCoCoClient client) {
		this.jaguar = jaguar;
		this.client = client;
	}

	@Override
	public void testStarted(Description description) {
		currentTestFailed = false;
		jaguar.increaseNTests();
	}

	@Override
	public void testFailure(Failure failure) {
		currentTestFailed = true;
		jaguar.increaseNTestsFailed();
	}

	@Override
	public void testFinished(Description description) {
		printTestResult(description);

 		try {
 			long startTime = System.currentTimeMillis();
 			AbstractExecutionDataStore dataStore = client.read();
 			logger.debug("Time to receive data: {}", System.currentTimeMillis() - startTime);
 			
 			startTime = System.currentTimeMillis();
			jaguar.collect(dataStore, currentTestFailed);
			logger.debug("Time to collect data: {}", System.currentTimeMillis() - startTime);
		}
		catch (IOException e) {
			logger.error("Exception during collecting coverage information :" + e.toString());
			logger.error("Exception Message : " + e.getMessage());
			logger.error("Stacktrace: ");
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	private void printTestResult(Description description) {
		if (currentTestFailed){
			logger.info("Test {} : Failed", description.getDisplayName());
		}else{
			logger.debug("Test {} : Passed", description.getDisplayName());
		}
	}

}
