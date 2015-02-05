package chapter_08;

/**
 * Chapter 8 - Problem 14
 * @author Douglas Skrypa
 * @version 2015.02.03
 * https://github.com/dskrypa/Java_Spring15
 */
public enum Month {
	NONE (null, null, 0),	//NONE included so that January has the value 1
	JANUARY ("January", "Jan", 31), FEBRUARY ("February", "Feb", 28), MARCH ("March", "Mar", 31),
	APRIL ("April", "Apr", 30), MAY ("May", "May", 31), JUNE ("June", "Jun", 30),
	JULY ("July", "Jul", 31), AUGUST ("August", "Aug", 31), SEPTEMBER ("September", "Sept", 30),
	OCTOBER ("October", "Oct", 31), NOVEMBER ("November", "Nov", 30), DECEMBER ("December", "Dec", 31);
	
	private final String name, abbreviation;
	private final int days;
	
	/**
	 * Constructs a Month with the given attributes
	 * @param name name of the month
	 * @param abbreviation shorted name of the month
	 * @param days number of days in the month
	 */
	Month(final String name, final String abbreviation, final int days) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.days = days;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
	
	public int getDays() {
		return days;
	}
}