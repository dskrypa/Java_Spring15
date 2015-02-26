package chapter_12;

import java.awt.Color;

/**
 * Chapter 12 - Problem 17: Interactive Drawing Application
 * @author Douglas Skrypa
 * @version 2015.02.26
 */
public abstract class MyPolygon extends MyShape {
	private boolean fill = false;
	
	/**
	 * Simple MyPolygon constructor
	 */
	public MyPolygon() {
		super();
	}

	/**
	 * MyPolygon constructor
	 * @param x1 the first x coordinate
	 * @param y1 the first y coordinate
	 * @param x2 the second x coordinate
	 * @param y2 the second y coordinate
	 * @param color the color of the shape
	 * @param fill true to fill in the shape, false for outline
	 */
	public MyPolygon(final int x1, final int y1, final int x2, final int y2, final Color color, final boolean fill) {
		super(x1, y1, x2, y2, color);
		this.fill = fill;
	}
	
	/**
	 * Change whether or not this shape should be filled in or an outline 
	 * @param fill true to fill in, false for an outline
	 */
	public void setFill(final boolean fill) {
		this.fill = fill;
	}
	
	/**
	 * Returns true if this shape should be filled in, false for an outline
	 * @return true to fill in, false for an outline
	 */
	public boolean fill() {
		return fill;
	}
}