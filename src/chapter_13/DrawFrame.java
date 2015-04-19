package chapter_13;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

	private final JButton undoButton;
	private final JButton clearButton;
	private final JComboBox<String> colorSelector;
	private final JComboBox<String> shapeSelector;
	private final JCheckBox fillToggleBox;
	
	private final JPanel header;
	private final JLabel mousePosition;
	private final DrawPanel drawPanel;
	
	private final String[] colors = {"black","blue","cyan","dark gray","gray","green","light gray","magenta","orange","pink","red","white","yellow"};
	private final String[] shapes = {"line","oval","rectangle"};
	
	
	public DrawFrame() {
		super("Drawing Program");
		setLayout(new BorderLayout());
		
		header = new JPanel();
		
		undoButton = new JButton("Undo");
		undoButton.addActionListener(new UndoHandler());
		header.add(undoButton);
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ClearHandler());
		header.add(clearButton);
		
		colorSelector = new JComboBox<>(colors);
		colorSelector.addItemListener(new ColorHandler());
		header.add(colorSelector);
		
		shapeSelector = new JComboBox<>(shapes);
		shapeSelector.addItemListener(new ShapeHandler());
		header.add(shapeSelector);
		
		fillToggleBox = new JCheckBox("Filled");
		fillToggleBox.addItemListener(new FillHandler());
		header.add(fillToggleBox);
		
		add(header, BorderLayout.NORTH);
		
		mousePosition = new JLabel();
		drawPanel = new DrawPanel(mousePosition);
		add(drawPanel, BorderLayout.CENTER);
		add(mousePosition, BorderLayout.SOUTH);
	}
	
	private class UndoHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			drawPanel.clearLastShape();
		}
	}
	
	private class ClearHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			drawPanel.clearDrawing();
		}
	}
	
	private class ColorHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String selection = (String) colorSelector.getSelectedItem();
				drawPanel.setCurrentColor(selection);
			}	
		}
	}
	
	private class ShapeHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String selection = (String) shapeSelector.getSelectedItem();
				drawPanel.setShapeType(selection);
			}	
		}
	}
	
	private class FillHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			drawPanel.setFilledShape(fillToggleBox.isSelected());
		}
	}
}
