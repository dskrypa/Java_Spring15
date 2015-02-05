package chapter_09;

/**
 * Chapter 9 - Problem 8: Quadrilateral Inheritance Hierarchy
 * @author Douglas Skrypa
 * @version 2015.02.05
 * https://github.com/dskrypa/Java_Spring15
 */
public class Point {
	private final Double x, y, z;

	/**
	 * Constructor for a Point in a 2D plane
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 */
	public Point(final double x, final double y) {
		this.x = x;
		this.y = y;
		this.z = null;
	}
	
	/**
	 * Constructor for a Point in a 3D space
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 * @param z the z-coordinate
	 */
	public Point(final double x, final double y, final double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Double getX() {	return x;}
	public Double getY() {	return y;}
	public Double getZ() {	return z;}
	
	/**
	 * Calculate the angle between two Points, given a central Point between them
	 * @param a a Point
	 * @param center a Point
	 * @param b a Point
	 * @return the angle between the given Points
	 */
	public static Double getAngle(final Point a, final Point center, final Point b) {
		double ax = a.getX(), ay = a.getY();
		double az = (a.getZ() == null) ? 0 : a.getZ();
		double bx = b.getX(), by = b.getY();
		double bz = (b.getZ() == null) ? 0 : b.getZ();
		double cx = center.getX(), cy = center.getY();
		double cz = (center.getZ() == null) ? 0 : center.getZ();
		//Convert to vectors
		double[] v1 = {ax-cx, ay-cy, az-cz};
		double[] v2 = {bx-cx, by-cy, bz-cz};
		//Calculate magnitudes
		double v1m = Math.sqrt((v1[0]*v1[0]) + (v1[1]*v1[1]) + (v1[2]*v1[2]));
		double v2m = Math.sqrt((v2[0]*v2[0]) + (v2[1]*v2[1]) + (v2[2]*v2[2]));
		//Normalize vectors
		double[] v1n = {v1[0]/v1m, v1[1]/v1m, v1[2]/v1m};
		double[] v2n = {v2[0]/v2m, v2[1]/v2m, v2[2]/v2m};
		//Take the dot product & return the arccos of it
		double dprod = (v1n[0]*v2n[0]) + (v1n[1]*v2n[1]) + (v1n[2]*v2n[2]);
		return Math.acos(dprod);
	}
	
	/**
	 * Calculates the distance between this Point and another
	 * @param other another Point
	 * @return the distance between this Point and other
	 */
	public Double getDistance(final Point other) {
		double dx = other.getX() - this.getX();
		double dy = other.getY() - this.getY();
		double dz = 0;
		if ((other.getZ() != null) && (this.getZ() != null)) {
			dz = other.getZ() - this.getZ();
		}
		return Math.sqrt((dx*dx) + (dy*dy) + (dz*dz));
	}
	
	@Override
	public String toString() {
		if (z == null) {
			return "(" + x + ", " + y + ")";
		}
		return "(" + x + ", " + y + ", " + z + ")";
	}
}