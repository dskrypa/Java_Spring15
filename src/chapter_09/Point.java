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