package misc;

import org.junit.runner.JUnitCore;

import common.TestListener;

public class MiscTester {

	public static void main(final String[] args) {
		JUnitCore runner = new JUnitCore();
		runner.addListener(new TestListener());
		runner.run(MiscTestSuite.class);
	}

}
