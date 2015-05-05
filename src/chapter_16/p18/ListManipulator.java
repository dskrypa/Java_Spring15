package chapter_16.p18;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Chapter 16 - Problem 18
 * @author Douglas Skrypa
 * @version 2015.05.05
 */
public class ListManipulator {

	public static void main(final String[] args) {
		String[] arr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		List<String> list1 = new LinkedList<>(Arrays.asList(arr));
		
		System.out.println("List 1:");
		printList(list1);
		
		List<String> list2 = new LinkedList<>(list1);
		list2.sort(Collections.reverseOrder());
		
		System.out.println("List 2:");
		printList(list2);
	}

	private static <T> void printList(List<T> list) {
		System.out.println("List contents:");
		for (T t : list) {
			System.out.printf("%s ", t);
		}
		System.out.println();
	}
}