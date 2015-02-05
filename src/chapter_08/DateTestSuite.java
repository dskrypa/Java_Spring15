package chapter_08;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Chapter 8 - Problem 14
 * @author Douglas Skrypa
 * @version 2015.02.05
 * https://github.com/dskrypa/Java_Spring15
 */
@SuppressWarnings("unused")
public class DateTestSuite {
	
	@Test(expected = NullPointerException.class)
	public void testNullMonthName() {
		Date d = new Date(null, 1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyMonthName() {
		Date d = new Date("", 1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBadMonthName() {
		Date d = new Date("Janu", 1, 1);
	}
	
	@Test
	public void testGoodMonthName() {
		Date d = new Date("January", 1, 1);
		assertEquals("January", d.getMonthName());
	}
	
	@Test
	public void testGoodMonthAbbrev() {
		Date d = new Date("Jan", 1, 1);
		assertEquals("January", d.getMonthName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLowYearDay() {
		Date d = new Date(0, 2015);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHighYearDay() {
		Date d = new Date(370, 2015);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNonLeapYear1() {
		Date d = new Date(366, 2015);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNonLeapYear2() {
		Date d = new Date("Feb", 29, 2015);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNonLeapYear3() {
		Date d = new Date("Feb", 29, 1900);
	}
	
	@Test
	public void testLeapYear1() {
		Date d = new Date(366, 2016);
		assertEquals(31, d.getDayOfMonth());
		assertEquals(12, d.getMonthNumber());
	}
	
	@Test
	public void testLeapYear2() {
		Date d = new Date("Feb", 29, 2016);
		assertNotNull(d);
	}

	@Test
	public void testFormat1() {
		Date d = new Date("Feb", 4, 2015);
		assertEquals("02/04/2015", d.format("MM/dd/YYYY"));
	}
	
	@Test
	public void testFormat2() {
		Date d = new Date("Feb", 4, 2015);
		assertEquals("2/4/2015", d.format("M/d/YYYY"));
	}
	
	@Test
	public void testFormat3() {
		Date d = new Date("Feb", 4, 2015);
		assertEquals("Feb 04, 2015", d.format("MMM dd, YYYY"));
	}
	
	@Test
	public void testFormat4() {
		Date d = new Date("Feb", 4, 2015);
		assertEquals("February 4, 2015", d.format("MMMM d, YYYY"));
	}
	
	@Test
	public void testFormat5() {
		Date d = new Date("Feb", 4, 2015);
		assertEquals("2/4/15", d.format("M/d/YY"));
	}
	
	@Test
	public void testFormat6() {
		Date d = new Date("Feb", 4, 915);
		assertEquals("2/4/15", d.format("M/d/YY"));
	}
	
	@Test
	public void testFormat7() {
		Date d = new Date("Feb", 4, 5);
		assertEquals("2/4/05", d.format("M/d/YY"));
	}
}