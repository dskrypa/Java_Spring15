package chapter_10;

/**
 * Chapter 10 - Problem 17: CarbonFootprint Interface: Polymorphism
 * @author Douglas Skrypa
 * @version 2015.02.10
 */
public class Bicycle implements CarbonFootprint
{
	final String brand;
	
	/**
	 * Constructs a Bicycle with the given parameters.
	 * @param brand The bike manufacturer
	 */
	public Bicycle(final String brand) {
		this.brand = brand;
	}
	
	@Override
	public float getCarbonFootprint() {
		return 0;
	}
	
	@Override
	public String toString() {
		return brand + " Bicycle";
	}
}