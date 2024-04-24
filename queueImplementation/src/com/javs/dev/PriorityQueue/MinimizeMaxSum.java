package com.javs.dev.PriorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimizeMaxSum {
	public static int divideSubset(Integer[] a, int m) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Arrays.sort(a, Collections.reverseOrder());
		// Initially add 0 for all elements in Priority Queue.
		for (int i = 0; i < m; i++) {
			pq.add(0);
		}

		// add element to smallest element which is at top as it's a min heap
		for (int e : a) {
			int smallest = pq.poll();
			pq.add(smallest + e);
		}

		for (int i = 0; i < m - 1; i++) {
			pq.poll();
		}
		return pq.poll();
	}

	public static void main(String[] args) {
		Integer[] a = { 1, 7, 9, 2, 12, 3, 3 };
		int m = 3;
		System.out.println("Minimum of all maximum sums with " + m + " subsets is " + divideSubset(a, m));
	}
}
