package chapter_11b.p11_16;

/**
 * Chapter 11 - Problems 16: Catching Exceptions
 * @author Douglas Skrypa
 * @version 2015.02.23
 */
public class Tester16 {
	public static void main(final String[] args) {
		testInheritanceB();
		testInheritanceC();
	}
	
	/**
	 * 11.16 [1 of 2]
	 * Tests the capture of an ExceptionB as an ExceptionA
	 */
	public static void testInheritanceB() {
		try {
			throw new ExceptionB();
		} catch (ExceptionA e) {
			System.out.println("testInheritanceB(): [PASS]");
		}
	}
	
	/**
	 * 11.16 [2 of 2]
	 * Tests the capture of an ExceptionC as an ExceptionA
	 */
	public static void testInheritanceC() {
		try {
			throw new ExceptionC();
		} catch (ExceptionA e) {
			System.out.println("testInheritanceC(): [PASS]");
		}
	}
}