package chapter_12;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Chapter 12 - Problem 17: Interactive Drawing Application
 * @author Douglas Skrypa
 * @version 2015.02.26
 */
public class MyRectangle extends MyPolygon {
	/**
	 * Simple MyRectagle constructor
	 */
	public MyRectangle() {
		super();
	}
	
	/**
	 * MyRectangle constructor
	 * @param x1 the first x coordinate
	 * @param y1 the first y coordinate
	 * @param x2 the second x coordinate
	 * @param y2 the second y coordinate
	 * @param color the color of the shape
	 * @param fill true to fill in the shape, false for outline
	 */
	public MyRectangle(final int x1, final int y1, final int x2, final int y2, final Color color, final boolean fill) {
		super(x1,y1,x2,y2,color,fill);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		if (fill()) {
			g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		}
	}
}