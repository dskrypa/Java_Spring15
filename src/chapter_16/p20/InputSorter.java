package chapter_16.p20;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Chapter 16 - Problem 20
 * @author Douglas Skrypa
 * @version 2015.05.05
 */
public class InputSorter {
	
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Input some words: ");
		String input = s.nextLine();
		s.close();
		
		String[] tokens = input.split(" ");
		Set<String> ts = new TreeSet<>(Arrays.asList(tokens));
		
		System.out.println("Your input, sorted:");
		printCollection(ts);
	}
	
	private static <T> void printCollection(final Collection<T> list) {
		for (T t : list) {
			System.out.printf("%s ", t);
		}
		System.out.println();
	}	
}