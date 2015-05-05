package chapter_16.p21;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Chapter 16 - Problem 21
 * @author Douglas Skrypa
 * @version 2015.05.05
 */
public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());
		queue.offer(3.2);
		queue.offer(9.8);
		queue.offer(5.4);
		
		System.out.println("Polling from queue: ");
		
		while (queue.size() > 0) {
			System.out.printf("%.1f ", queue.peek());
			queue.poll();
		}
	}
}