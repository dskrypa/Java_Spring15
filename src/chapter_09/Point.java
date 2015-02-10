package chapter_09;

/**
 * Chapter 9 - Problem 8: Quadrilateral Inheritance Hierarchy
 * @author Douglas Skrypa
 * @version 2015.02.10
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
	
	public double getX() {	return x;}
	public double getY() {	return y;}
	public double getZ() {	
		return z == null? 0 : z;
	}
	
	/**
	 * Calculate the angle between two Points, given a central Point between them
	 * @param a a Point
	 * @param center a Point
	 * @param b a Point
	 * @return the angle between the given Points
	 */
	public static Double getAngle(final Point a, final Point center, final Point b) {
		Point v1 = a.getVector(center);
		Point v2 = b.getVector(center);
		double dprod = v1.getDotProduct(v2);
		return Math.acos(dprod);
	}
	
	/**
	 * Computes the normalized vector between this point and the given point
	 * @param other another Point
	 * @return a normalized vector as a Point
	 */
	public Point getVector(final Point other) {
		double ax = getX(), ay = getY(), az = getZ();
		double bx = other.getX(), by = other.getY(), bz = other.getZ();
		double[] v = {ax-bx, ay-by, az-bz};
		double m = Math.sqrt(v[0]*v[0] + v[1]*v[1] + v[2]*v[2]);
		return new Point(v[0]/m, v[1]/m, v[2]/m);
	}
	
	/**
	 * Computes the angle between this Point (as a vector) and the given Point (as a vector)
	 * @param other the other vector
	 * @return the angle between the points in radians
	 */
	public double getAngle(final Point other) {
		double dprod = getDotProduct(other);
		return Math.acos(dprod);
	}
	
	/**
	 * Determines whether the given vector (Point) and this vector (Point) are parallel
	 * @param other another vector (Point)
	 * @return true if the two vectors are parallel, false otherwise
	 */
	public boolean isParallel(final Point other) {
		double angle = getAngle(other);
		return closeEnough(angle, Math.PI) || closeEnough(angle, 0);
	}
	
	/**
	 * Determines whether the given vector (Point) and this vector (Point) are orthogonal (perpendicular)
	 * @param other another vector (Point)
	 * @return true if the two vectors are orthogonal (perpendicular), false otherwise
	 */
	public boolean isOrthogonal(final Point other) {
		double angle = getAngle(other);
		return closeEnough(angle, Math.PI/2);
	}
	
	/**
	 * Compare the given values.
	 * @param a a double
	 * @param b a double
	 * @return true if they are close enough to be equal, false otherwise
	 */
	private static boolean closeEnough(final double a, final double b) {
		final double absA = Math.abs(a);
		final double absB = Math.abs(b);
		final double diff = Math.abs(a - b);
		double epsilon = 0.0000001;	
		if (absA == absB) {
			return true;
		} else if (absA == 0 || absB == 0 || diff < Double.MIN_NORMAL) {
			return diff < (epsilon);
		} else {
			return diff / (absA + absB) < epsilon;
		}
	}
	
	/**
	 * Calculates the distance between this Point and another
	 * @param other another Point
	 * @return the distance between this Point and other
	 */
	public double getDistance(final Point other) {
		double dx = other.getX() - this.getX();
		double dy = other.getY() - this.getY();
		double dz = other.getZ() - this.getZ();
		return Math.sqrt((dx*dx) + (dy*dy) + (dz*dz));
	}
	
	/**
	 * Calculates the dot (inner) product of this vector and the given vector
	 * @param other another vector
	 * @return the dot (inner) product
	 */
	public double getDotProduct(final Point other) {
		double x1 = this.getX(), y1 = this.getY(), z1 = this.getZ();
		double x2 = other.getX(), y2 = other.getY(), z2 = other.getZ();
		return x1*x2 + y1*y2 + z1*z2;
	}
	
	/**
	 * Calculates the cross (outer) product of this vector and the given vector
	 * @param other another vector
	 * @return the cross (outer) product
	 */
	public Point getCrossProduct(final Point other) {
		double x1 = this.getX(), y1 = this.getY(), z1 = this.getZ();
		double x2 = other.getX(), y2 = other.getY(), z2 = other.getZ();
		return new Point(y1*z2-y2*z1, x1*z2-x2*z1, x1*y2-x2*y1);
	}
	
	@Override
	public String toString() {
		if (z == null) {
			return "(" + x + ", " + y + ")";
		}
		return "(" + x + ", " + y + ", " + z + ")";
	}
}