package chapter_11b.p11_17;

/**
 * Chapter 11 - Problems 17: Catching Exceptions
 * @author Douglas Skrypa
 * @version 2015.02.23
 */
public class Tester17 {
	public static void main(final String[] args) {
		testInheritance_17_1();
		testInheritance_17_2();
		testInheritance_17_3();
		testInheritance_17_4();
	}
	
	/**
	 * 11.17 [1 of 4]
	 * Tests the capture of an ExceptionA as a generic Exception 
	 */
	public static void testInheritance_17_1() {
		try {
			throw new ExceptionA();
		} catch (Exception e) {
			System.out.println("testInheritance_17_1(): [PASS]");
		}
	}
	
	/**
	 * 11.17 [2 of 4]
	 * Tests the capture of an ExceptionB as a generic Exception 
	 */
	public static void testInheritance_17_2() {
		try {
			throw new ExceptionB();
		} catch (Exception e) {
			System.out.println("testInheritance_17_2(): [PASS]");
		}
	}
	
	/**
	 * 11.17 [3 of 4]
	 * Tests the capture of an NullPointerException as a generic Exception 
	 */
	public static void testInheritance_17_3() {
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			System.out.println("testInheritance_17_3(): [PASS]");
		}
	}
	
	/**
	 * 11.17 [4 of 4]
	 * Tests the capture of an IOException as a generic Exception 
	 */
	public static void testInheritance_17_4() {
		try {
			throw new java.io.IOException();
		} catch (Exception e) {
			System.out.println("testInheritance_17_4(): [PASS]");
		}
	}
}