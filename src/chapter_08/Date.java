package chapter_08;

/**
 * Chapter 8 - Problem 14
 * @author Douglas Skrypa
 * @version 2015.02.03
 */
public class Date {
	private int year, dayOfMonth;
	private Month month = null;
	
	/**
	 * Constructor for a Date with all integer inputs
	 * @param month month (between 1 and 12, inclusive)
	 * @param day day of month
	 * @param year year
	 */
	public Date(final int month, final int day, final int year) {
		if ((0 < month) && (month < 13)) {
			this.month = Month.values()[month];
		} else {
			throw new java.lang.IllegalArgumentException("Illegal value provided for month: " + month);
		}
		
		if (isValidDate(day, year)) {
			this.year = year;
			this.dayOfMonth = day;
		} else {
			throw new java.lang.IllegalArgumentException("Illegal value provided for day (" + day + ") and/or year (" + year + ").");
		}
	}
	
	/**
	 * Constructor for a Date that accepts the month name as a String
	 * @param month the name or abbreviation of a month
	 * @param day day of month
	 * @param year year
	 */
	public Date(final String month, final int day, final int year) {
		for (Month m : Month.values()) {
			if (month.toLowerCase().equals(m.getName().toLowerCase()) || month.toLowerCase().equals(m.getAbbreviation().toLowerCase())) {
				this.month = m;
			}
		}
		if (this.month == null) {
			throw new java.lang.IllegalArgumentException("Illegal value provided for month: " + month);
		}
		
		if (isValidDate(day, year)) {
			this.year = year;
			this.dayOfMonth = day;
		} else {
			throw new java.lang.IllegalArgumentException("Illegal value provided for day (" + day + ") and/or year (" + year + ").");
		}
	}
	
	/**
	 * Constructor for a Date that accepts the day of the year
	 * @param dayOfYear the day the year, with 1 being January 1st
	 * @param year year
	 */
	public Date(final int dayOfYear, final int year) {
		if (year < 0) {
			throw new java.lang.IllegalArgumentException("Illegal value provided for year: " + year);
		}
		boolean leapYear = (year % 4) == 0;
		int maxDays = leapYear ? 366 : 365;
		if ((dayOfYear < 1) || (dayOfYear > maxDays)) {
			throw new java.lang.IllegalArgumentException("Illegal value provided for day of year: " + dayOfYear);
		}
		int daysLeft = dayOfYear;
		for (int m = 1; m <= 12; m++) {
			Month mm = Month.values()[m];
			int days = mm.getDays() + (((m == 2) && leapYear) ? 1 : 0);
			if ((daysLeft - days) > 1) {
				daysLeft -= days;
			} else {
				this.month = mm;
				this.dayOfMonth = daysLeft;
				break;
			}
		}
	}
	
	/**
	 * Returns a String representation of this Date in the given format.
	 * @param fmt
	 * @return
	 */
	public String format(final String fmt) {
		return null;
	}
	
	/**
	 * Validates the given day in the given year, based on an already authenticated month.
	 * @param day day of month
	 * @param year year
	 * @return true if the given values represent a valid date
	 */
	private boolean isValidDate(final int day, final int year) {
		if (year < 0) {
			return false;
		}
		int maxDay = this.month.getDays();
		if ((this.month == Month.FEBRUARY) && ((year % 4) == 0)) {
			maxDay = 29;
		}
		if ((day < 0) || (maxDay < day)) {
			return false;
		}
		return true;
	}	
}