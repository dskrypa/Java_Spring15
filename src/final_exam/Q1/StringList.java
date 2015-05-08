package final_exam.Q1;

/**
 * Final Exam - Question 1
 * @author Douglas Skrypa
 * @version 2015.05.08
 */
public class StringList implements ShowProperty
{
	private String a, b;
	
	public StringList(final String a, final String b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public void displayProperty() {
		System.out.printf("First letters: %s %s\n", a.substring(0,1), b.substring(0,1));
	}
}