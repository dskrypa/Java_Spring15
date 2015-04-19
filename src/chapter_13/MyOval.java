package chapter_13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Chapter 13 - Problem 31: Interactive Drawing Application
 * @author Douglas Skrypa
 * @version 2015.04.06
 */
public class MyOval extends MyPolygon {
	/**
	 * Simple MyOval constructor
	 */
	public MyOval() {
		super();
	}
	
	/**
	 * MyOval constructor
	 * @param x1 the first x coordinate
	 * @param y1 the first y coordinate
	 * @param x2 the second x coordinate
	 * @param y2 the second y coordinate
	 * @param color the color of the shape
	 * @param fill true to fill in the shape, false for outline
	 */
	public MyOval(final int x1, final int y1, final int x2, final int y2, final Paint color, final boolean fill) {
		super(x1,y1,x2,y2,color,fill);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(getColor());
		g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		if (fill()) {
			g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		}
	}
}