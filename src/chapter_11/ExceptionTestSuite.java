package chapter_11;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Chapter 11 - Problems 16 - 21: Catching Exceptions
 * @author Douglas Skrypa
 * @version 2015.02.16
 */
@SuppressWarnings("unused")
public class ExceptionTestSuite {
	/**
	 * 11.16 [1 of 2]
	 * Tests the capture of an ExceptionB as an ExceptionA
	 */
	@Test
	public void testInheritanceB() {
		try {
			throw new ExceptionB();
		} catch (ExceptionA e) {}
	}
	
	/**
	 * 11.16 [2 of 2]
	 * Tests the capture of an ExceptionC as an ExceptionA
	 */
	@Test
	public void testInheritanceC() {
		try {
			throw new ExceptionC();
		} catch (ExceptionA e) {}
	}

	/**
	 * 11.17 [1 of 4]
	 * Tests the capture of an ExceptionA as a generic Exception 
	 */
	@Test
	public void testInheritance_17_1() {
		try {
			throw new ExceptionA();
		} catch (Exception e) {}
	}
	
	/**
	 * 11.17 [2 of 4]
	 * Tests the capture of an ExceptionB as a generic Exception 
	 */
	@Test
	public void testInheritance_17_2() {
		try {
			throw new ExceptionB();
		} catch (Exception e) {}
	}
	
	/**
	 * 11.17 [3 of 4]
	 * Tests the capture of an NullPointerException as a generic Exception 
	 */
	@Test
	public void testInheritance_17_3() {
		try {
			throw new NullPointerException();
		} catch (Exception e) {}
	}
	
	/**
	 * 11.17 [4 of 4]
	 * Tests the capture of an IOException as a generic Exception 
	 */
	@Test
	public void testInheritance_17_4() {
		try {
			throw new java.io.IOException();
		} catch (Exception e) {}
	}
	
	/**
	 * 11.18
	 * Tests catching an Exception with decreasing specificity
	 */
	@Test
	public void testInheritance_18() {
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
		assertTrue(reachedAll3);
	}
	
	/**
	 * 11.19
	 * Test the capture of an Exception thrown by an object's constructor
	 */
	@Test
	public void testConstructor() {
		try {
			SomeClass sc = new SomeClass();
		} catch (Exception e) {}
	}
}