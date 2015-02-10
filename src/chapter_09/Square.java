package chapter_09;

/**
 * Chapter 9 - Problem 8: Quadrilateral Inheritance Hierarchy
 * @author Douglas Skrypa
 * @version 2015.02.09
 * https://github.com/dskrypa/Java_Spring15
 */
public class Square extends Rectangle {
	/*
	 * A square is a rectangle with four sides of equal length.
	 */
	
	public Square(final Point a, final Point b, final Point c, final Point d) {
		super(a, b, c, d);
		double l1 = getLengthAB(), l2 = getLengthBC(), l3 = getLengthCD(), l4 = getLengthDA();
		if ((l1 != l2) || (l2 != l3) || (l3 != l4) || (l4 != l1)) {
			throw new IllegalArgumentException("Squares require all sides to be the same length.");
		}
	}
}