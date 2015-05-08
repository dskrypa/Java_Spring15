package final_exam.Q1;

/**
 * Final Exam - Question 1
 * @author Douglas Skrypa
 * @version 2015.05.08
 */
public class ShowPropertyTest {
	public static void main(final String[] args) {
		ShowProperty[] props = new ShowProperty[2];
		props[0] = new NumberList(new int[] {1,2,3,4,5});
		props[1] = new StringList("a_test", "b_test");
		
		for (ShowProperty sp : props) {
			sp.displayProperty();
		}
	}
}