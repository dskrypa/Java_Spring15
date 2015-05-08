package final_exam.Q3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Final Exam - Question 3
 * @author Douglas Skrypa
 * @version 2015.05.08
 */
public class ListTest {

	public static void main(final String[] args) throws IOException {
		ListTestFrame ltf = new ListTestFrame();
		
		int n = ltf.getN();
		String fname = ltf.getFileName();
		
		List<Integer> ints = new LinkedList<>();
		
		Random r = new Random();
		for (int x = 0; x < n; x++) {
			ints.add(r.nextInt(100));
		}
		
		Collections.sort(ints);
		int sum = getSum(ints);
		float mean = (float) sum / (float) ints.size();
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(n);
		sb.append(" random integers from 0 to 100 generated:\n");
		
		boolean first = true;
		for (int i : ints) {
			if (first) {
				first = false;
			} else {
				sb.append(", ");
			}
			sb.append(i);
		}
		
		sb.append("\nThe sum of these random integers is: ");
		sb.append(sum);
		sb.append("\nThe average of these random integers is: ");
		sb.append(mean);
		
		String toWrite = sb.toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
		bw.write(toWrite);
		bw.close();
		
		System.out.printf("Wrote to %s:\n", fname);
		System.out.println(toWrite);
	}
	
	private static int getSum(List<Integer> list) {
		int sum = 0;
		for (int t : list) {
			sum += t;
		}
		return sum;
	}
}