package chapter_11b.p11_21;

/**
 * Chapter 11 - Problems 21: Catching Exceptions
 * @author Douglas Skrypa
 * @version 2015.02.23
 */
public class Tester21 {
	public static void main(final String[] args) {
		System.out.println("Performing Exercise 21 Test...");
		try {
			exceptionFallThrough();
		} catch (Exception e) {
			System.out.println("Caught an Exception after it was not caught by the method it was caused in:");
			e.printStackTrace(System.out);
		}
	}
	
	public static void exceptionFallThrough() throws Exception {
		try {
			throw new ArithmeticException();
		} catch (IllegalArgumentException e) {
			System.out.println("This should never be printed.");
		}
	}
}