package chapter_12;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Chapter 12 - Problem 17: Interactive Drawing Application
 * @author Douglas Skrypa
 * @version 2015.02.23
 */
public abstract class MyShape {
	private Color color;
	private int x1, x2, y1, y2;

	/*
	 *  getUpperLeftX, getUpperLeftY, getWidth and getHeight that calculate the upper-
left x-coordinate, upper-left y-coordinate, width and height, respectively. The upper-left x-coordinate
is the smaller of the two x-coordinate values, the upper-left y-coordinate is the smaller of the two y-
coordinate values, the width is the absolute value of the difference between the two x-coordinate val-
ues, and the height is the absolute value of the difference between the two y-coordinate values.
Class DrawPanel, which extends JPanel and handles the creation of the shapes, should declare
three  arrays,  one  for  each  shape  type.


You can draw lines, rectangles and ovals if you know two points in space. Lines require x1, y1,
x2 and y2 coordinates. The drawLine method of the Graphics class will connect the two points
supplied with a line. If you have the same four coordinate values (x1, y1, x2 and y2) for ovals and
rectangles, you can calculate the four arguments needed to draw them. Each requires an upper-left
x-coordinate value (the smaller of the two x-coordinate values), an upper-left y-coordinate value
(the smaller of the two y-coordinate values), a width (the absolute value of the difference between
the two x-coordinate values) and a height (the absolute value of the difference between the two y-
coordinate values). Rectangles and ovals should also have a filled flag that determines whether to
draw the shape as a filled shape.
There should be no MyLine, MyOval or MyRectangle variables in the program—only MyShape
variables that contain references to MyLine, MyOval and MyRectangle objects. The program should
generate  random  shapes  and  store  them  in  an  array  of  type  MyShape.  Method  paintComponent
should walk through the MyShape array and draw every shape, by polymorphically calling every
shape’s draw method. 
Allow the user to specify (via an input dialog) the number of shapes to generate. The program
will then generate and display the shapes along with a status bar that informs the user how many of
each shape were created.
	 */
	
	public MyShape() {
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		color = Color.BLACK;
	}
	
	public MyShape(final int x1, final int y1, final int x2, final int y2, final Color color) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.setColor(color);
	}
	
	public abstract void draw(Graphics g);

	
	public int getX1() {return x1;}
	public int getX2() {return x2;}
	public int getY1() {return y1;}
	public int getY2() {return y2;}
	public Color getColor() {return color;}
	
	public void setX1(int x1) {this.x1 = x1;}
	public void setX2(int x2) {this.x2 = x2;}
	public void setY1(int y1) {this.y1 = y1;}
	public void setY2(int y2) {this.y2 = y2;}
	public void setColor(Color color) {this.color = color;}
}