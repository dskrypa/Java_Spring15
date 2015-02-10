package chapter_10;

/**
 * Chapter 10 - Problem 17: CarbonFootprint Interface: Polymorphism
 * @author Douglas Skrypa
 * @version 2015.02.10
 */
public class Car implements CarbonFootprint
{
	final static float mpg2gpkm = 5456.97833256f;
	final static float mile2km = 1.60934f;
	final static float kg2ton = 0.00110231f;
	final String make, model, year;
	final float mileage, gasEfficiency;
	
	/**
	 * Constructs a Car with the given parameters.
	 * @param make Car manufacturer
	 * @param model Car model
	 * @param year Year car was built
	 * @param mileage Distance the car has travelled (in miles)
	 * @param gasEfficiency Gas efficiency (in miles per gallon)
	 */
	public Car(final String make, final String model, final String year, final float mileage, final float gasEfficiency) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
		this.gasEfficiency = gasEfficiency;
	}
	
	@Override
	public float getCarbonFootprint() {
		float kmTravelled = mileage * mile2km;
		float gramsPerKm = mpg2gpkm / gasEfficiency;
		float gramsCO2 = kmTravelled * gramsPerKm;
		float kgCO2 = gramsCO2 / 1000;
		return kgCO2 * kg2ton;
	}
	
	@Override
	public String toString() {
		return year + " " + make + " " + model;
	}
}