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
}