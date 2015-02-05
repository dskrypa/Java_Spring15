package chapter_08;

import org.junit.runner.JUnitCore;

/**
 * Chapter 8 - Problem 14
 * @author Douglas Skrypa
 * @version 2015.02.04
 * https://github.com/dskrypa/Java_Spring15
 */
public class DateTester {
	public static void main(final String[] args) {
		JUnitCore runner = new JUnitCore();
		runner.addListener(new TestListener());
		runner.run(DateTestSuite.class);
	}
}
