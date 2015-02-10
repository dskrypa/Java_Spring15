package chapter_09;

/**
 * Chapter 9 - Problem 8: Quadrilateral Inheritance Hierarchy
 * @author Douglas Skrypa
 * @version 2015.02.09
 * https://github.com/dskrypa/Java_Spring15
 */
public class Trapezoid extends Quadrilateral {
	/*
	 * A trapezoid is a convex quadrilateal with at least one pair of parallel sides.
	 */
	
	public Trapezoid(final Point a, final Point b, final Point c, final Point d) {
		super(a, b, c, d);
		if (!hasParallelSides()) {
			throw new IllegalArgumentException("Trapezoids require at least one pair of parallel sides.");
		}
	}
	
	/**
	 * Calculates this Trapezoid's area.
	 * @return the area of this shape
	 */
	public double getArea() {
		Point v1 = a.getVector(b), v3 = c.getVector(d);
		double l1 = getLengthAB(), l2 = getLengthBC(), l3 = getLengthCD(), l4 = getLengthDA();
		double a, b, c, d;
		if (v1.isParallel(v3)) {
			a = l1; b = l3; c = l4; d = l2;
		} else {
			a = l2; b = l4; c = l3; d = l1;
		}
		double h = Math.sqrt((b+c+d-a) * (a-b+c+d) * (a-b+c-d) * (a-b-c+d)) / (2 * Math.abs(b-a)); 
		return (a + b) * h * 0.5;
	}
}