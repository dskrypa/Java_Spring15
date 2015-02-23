package chapter_11b.p11_18;

/**
 * Chapter 11 - Problems 18: Catching Exceptions
 * @author Douglas Skrypa
 * @version 2015.02.23
 */
public class Tester18 {
	public static void main(final String[] args) {
		testInheritance_18();
	}

	/**
	 * 11.18
	 * Tests catching an Exception with decreasing specificity
	 */
	public static void testInheritance_18() {
		boolean reachedAll3 = false;
		try {
			try {
				try {
					throw new ExceptionC();
				} catch (ExceptionC e) {
					throw e;
				}
			} catch (ExceptionB e) {
				throw e;
			}
		} catch (ExceptionA e) {
			reachedAll3 = true;
		}
		if (reachedAll3) {
			System.out.println("testInheritance_18(): [PASS]");
		} else {
			System.out.println("testInheritance_18(): [FAIL]");
		}
	}
}