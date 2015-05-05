package chapter_16.p12;

import java.util.LinkedList;
import java.util.List;

/**
 * Chapter 16 - Problem 12
 * @author Douglas Skrypa
 * @version 2015.05.05
 */
public class ListTest {
	
	public static void main(final String[] args) {
		String[] colors = {"black", "yellow", "green", "blue", "violet", "silver"};
		List<String> list1 = new LinkedList<>();
		
		for (String color : colors) {
			list1.add(color);
		}
		
		String[] colors2 = {"gold", "white", "brown", "blue", "gray", "silver"};
		List<String> list2 = new LinkedList<>();
		
		for (String color : colors2) {
			list2.add(color);
		}
		
		list1.addAll(list2);
		list2 = null;
		printList(list1);
		
		convertToUpperCaseStrings(list1);
		printList(list1);
		
		System.out.printf("%nDeleting elements 4 to 6...");
	}

}
