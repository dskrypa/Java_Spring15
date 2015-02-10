package chapter_09;

/**
 * Chapter 9 - Problem 8: Quadrilateral Inheritance Hierarchy
 * @author Douglas Skrypa
 * @version 2015.02.05
 * https://github.com/dskrypa/Java_Spring15
 */
public class Quadrilateral {
	protected final Point a, b, c, d;
	
	public Quadrilateral(final Point a, final Point b, final Point c, final Point d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	public double getLengthAB() {	return a.getDistance(b);}
	public double getLengthBC() {	return b.getDistance(c);}
	public double getLengthCD() {	return c.getDistance(d);}
	public double getLengthDA() {	return d.getDistance(a);}
	public double getAngleABC() {	return Point.getAngle(a, b, c);}
	public double getAngleBCD() {	return Point.getAngle(b, c, d);}
	public double getAngleCDA() {	return Point.getAngle(c, d, a);}
	public double getAngleDAB() {	return Point.getAngle(d, a, b);}
	
	/**
	 * Determines whether or not this Quadrilateral contains at one pair of parallel sides
	 * @return true if one or more pairs of parallel sides exist
	 */
	public boolean hasParallelSides() {
		return getParallelSidePairCount() > 0;
	}
	
	/**
	 * Determines the number of pairs of parallel sides in this Quadrilateral
	 * @return the number of pairs of parallel sides in this Quadrilateral
	 */
	public int getParallelSidePairCount() {
		Point v1 = a.getVector(b), v2 = b.getVector(c), v3 = c.getVector(d), v4 = d.getVector(a);
		boolean pw1 = v1.isParallel(v2) || v1.isParallel(v3) || v1.isParallel(v4);
		boolean pw2 = v2.isParallel(v3) || v2.isParallel(v4);
		boolean pw3 = v3.isParallel(v4);
		
		int count = 0;
		count += pw1 ? 1 : 0;
		count += pw2 ? 1 : 0;
		count += pw3 ? 1 : 0;
		return count;
	}
	
	
	/*
Write a program that instantiates objects of your classes and
outputs each object’s area (except Quadrilateral).
	 */
}
