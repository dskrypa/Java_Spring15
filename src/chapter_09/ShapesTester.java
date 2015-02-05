package chapter_09;

import org.junit.runner.JUnitCore;

/**
 * Chapter 9 - Problem 8: Quadrilateral Inheritance Hierarchy
 * @author Douglas Skrypa
 * @version 2015.02.05
 * https://github.com/dskrypa/Java_Spring15
 */
public class ShapesTester {
	public static void main(final String[] args) {
		JUnitCore runner = new JUnitCore();
		runner.addListener(new TestListener());
		runner.run(ShapesTestSuite.class);
	}
}