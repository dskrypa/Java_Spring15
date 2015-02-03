package chapter_08;

public class DateTester {
	public static void main(final String[] args) {
		Date d1 = new Date("Feb", 3, 2015);
		
		System.out.println(d1.format("YYYY.MM.dd"));
	}
}
