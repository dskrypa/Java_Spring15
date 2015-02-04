package chapter_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Chapter 8 - Problem 14
 * @author Douglas Skrypa
 * @version 2015.02.04
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
			if (m.ordinal() == 0) {continue;}
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
	
	public String getMonthName() {
		return month.getName();
	}
	
	public int getDayOfMonth() {
		return dayOfMonth;
	}
	
	public int getYear() {
		return year;
	}
	
	public Month getMonth() {
		return month;
	}
	
	public int getMonthNumber() {
		return month.ordinal();
	}
	
	/**
	 * Returns a String representation of this Date in the given format.
	 * @param fmt format String
	 * @return a String representation of this Date
	 */
	public String format(final String fmt) {
		Pattern mFull = Pattern.compile("[^M]*(MMMM+)[^M]*");
		Matcher mFullm = mFull.matcher(fmt);
		String monthRep = null, monthDisp = null;
		String dayRep = null, dayDisp = null;
		String yearRep = null, yearDisp = null;
		
		if (mFullm.matches()) {
			monthRep = mFullm.group(1);
			monthDisp = month.getName();
		} else if (fmt.contains("MMM")) {
			monthRep = "MMM";
			monthDisp = month.getAbbreviation();
		} else if (fmt.contains("MM")) {
			monthRep = "MM";
			monthDisp = String.format("%02d", month.ordinal());
		} else if (fmt.contains("M")) {
			monthRep = "M";
			monthDisp = Integer.toString(month.ordinal());
		}
		
		if (fmt.contains("YYYY")) {
			yearRep = "YYYY";
			yearDisp = String.format("%04d", year);
		} else if (fmt.contains("YY")) {
			yearRep = "YY";
			
			int truncated = year;
			truncated %= 100;
			yearDisp = String.format("%02d", truncated);
			//yearDisp = String.format("%02d", year);
			//yearDisp = Integer.toString(year).substring(2,4);
		}
		
		if (fmt.contains("dd")) {
			dayRep = "dd";
			dayDisp = String.format("%02d", dayOfMonth);
		} else if (fmt.contains("d")) {
			dayRep = "d";
			dayDisp = Integer.toString(dayOfMonth);
		} else if (fmt.contains("DDD")) {
			dayRep = "DDD";
			dayDisp = String.format("%03d", getDayOfYear());
		} else if (fmt.contains("DD")) {
			dayRep = "DD";
			dayDisp = String.format("%02d", getDayOfYear());
		} else if (fmt.contains("D")) {
			dayRep = "D";
			dayDisp = Integer.toString(getDayOfYear());
		}
		
		String formatted = fmt;
		formatted = formatted.replace(dayRep, dayDisp);
		formatted = formatted.replace(monthRep, monthDisp);
		formatted = formatted.replace(yearRep, yearDisp);
		return formatted;
	}
	
	/**
	 * Determines whether or not this Date is in a leap year
	 * @return true if it is in a leap year; false otherwise
	 */
	public boolean isLeapYear() {
		return (year % 4) == 0;
	}
	
	/**
	 * Calculates the day of the year that this Date represents
	 * @return the day of the year
	 */
	public int getDayOfYear() {
		int days = dayOfMonth;
		for (int m = 1; m < month.ordinal(); m++) {
			days += Month.values()[m].getDays();
			if ((m == 2) && isLeapYear()) {
				days += 1;
			}
		}
		return days;
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