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

/*
Methods clearLastShape and clearDrawing should call repaint (inherited from JPanel) to refresh
the drawing on the DrawPanel by indicating that the system should call method paintComponent.

Class DrawPanel should also provide event handling to enable the user to draw with the mouse.



The constructor should then set the background color of the DrawPanel to Color.WHITE and
register  the  MouseListener and  MouseMotionListener so  the  JPanel properly handles mouse events.

Next, create a JFrame subclass called DrawFrame that provides a GUI that enables the user to
control various aspects of drawing.

For the layout of the DrawFrame, we recommend a BorderLayout, with the components in the NORTH region,
the main drawing panel in the CENTER region, and a status bar in the SOUTH region, as in Fig. 12.49.

In the top panel, create the components listed below.
Each component’s event handler should call the appropriate method in class DrawPanel.

a) A button to undo the last shape drawn.
b) A button to clear all shapes from the drawing.
c) A combo box for selecting the color from the 13 predefined colors.
d) A combo box for selecting the shape to draw.
e) A checkbox that specifies whether a shape should be filled or unfilled. 

Declare and create the interface components in DrawFrame’s constructor.
You’ll need to create the status bar JLabel before you create the DrawPanel, so you
can pass the JLabel as an argument to DrawPanel’s constructor.

Finally, create a test class that initializes and displays the DrawFrame to execute the application.
*/


/**
 * Chapter 12 - Problem 17: Interactive Drawing Application
 * @author Douglas Skrypa
 * @version 2015.03.09
 */
public class DrawPanel extends JPanel {
	
	private class MouseHandler extends MouseAdapter implements MouseMotionListener {
		@Override
		public void mousePressed(final MouseEvent e) {
			//assigns currentShape a new shape of the type specified by shapeType and initializes both points to the mouse position.
		}
		
		@Override
		public void mouseReleased(final MouseEvent e) {
			//finish drawing the current shape and place it in the array. Set the second point of currentShape to the current mouse position and add currentShape to the array.
		}
		
		//Instance variable shapeCount determines the insertion index. Set currentShape to null and call method repaint to update the drawing with the new shape.
		
		@Override
		public void mouseMoved(final MouseEvent e) {
			//set the text of the statusLabel so that it displays the mouse coordinates—this will update the label with the coordinates every time the user moves (but does not drag) the mouse within the DrawPanel.
		}
		
		@Override
		public void mouseDragged(final MouseEvent e) {
			//sets the second point of the currentShape to the current mouse position and calls method repaint. This will allow the user to see the shape while dragging the mouse.
			//Also, update the JLabel in mouseDragged with the current position of the mouse.
		}
		
		
	}
	
	
	private enum ShapeType {
		LINE(MyLine.class), OVAL(MyOval.class), RECTANGLE(MyRectangle.class);
		private Class<?> c;
		private ShapeType(final Class<?> c) {	this.c = c;}
		public Class<?> getShapeClass() {	return c;}
	}
	private static final long serialVersionUID = 773549807044593116L;

	private JLabel statusLabel;
	private List<MyShape> shapes;
	private Color currentColor, backgroundColor;
	private ShapeType currentShapeType;
	private MyShape currentShape = null;
	private boolean filledShape = false;
	private MouseHandler mh;
	
	
	public static void main(final String[] args) {
		System.out.println("DrawPanel Test");
		
		for (ShapeType st : ShapeType.values()) {
			if (st.getShapeClass().getGenericSuperclass() == MyPolygon.class) {
				System.out.println(st.getShapeClass().getCanonicalName() + " is a MyPolygon");
			} else {
				System.out.println(st.getShapeClass().getCanonicalName() + " is a MyShape");
			}
		}
		
		
		ShapeType st = ShapeType.LINE;
		Class<?> sc = st.getShapeClass();
		for (Constructor<?> c : sc.getConstructors()) {
			System.out.println("Constructor: " + c.getName());
			for (Class<?> pc : c.getParameterTypes()) {
				System.out.println(pc.getCanonicalName());
			}
			
		}
	}
	
	
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
	
	public void drawShape() {
		Class<?> sc = currentShapeType.getShapeClass();
		MyShape s = null;
		Constructor<MyShape> con = null;
		if (sc.getGenericSuperclass() == MyPolygon.class) {
			try {
				con = (Constructor<MyShape>) sc.getConstructor(int.class,int.class,int.class,int.class,Color.class,boolean.class);
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			try {
				s = con.newInstance(0,0,0,0,currentColor,filledShape);
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
				s = con.newInstance(0,0,0,0,currentColor);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		//MyShape s = null;
		//Constructor<MyShape> c = stype.getShapeClass().getConstructor(parameterTypes)
		//Constructor<?>[] cs = stype.getShapeClass().getConstructors();
		//cs[0].
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
		
	}
	
	/**
	 * Remove the last shape drawn by decrementing shapeCount; ensure that it doesn't
	 * go below 0
	 */
	public void clearLastShape() {
		/*
		 * Methods clearLastShape and clearDrawing should call repaint (inherited from JPanel)
		 * to refresh the drawing on the DrawPanel by indicating that the system should call
		 * method paintComponent.
		 */
	}
	
	/**
	 * Remove all shapes in the current drawing by setting shapeCount to 0
	 */
	public void clearDrawing() {
		
	}
	
	
	
	
	
	
	
	
}