package chapter_09;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Chapter 9 - Problem 8: Quadrilateral Inheritance Hierarchy
 * @author Douglas Skrypa
 * @version 2015.02.09
 * https://github.com/dskrypa/Java_Spring15
 */
@SuppressWarnings("unused")
public class ShapesTestSuite {
	@Test
	public void testAngle() {
		Point a = new Point(0,1), b = new Point(0,0), c = new Point(1,0);
		double angle = Point.getAngle(a, b, c);
		assertEquals(Math.PI/2, angle, 0);
	}
	
	@Test
	public void testParallel() {
		Point a = new Point(0,0), b = new Point(1,1), c = new Point(0,1), d = new Point(1,2);
		Point v1 = a.getVector(b), v2 = c.getVector(d);
		assertTrue(v1.isParallel(v2));
	}
	
	@Test
	public void testParallelCommutativity() {
		Point a = new Point(0,0), b = new Point(1,1), c = new Point(0,1), d = new Point(1,2);
		Point v1 = a.getVector(b), v2 = c.getVector(d);
		assertTrue(v1.isParallel(v2));
		assertTrue(v2.isParallel(v1));
	}
	
	@Test
	public void testIntersecting() {
		Point a = new Point(0,0), b = new Point(1,1), c = new Point(0,1), d = new Point(1,0);
		Point v1 = a.getVector(b), v2 = c.getVector(d);
		assertFalse(v1.isParallel(v2));
	}
	
	
	@Test
	public void testParallelInShape() {
		Point a = new Point(0,0), b = new Point(1,1), c = new Point(0,1), d = new Point(1,0);
		Quadrilateral q = new Quadrilateral(a, b, c, d);
		assertTrue(q.hasParallelSides());
	}
	
	@Test
	public void testNonParallelInShape() {
		Point a = new Point(0,0), b = new Point(0,5), c = new Point(3,4), d = new Point(1,0);
		Quadrilateral q = new Quadrilateral(a, b, c, d);
		assertFalse(q.hasParallelSides());
	}
	
	@Test
	public void testGoodTrapezoidConstruction() {
		Point a = new Point(0,0), c = new Point(0,3), b = new Point(4,3), d = new Point(0,5);
		Trapezoid t = new Trapezoid(a, b, c, d);
		assertNotNull(t);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testBadTrapezoidConstruction() {
		Point a = new Point(0,0), b = new Point(0,5), c = new Point(3,4), d = new Point(1,0);
		Trapezoid t = new Trapezoid(a, b, c, d);
	}
	
	@Test
	public void testParallelCount0() {
		Point a = new Point(0,0), b = new Point(0,5), c = new Point(3,4), d = new Point(1,0);
		Quadrilateral q = new Quadrilateral(a, b, c, d);
		assertEquals(0, q.getParallelSidePairCount());
	}
	
	@Test
	public void testParallelCount1() {
		Point a = new Point(0,0), b = new Point(0,6), c = new Point(2,5), d = new Point(2,1);
		Quadrilateral q = new Quadrilateral(a, b, c, d);
		assertEquals(1, q.getParallelSidePairCount());
	}
	
	@Test
	public void testParallelCount2() {
		Point a = new Point(0,0), b = new Point(0,6), c = new Point(2,6), d = new Point(2,0);
		Quadrilateral q = new Quadrilateral(a, b, c, d);
		assertEquals(2, q.getParallelSidePairCount());
	}
	
	@Test
	public void testGoodParallelogramConstruction() {
		Point a = new Point(0,0), b = new Point(0,6), c = new Point(2,6), d = new Point(2,0);
		Parallelogram p = new Parallelogram(a, b, c, d);
		assertNotNull(p);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testBadParallelogramConstruction0() {
		Point a = new Point(0,0), b = new Point(0,5), c = new Point(3,4), d = new Point(1,0);
		Parallelogram p = new Parallelogram(a, b, c, d);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testBadParallelogramConstruction1() {
		Point a = new Point(0,0), b = new Point(0,6), c = new Point(2,5), d = new Point(2,1);
		Parallelogram p = new Parallelogram(a, b, c, d);
	}
	
	@Test
	public void testGoodRectangleConstruction() {
		Point a = new Point(0,0), b = new Point(0,6), c = new Point(2,6), d = new Point(2,0);
		Rectangle r = new Rectangle(a, b, c, d);
		assertNotNull(r);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testBadRectangleConstruction() {
		Point a = new Point(0,0), b = new Point(0,5), c = new Point(3,4), d = new Point(1,0);
		Rectangle r = new Rectangle(a, b, c, d);
	}
	
	@Test
	public void testGoodSquareConstruction() {
		Point a = new Point(0,0), b = new Point(0,6), c = new Point(6,6), d = new Point(6,0);
		Square s = new Square(a, b, c, d);
		assertNotNull(s);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testBadSquareConstruction0() {
		Point a = new Point(0,0), b = new Point(0,5), c = new Point(3,4), d = new Point(1,0);
		Square s = new Square(a, b, c, d);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testBadSquareConstruction1() {
		Point a = new Point(0,0), b = new Point(0,6), c = new Point(2,5), d = new Point(2,1);
		Square s = new Square(a, b, c, d);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testBadSquareConstruction2() {
		Point a = new Point(0,0), b = new Point(0,6), c = new Point(2,6), d = new Point(2,0);
		Square s = new Square(a, b, c, d);
	}
	
	@Test
	public void testTrapezoidArea() {
		Point a = new Point(0,0), c = new Point(0,3), b = new Point(4,3), d = new Point(0,5);
		Trapezoid t = new Trapezoid(a, b, c, d);
		assertEquals(13.5, t.getArea(), 0.0000001);
	}
	
	@Test
	public void testParallelogramArea() {
		Point a = new Point(0,0), b = new Point(5,0), c = new Point(7,3), d = new Point(2,3);
		Parallelogram p = new Parallelogram(a, b, c, d);
		assertEquals(15, p.getArea(), 0.0000001);
	}
	
	@Test
	public void testRectangleArea() {
		Point a = new Point(0,0), b = new Point(0,6), c = new Point(2,6), d = new Point(2,0);
		Rectangle r = new Rectangle(a, b, c, d);
		assertEquals(12, r.getArea(), 0.0000001);
	}
	
	@Test
	public void testSquareArea() {
		Point a = new Point(0,0), b = new Point(0,6), c = new Point(6,6), d = new Point(6,0);
		Square s = new Square(a, b, c, d);
		assertEquals(36, s.getArea(), 0.0000001);
	}
}