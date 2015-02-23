package chapter_11b.p11_19;

/**
 * Chapter 11 - Problems 19: Catching Exceptions
 * @author Douglas Skrypa
 * @version 2015.02.23
 */
public class Tester19 {
	public static void main(final String[] args) {
		testConstructor();
	}
	
	/**
	 * 11.19
	 * Test the capture of an Exception thrown by an object's constructor
	 */
	@SuppressWarnings("unused")
	public static void testConstructor() {
		try {
			SomeClass sc = new SomeClass();
		} catch (Exception e) {
			System.out.println("testConstructor(): [PASS]");
		}
	}
}