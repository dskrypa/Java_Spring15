package chapter_12;

import javax.swing.JFrame;

/*
Next, create a JFrame subclass called DrawFrame that provides a GUI that enables the user to
control various aspects of drawing.

For the layout of the DrawFrame, we recommend a BorderLayout, with the components in the NORTH region,
the main drawing panel in the CENTER region, and a status bar in the SOUTH region, as in Fig. 12.49.

In the top panel, create the components listed below.
Each component's event handler should call the appropriate method in class DrawPanel.

a) A button to undo the last shape drawn.
b) A button to clear all shapes from the drawing.
c) A combo box for selecting the color from the 13 predefined colors.
d) A combo box for selecting the shape to draw.
e) A checkbox that specifies whether a shape should be filled or unfilled. 

Declare and create the interface components in DrawFrame's constructor.
You'll need to create the status bar JLabel before you create the DrawPanel, so you
can pass the JLabel as an argument to DrawPanel's constructor.

Finally, create a test class that initializes and displays the DrawFrame to execute the application.
 */

public class DrawFrame extends JFrame {
	private static final long serialVersionUID = -9173794018682111371L;

	public DrawFrame() {
		
	}
}
