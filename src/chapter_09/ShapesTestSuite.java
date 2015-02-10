package chapter_09;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Chapter 9 - Problem 8: Quadrilateral Inheritance Hierarchy
 * @author Douglas Skrypa
 * @version 2015.02.05
 * https://github.com/dskrypa/Java_Spring15
 */
@SuppressWarnings("unused")
public class ShapesTestSuite {

	@Test
	public void testNothing() {
		//Shut up about not having anything that's unused to suppress warnings about
		Point p = new Point(0,0);
	}
	
	@Test
	public void testAngle() {
		Point a = new Point(0,1);
		Point b = new Point(0,0);
		Point c = new Point(1,0);
		double angle = Point.getAngle(a, b, c);
		assertEquals(Math.PI/2, angle, 0);
	}
	
	@Test
	public void testParallel() {
		Point a = new Point(0,0);
		Point b = new Point(1,1);
		Point c = new Point(0,1);
		Point d = new Point(1,2);
		
		Point v1 = a.getVector(b);
		Point v2 = c.getVector(d);
		
		
		assertTrue(v1.isParallel(v2));
	}
	
	@Test
	public void testIntersecting() {
		Point a = new Point(0,0);
		Point b = new Point(1,1);
		Point c = new Point(0,1);
		Point d = new Point(1,0);
		
		Point v1 = a.getVector(b);
		Point v2 = c.getVector(d);
		assertFalse(v1.isParallel(v2));
	}
}