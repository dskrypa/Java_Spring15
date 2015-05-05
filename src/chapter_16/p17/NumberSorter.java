package chapter_16.p17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Chapter 16 - Problem 17
 * @author Douglas Skrypa
 * @version 2015.05.05
 */
public class NumberSorter {

	public static void main(final String[] args) {
		List<Integer> ints = new LinkedList<>();
		
		Random r = new Random();
		for (int x = 0; x < 25; x++) {
			ints.add(r.nextInt(100));
		}
		
		printList(ints);
		Collections.sort(ints);
		System.out.println("\nSorting...");
		printList(ints);
		
		int sum = getSum(ints);
		float mean = (float) sum / (float) ints.size();
		System.out.printf("\nSum: %d\nAverage: %.2f\n", sum, mean);
	}
	
	private static <T> void printList(List<T> list) {
		System.out.println("List contents:");
		for (T t : list) {
			System.out.printf("%s ", t);
		}
		System.out.println();
	}
	
	private static int getSum(List<Integer> list) {
		int sum = 0;
		for (int t : list) {
			sum += t;
		}
		return sum;
	}	
}