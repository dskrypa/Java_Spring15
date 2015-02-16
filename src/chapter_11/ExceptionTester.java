package chapter_11;

import org.junit.runner.JUnitCore;

/**
 * Chapter 11 - Problems 16 - 21: Catching Exceptions
 * @author Douglas Skrypa
 * @version 2015.02.16
 */
public class ExceptionTester {
	public static void main(final String[] args) {
		JUnitCore runner = new JUnitCore();
		runner.addListener(new TestListener());
		runner.run(ExceptionTestSuite.class);
		
		System.out.println("\n\nPerforming Exercise 20 Test...");
		try {
			someMethod();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		System.out.println("\n\nPerforming Exercise 21 Test...");
		try {
			exceptionFallThrough();
		} catch (ExceptionA e) {
			System.out.println("Caught an ExceptionA after it was not caught by the method it was caused in:");
			e.printStackTrace(System.out);
		}
	}
	
	public static void someMethod() {
		try {
			someMethod2();
		} catch (Exception e) {
			System.out.println("someMethod(): caught an Exception thrown by someMethod2()");
			throw e;
		}
	}
	
	public static void someMethod2() {
		throw new IllegalArgumentException();
	}
	
	public static void exceptionFallThrough() throws ExceptionA {
		try {
			throw new ExceptionB();
		} catch (ExceptionC e) {
			System.out.println("This should never be printed.");
		}
	}
}