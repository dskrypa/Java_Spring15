package misc;

public class Vector {
	private final double[] vector;
	
	public Vector(final double[] vector) {
		this.vector = vector;
	}
	
	public int getLength() {
		return vector.length;
	}
	
	public double getValue(final int index) {
		return vector[index];
	}
	
	public boolean isLinearlyDependent(final Vector other) {
		if ((this.getLength() != other.getLength()) || (getLength() == 0)) {
			return false;
		} else if (getLength() == 1) {
			return this.getValue(0) == other.getValue(0);
		}
		for (int i = 0; i < getLength()-1; i++) {
			double a = this.getValue(i) * other.getValue(i+1);
			double b = this.getValue(i+1) * other.getValue(i);
			if (a != b) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isLinearlyIndependent(final Vector other) {
		return !isLinearlyDependent(other);
	}
	
	public boolean equals(final Vector other) {
		if (this.getLength() != other.getLength()) {
			return false;
		}
		for (int i = 0; i < getLength(); i++) {
			if (this.getValue(i) != other.getValue(i)) {
				return false;
			}
		}
		return true;
	}
}