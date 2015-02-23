package chapter_11b.p11_20;

/**
 * Chapter 11 - Problems 20: Catching Exceptions
 * @author Douglas Skrypa
 * @version 2015.02.23
 */
public class Tester20 {
	public static void main(final String[] args) {
		System.out.println("Performing Exercise 20 Test...");
		try {
			someMethod();
		} catch (Exception e) {
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
}