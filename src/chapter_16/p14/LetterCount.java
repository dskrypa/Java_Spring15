package chapter_16.p14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Chapter 16 - Problem 14
 * @author Douglas Skrypa
 * @version 2015.05.05
 */
public class LetterCount {

	public static void main(String[] args) {
		Map<Character, Integer> myMap = new HashMap<>();
		createMap(myMap);
		displayMap(myMap);
	}
	
	private static void createMap(Map<Character, Integer> map) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string:");
		String input = scanner.nextLine();
		
		input = input.replaceAll(" ", "");
		char[] tokens = input.toCharArray();
		
		for (char token : tokens) {
			char w = Character.toLowerCase(token);
			if (map.containsKey(w)) {
				int count = map.get(w);
				map.put(w, count+1);
			} else {
				map.put(w, 1);
			}
		}
		scanner.close();
	}
	
	private static void displayMap(Map<Character, Integer> map) {
		Set<Character> keys = map.keySet();
		TreeSet<Character> sortedKeys = new TreeSet<>(keys);
		System.out.printf("%nMap contains:%nKey\t\tValue%n");
		
		for (Character key : sortedKeys) {
			System.out.printf("%-10s%10s%n", key, map.get(key));
		}
		System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
	}
}