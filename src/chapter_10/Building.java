package chapter_10;

/**
 * Chapter 10 - Problem 17: CarbonFootprint Interface: Polymorphism
 * @author Douglas Skrypa
 * @version 2015.02.10
 */
public class Building implements CarbonFootprint 
{
	final String state;
	
	/**
	 * Constructs a Building with the given parameters.
	 * @param state the state in which this Building is located.
	 */
	public Building(final String state) {
		this.state = state;
	}
	
	@Override
	public float getCarbonFootprint() {
		return 6.2f;
	}
	
	@Override
	public String toString() {
		return "Building in " + state;
	}
}