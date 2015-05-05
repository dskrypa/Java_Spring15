package chapter_16.p19;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Chapter 16 - Problem 19
 * @author Douglas Skrypa
 * @version 2015.05.05
 */
public class PrimeFactorizer {
	//Memoize already checked numbers for primeness to reduce calculations
	private static Map<Integer, Boolean> isPrimeMap = new HashMap<>(); 
	
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Input an integer: ");
		String input = s.nextLine();
		s.close();
		
		try {
			int x = Integer.parseInt(input);
			if (!isPrime(x)) {
				Set<Integer> primeFactors = primeFactorize(x);
				System.out.printf("%d is not prime.\nPrime factors: ", x);
				printCollection(primeFactors);
			} else {
				System.out.printf("%d is prime.\n", x);
			}
		} catch (NumberFormatException e) {
			System.err.printf("Invalid input (must be an integer): %s\n", input);
			System.exit(1);
		}
	}

	private static boolean isPrime(final int n) {
		if (!isPrimeMap.containsKey(n)) {
			Set<Integer> factors = factorize(n);
			isPrimeMap.put(n, factors.size() < 3);
		}
		return isPrimeMap.get(n);
	}
	
	private static Set<Integer> primeFactorize(final int n) {
		double m = n;
		Set<Integer> factors = new TreeSet<>();
		for (int i = 1; i < Math.ceil(m/2)+1; i++) {
			double result = m / (double) i;
			int floored = (int) Math.floor(result);
			if (floored == result) {
				if (isPrime(i)) {
					factors.add(i);
				}
				if (isPrime(floored)) {
					factors.add(floored);
				}
			}
		}
		factors.remove(1);
		return factors;
	}
	
	private static Set<Integer> factorize(final int n) {
		double m = n;
		Set<Integer> factors = new TreeSet<>();
		for (int i = 1; i < Math.ceil(m/2)+1; i++) {
			double result = m / (double) i;
			int floored = (int) Math.floor(result);
			if (floored == result) {
				factors.add(i);
				factors.add(floored);
			}
		}
		return factors;
	}
	
	private static <T> void printCollection(final Collection<T> list) {
		for (T t : list) {
			System.out.printf("%s ", t);
		}
		System.out.println();
	}	
}