package com.javs.dev.PriorityQueue;

import java.util.PriorityQueue;

public class KthLargestElement {

	public static int kthLargest(int[] a, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int e : a) {
			pq.add(e);
			if (pq.size() > k) {
				pq.poll();
			}
		}

		return pq.peek();
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 5, 6 };
		int k = 4;
		System.out.println(k + "th largest element in array is " + kthLargest(arr, k));
	}
}
