package chapter_12;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.prism.paint.Color;

/*
Methods clearLastShape and clearDrawing should call repaint (inherited from JPanel) to refresh
the drawing on the DrawPanel by indicating that the system should call method paintComponent.

Class DrawPanel should also provide event handling to enable the user to draw with the mouse.

Create a single inner class that both extends MouseAdapter and implements MouseMotionListener to
handle all mouse events in one class.

In the inner class, override method mousePressed so that it assigns currentShape a new shape
of the type specified by shapeType and initializes both points to the mouse position.

Next, override method mouseReleased to finish drawing the current shape and place it in the array.
Set the second point of currentShape to the current mouse position and add currentShape to the array.

Instance variable shapeCount determines the insertion index. Set currentShape to null and call method
repaint to update the drawing with the new shape.

Override method mouseMoved to set the text of the statusLabel so that it displays the mouse
coordinates—this will update the label with the coordinates every time the user moves (but does
not drag) the mouse within the DrawPanel.

Next, override method mouseDragged so that it sets the second point of the currentShape to the
current mouse position and calls method repaint. This will allow the user to see the shape while
dragging the mouse.

Also, update the JLabel in mouseDragged with the current position of the mouse.

Create a constructor for DrawPanel that has a single JLabel parameter.
In the constructor, initialize statusLabel with the value passed to the parameter.
Also initialize array shapes with 100 entries, shapeCount to 0, shapeType to the value that
represents a line, currentShape to null and currentColor to Color.BLACK.
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
 * @version 2015.02.26
 */
public class DrawPanel extends JPanel {
	private enum ShapeType {
		LINE(MyLine.class), OVAL(MyOval.class), RECTANGLE(MyRectangle.class);
		private Class<?> c;
		private ShapeType(final Class<?> c) {
			this.c = c;
		}
		public Class<?> getShapeClass() {
			return c;
		}
	}
	private static final long serialVersionUID = 773549807044593116L;

	private List<MyShape> shapes;
	private int shapeCount = 0;
	private ShapeType stype = ShapeType.LINE;
	private MyShape currentShape = null;
	private Color currentColor = Color.BLACK;
	private boolean filledShape = false;
	private JLabel statusLabel;
	
	
	public static void main(final String[] args) {
		System.out.println("DrawPanel Test");
		ShapeType st = ShapeType.LINE;
		Class<?> sc = st.getShapeClass();
		for (Constructor<?> c : sc.getConstructors()) {
			System.out.println("Constructor: " + c.getName());
			for (Class<?> pc : c.getParameterTypes()) {
				System.out.println(pc.getCanonicalName());
			}
			
		}
	}
	
	
	public DrawPanel() {
		shapes = new ArrayList<>();
	}
	
	public void drawShape() {
		Class<?> sc = stype.getShapeClass();
		sc.getTypeParameters();
		
		
		//MyShape s = null;
		//Constructor<MyShape> c = stype.getShapeClass().getConstructor(parameterTypes)
		//Constructor<?>[] cs = stype.getShapeClass().getConstructors();
		//cs[0].
	}
	
	

	public List<MyShape> getShapes() {	return shapes;}
	
	public void setShapeType(final ShapeType type) {	stype = type;}
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