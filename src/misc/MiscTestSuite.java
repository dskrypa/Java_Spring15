package misc;

import static org.junit.Assert.*;

import org.junit.Test;

public class MiscTestSuite {
	@Test
	public void testVectorDependenceInt1() {
		Vector a = new Vector(new double[] {2,3});
		Vector b = new Vector(new double[] {4,6});
		assertTrue(a.isLinearlyDependent(b));
	}

	@Test
	public void testVectorDependenceInt2() {
		Vector a = new Vector(new double[] {2,3});
		Vector b = new Vector(new double[] {4,5});
		assertFalse(a.isLinearlyDependent(b));
	}
	
	@Test
	public void testVectorDependenceInt3() {
		Vector a = new Vector(new double[] {2,3,4});
		Vector b = new Vector(new double[] {4,6,8});
		assertTrue(a.isLinearlyDependent(b));
	}

	@Test
	public void testVectorDependenceInt4() {
		Vector a = new Vector(new double[] {2,3,4});
		Vector b = new Vector(new double[] {4,5,8});
		assertFalse(a.isLinearlyDependent(b));
	}
	
	@Test
	public void testVectorDependenceInt5() {
		Vector a = new Vector(new double[] {2,3,4,2,3});
		Vector b = new Vector(new double[] {4,6,8,4,6});
		assertTrue(a.isLinearlyDependent(b));
	}

	@Test
	public void testVectorDependenceInt6() {
		Vector a = new Vector(new double[] {2,3,4,2,3});
		Vector b = new Vector(new double[] {4,5,8,6,4});
		assertFalse(a.isLinearlyDependent(b));
	}
	
	@Test
	public void testVectorDependenceInt7() {
		Vector a = new Vector(new double[] {4,6,8});
		Vector b = new Vector(new double[] {2,3,4});
		assertTrue(a.isLinearlyDependent(b));
	}
	
	@Test
	public void testVectorIndependenceInt1() {
		Vector a = new Vector(new double[] {2,3,4,2,3});
		Vector b = new Vector(new double[] {4,5,8,6,4});
		assertTrue(a.isLinearlyIndependent(b));
	}
	
	@Test
	public void testVectorDependenceDouble1() {
		Vector a = new Vector(new double[] {2.5,3.5});
		Vector b = new Vector(new double[] {5,7});
		assertTrue(a.isLinearlyDependent(b));
	}
	
	@Test
	public void testVectorDependenceDouble2() {
		Vector a = new Vector(new double[] {2.5,3.5});
		Vector b = new Vector(new double[] {4,6});
		assertFalse(a.isLinearlyDependent(b));
	}
}