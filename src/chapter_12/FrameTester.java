package chapter_12;

import javax.swing.JFrame;

public class FrameTester {
	public static void main(final String[] args) {
		DrawFrame df = new DrawFrame();
		df.setSize(500,500);
		df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		df.setVisible(true);
	}
}
