package chapter_11;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/**
 * Test Listener for JUnit tests
 * @author Douglas Skrypa
 * @version 2015.02.05
 * https://github.com/dskrypa/Java_Spring15
 *
 */
public class TestListener extends RunListener
{	
	private boolean passed = true;
	private int currentTest = 0, numTests = 0, digits = 0;
	
	@Override
	public void testAssumptionFailure(Failure failure) {
		System.out.println("\t[FAIL]");
		System.out.println("\n\tAssumption FAIL:\t" + failure.getMessage());
		System.out.println("\t" + failure.getTrace());
		passed = false;
	}

	@Override
	public void testFailure(Failure failure) throws Exception {
		System.out.println("\t[FAIL]");
		System.out.println("\n\tFAIL:\t" + failure.getMessage());
		System.out.println("\t" + failure.getTrace());
		passed= false;
	}

	@Override
	public void testFinished(Description description) throws Exception {
		if (passed) {
			System.out.println("\t[PASS]\n");
		}
	}

	@Override
	public void testIgnored(Description description) throws Exception {
		String tnum = String.format("[%0" + digits + "d]", currentTest++);
		System.out.println(tnum + " Testing " + description.getClassName() + "." + description.getMethodName() + "()...\t[Ignored]\n");
	}

	@Override
	public void testRunFinished(Result result) throws Exception {
		System.out.println("\nTests completed.  Time: " + (double)result.getRunTime()/1000 + "s");
		System.out.println("Tests run: " + result.getRunCount() + "\tPassed: " + (result.getRunCount() - result.getFailureCount() - result.getIgnoreCount()) + "\tIgnored: " + result.getIgnoreCount() + "\tFailed: " + result.getFailureCount());
	}

	@Override
	public void testRunStarted(Description description) throws Exception {
		numTests = description.testCount();
		currentTest = 1;
		System.out.println("Testing " + numTests + " case(s)...\n");
		digits = Integer.toString(numTests).length();
	}

	@Override
	public void testStarted(Description description) throws Exception {
		String tnum = String.format("[%0" + digits + "d]", currentTest++);
		System.out.print(tnum + " Testing " + description.getClassName() + "." + description.getMethodName() + "()...");
		passed = true;
	}
}
