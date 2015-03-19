package chapter_12;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.prism.paint.Color;

/**
 * Chapter 12 - Problem 17: Interactive Drawing Application
 * @author Douglas Skrypa
 * @version 2015.03.19
 */
public class DrawPanel extends JPanel {
	
	private class MouseHandler extends MouseAdapter implements MouseMotionListener {
		@Override
		public void mousePressed(final MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			initNewShape(x, y);
			repaint();
		}
		
		@Override
		public void mouseReleased(final MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			getCurrentShape().setX2(x);
			getCurrentShape().setY2(y);
			getShapes().add(getCurrentShape());
			currentShape = null;
			repaint();
		}
		
		@Override
		public void mouseMoved(final MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			getLabel().setText("(" + x + ", " + y + ")");
		}
		
		@Override
		public void mouseDragged(final MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			getLabel().setText("(" + x + ", " + y + ")");
			getCurrentShape().setX2(x);
			getCurrentShape().setY2(y);
			repaint();
		}
	}
	
	private enum ShapeType {
		LINE(MyLine.class), OVAL(MyOval.class), RECTANGLE(MyRectangle.class);
		private Class<?> c;
		private ShapeType(final Class<?> c) {	this.c = c;}
		public Class<?> getShapeClass() {		return c;}
	}
	private static final long serialVersionUID = 773549807044593116L;

	private JLabel statusLabel;
	private List<MyShape> shapes;
	private Color currentColor, backgroundColor;
	private ShapeType currentShapeType;
	private MyShape currentShape = null;
	private boolean filledShape = false;
	private MouseHandler mh;
	
	public DrawPanel(final JLabel label) {
		statusLabel = label;
		shapes = new ArrayList<>();
		currentColor = Color.BLACK;
		backgroundColor = Color.WHITE;
		currentShapeType = ShapeType.LINE;
		
		mh = new MouseHandler();
		this.addMouseListener(mh);
		this.addMouseMotionListener(mh);
	}
	
	@SuppressWarnings("unchecked")
	public void initNewShape(final int x, final int y) {
		Class<?> sc = getShapeType().getShapeClass();
		MyShape s = null;
		Constructor<MyShape> con = null;
		if (sc.getGenericSuperclass() == MyPolygon.class) {
			try {
				con = (Constructor<MyShape>) sc.getConstructor(int.class,int.class,int.class,int.class,Color.class,boolean.class);
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			try {
				s = con.newInstance(x,y,x,y,getDrawColor(),doFill());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			try {
				con = (Constructor<MyShape>) sc.getConstructor(int.class,int.class,int.class,int.class,Color.class);
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			try {
				s = con.newInstance(x,y,x,y,getDrawColor());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		currentShape = s;
	}
	
	public List<MyShape> getShapes() {	return shapes;}
	public int getShapeCount() {		return getShapes().size();}
	public Color getDrawColor() {		return currentColor;}
	public Color getBackgroundColor() {	return backgroundColor;}
	public ShapeType getShapeType() {	return currentShapeType;}
	public MyShape getCurrentShape() {	return currentShape;}
	public boolean doFill() {		return filledShape;}
	public JLabel getLabel() {		return statusLabel;}
	
	public void setShapeType(final ShapeType type) {	currentShapeType = type;}
	public void setCurrentColor(final Color color) {	currentColor = color;}
	public void setFilledShape(final boolean fill) {	filledShape = fill;}
	
	@Override
	public void paintComponent(final Graphics g) {
		if (currentShape != null) {
			currentShape.draw(g);
		}
		for (MyShape s : shapes) {
			s.draw(g);
		}
	}
	
	/**
	 * Remove the last shape drawn
	 */
	public void clearLastShape() {
		shapes.remove(shapes.size()-1);
		repaint();
	}
	
	/**
	 * Remove all shapes in the current drawing
	 */
	public void clearDrawing() {
		shapes.clear();
		repaint();
	}
}