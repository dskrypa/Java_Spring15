package chapter_09;

/**
 * Chapter 9 - Problem 8: Quadrilateral Inheritance Hierarchy
 * @author Douglas Skrypa
 * @version 2015.02.09
 * https://github.com/dskrypa/Java_Spring15
 */
public class Rectangle extends Parallelogram {
	/*
	 * A rectangle is a quadrilateral with four right angles
	 */
	
	public Rectangle(final Point a, final Point b, final Point c, final Point d) {
		super(a, b, c, d);
		if ((getAngleABC() != Math.PI/2) || (getAngleBCD() != Math.PI/2) || (getAngleCDA() != Math.PI/2) || (getAngleDAB() != Math.PI/2)) {
			throw new IllegalArgumentException("Rectangles require all angles to be 90 degrees.");
		}
	}
}