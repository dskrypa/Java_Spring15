package chapter_09;

/**
 * Chapter 9 - Problem 8: Quadrilateral Inheritance Hierarchy
 * @author Douglas Skrypa
 * @version 2015.02.09
 * https://github.com/dskrypa/Java_Spring15
 */
public class Parallelogram extends Trapezoid {
	/*
	 * A parallelogram is a (non self-intersecting) quadrilateral with two pairs of parallel sides. 
	 */
	
	public Parallelogram(final Point a, final Point b, final Point c, final Point d) {
		super(a, b, c, d);
		if (getParallelSidePairCount() < 2) {
			throw new IllegalArgumentException("Parallelograms require at least 2 pairs of parallel sides.");
		}
	}
}