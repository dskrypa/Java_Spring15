package chapter_09;

import org.junit.runner.JUnitCore;

/**
 * Chapter 9 - Problem 8: Quadrilateral Inheritance Hierarchy
 * @author Douglas Skrypa
 * @version 2015.02.10
 * https://github.com/dskrypa/Java_Spring15
 */
public class ShapesTester {
	public static void main(final String[] args) {
		JUnitCore runner = new JUnitCore();
		runner.addListener(new TestListener());
		runner.run(ShapesTestSuite.class);
		
		System.out.println("\n\n");
		
		Point a1 = new Point(0,0), b1 = new Point(0,3), c1 = new Point(4,3), d1 = new Point(5,0);
		Trapezoid t = new Trapezoid(a1, b1, c1, d1);
		System.out.println(t.toString() + "'s area: " + round(t.getArea()));
		
		Point a2 = new Point(0,0), b2 = new Point(5,0), c2 = new Point(7,3), d2 = new Point(2,3);
		Parallelogram p = new Parallelogram(a2, b2, c2, d2);
		System.out.println(p.toString() + "'s area: " + round(p.getArea()));
		
		Point a3 = new Point(0,0), b3 = new Point(0,6), c3 = new Point(2,6), d3 = new Point(2,0);
		Rectangle r = new Rectangle(a3, b3, c3, d3);
		System.out.println(r.toString() + "'s area: " + round(r.getArea()));
		
		Point a4 = new Point(0,0), b4 = new Point(0,6), c4 = new Point(6,6), d4 = new Point(6,0);
		Square s = new Square(a4, b4, c4, d4);
		System.out.println(s.toString() + "'s area: " + round(s.getArea()));
	}
	
	private static float round(final double val) {
		int place = 10000;
		float r = Math.round(val * place);
		return r/place;
	}
}