package chapter_13;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;

/**
 * Chapter 13 - Problem 31: Interactive Drawing Application
 * @author Douglas Skrypa
 * @version 2015.04.06
 */
public abstract class MyShape {
	private Paint color;
	private int x1, x2, y1, y2;
	
	/**
	 * Simple MyShape constructor
	 */
	public MyShape() {
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		color = Color.BLACK;
	}
	
	/**
	 * MyShape constructor
	 * @param x1 the first x coordinate
	 * @param y1 the first y coordinate
	 * @param x2 the second x coordinate
	 * @param y2 the second y coordinate
	 * @param color the color of the shape
	 */
	public MyShape(final int x1, final int y1, final int x2, final int y2, final Paint color) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.setColor(color);
	}
	
	public abstract void draw(Graphics2D g);

	/**	Getter Methods	*/
	public int getX1() {return x1;}
	public int getX2() {return x2;}
	public int getY1() {return y1;}
	public int getY2() {return y2;}
	public Paint getColor() {return color;}
	
	/**	Setter Methods	*/
	public void setX1(int x1) {this.x1 = x1;}
	public void setX2(int x2) {this.x2 = x2;}
	public void setY1(int y1) {this.y1 = y1;}
	public void setY2(int y2) {this.y2 = y2;}
	public void setColor(Paint color) {this.color = color;}
	
	/**
	 * Determine the leftmost X coordinate of this shape
	 * @return the X coordinate that is less than its counterpart
	 */
	public int getUpperLeftX() {
		int x1 = getX1(), x2 = getX2();
		return x1 < x2 ? x1 : x2;
	}
	
	/**
	 * Determine the topmost Y coordinate of this shape
	 * @return the Y coordinate that is greater than its counterpart
	 */
	public int getUpperLeftY() {
		int y1 = getY1(), y2 = getY2();
		return y1 > y2 ? y1 : y2;
	}
	
	/**
	 * Calculate the width of this shape
	 * @return the absolute value of the difference in this shape's X coordinates
	 */
	public int getWidth() {
		return Math.abs(getX2() - getX1());
	}
	
	/**
	 * Calculate the height of this shape
	 * @return the absolute value of the difference in this shape's Y coordinates
	 */
	public int getHeight() {
		return Math.abs(getY2() - getY1());
	}
}