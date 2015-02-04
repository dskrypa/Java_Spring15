package chapter_08;

import org.junit.runner.JUnitCore;

import common.TestListener;

/**
 * Chapter 8 - Problem 14
 * @author Douglas Skrypa
 * @version 2015.02.04
 * @see common.TestListener.java for the TestListener that I use.
 */
public class DateTester {
	public static void main(final String[] args) {
		JUnitCore runner = new JUnitCore();
		runner.addListener(new TestListener());
		runner.run(DateTest.class);
	}
}
