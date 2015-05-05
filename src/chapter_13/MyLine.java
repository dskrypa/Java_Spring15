package chapter_13;

//import java.awt.Color;
//import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

/**
 * Chapter 13 - Problem 31: Interactive Drawing Application
 * @author Douglas Skrypa
 * @version 2015.04.06
 */
public class MyLine extends MyShape {
	/**
	 * Simple MyLine constructor
	 */
	public MyLine() {
		super();
	}
	
	/**
	 * MyLine constructor
	 * @param x1 the first x coordinate
	 * @param y1 the first y coordinate
	 * @param x2 the second x coordinate
	 * @param y2 the second y coordinate
	 * @param color the color of the line
	 */
	public MyLine(final int x1, final int y1, final int x2, final int y2, final Paint color) {
		super(x1,y1,x2,y2,color);
	}

	@Override
	public void draw(Graphics2D g) {
		//g.setColor(getColor());
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}
}