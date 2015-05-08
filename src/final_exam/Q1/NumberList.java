package final_exam.Q1;

/**
 * Final Exam - Question 1
 * @author Douglas Skrypa
 * @version 2015.05.08
 */
public class NumberList implements ShowProperty
{
	private int[] numbers = {};
	private int size = 0;
	
	public NumberList(final int[] nums) {
		size = nums.length;
		numbers = new int[size];
		System.arraycopy(nums, 0, numbers, 0, size);
	}

	@Override
	public void displayProperty() {
		int sum = 0;
		for (int n : numbers) {
			sum += n;
		}
		System.out.printf("Sum: %d\n", sum);
	}
}