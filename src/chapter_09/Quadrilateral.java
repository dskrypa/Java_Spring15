package chapter_09;

/**
 * Chapter 9 - Problem 8: Quadrilateral Inheritance Hierarchy
 * @author Douglas Skrypa
 * @version 2015.02.05
 * https://github.com/dskrypa/Java_Spring15
 */
public class Quadrilateral {
	private final Point a, b, c, d;
	
	public Quadrilateral(final Point a, final Point b, final Point c, final Point d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	public Double getLengthAB() {	return a.getDistance(b);}
	public Double getLengthBC() {	return b.getDistance(c);}
	public Double getLengthCD() {	return c.getDistance(d);}
	public Double getLengthDA() {	return d.getDistance(a);}
	
	
	
	/*
	 * ( Quadrilateral  Inheritance Hierarchy) Write an inheritance hierarchy for classes
	 * Quadrilateral, 
Trapezoid
Parallelogram
Rectangle
Square

. Use Quadrilateral as the superclass
of the hierarchy. Create and use a
Point class
to represent the points in each shape. Make the hier-
archy as deep (i.e., as many levels) as possible. Specify the instance variables and methods for each
class. The private instance variables of Quadrilateral should be the x-y coordinate pairs for the
four endpoints of the Quadrilateral. Write a program that instantiates objects of your classes and
outputs each object’s area (except Quadrilateral).
	 */
}
