package chapter_10;

import java.util.ArrayList;

/**
 * Chapter 10 - Problem 17: CarbonFootprint Interface: Polymorphism
 * @author Douglas Skrypa
 * @version 2015.02.10
 */
public class FootprintTester {
	public static void main(final String[] args) {
		ArrayList<CarbonFootprint> footprints = new ArrayList<>();
		footprints.add(new Bicycle("Trek"));
		footprints.add(new Car("Hyundai", "Accent", "2012", 31000, 37.4f));
		footprints.add(new Building("New Jersey"));
		
		float sum = 0;
		for (CarbonFootprint cf : footprints) {
			float fp = cf.getCarbonFootprint(); 
			sum += fp;
			System.out.println(cf.toString() + "'s carbon footprint: " + fp + " Tons of CO₂ per year");
		}
		System.out.println("\nTotal footprint: " + round(sum) + " Tons of CO₂ per year.");
	}
	
	private static float round(final double val) {
		int place = 10000;
		float r = Math.round(val * place);
		return r/place;
	}
}
