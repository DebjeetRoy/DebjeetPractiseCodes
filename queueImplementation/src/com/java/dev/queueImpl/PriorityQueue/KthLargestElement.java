package com.java.dev.queueImpl.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
	public static void main(String[] args) {

		int[] arr = { 1, 5, 0, 3, 2, 7 };
		int k = 3;

		kthLargest(arr, k);
		kthSmallest(arr, k);
	}

	// Kth Largest(Min heap)
	private static void kthLargest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		// 0,1,2,3,5,7

		for (int j = k; j < arr.length; j++) {
			if (arr[j] > pq.peek()) {
				pq.poll();
				pq.add(arr[j]);
			}
		}
		System.out.println(k + "th largest element is " + pq.peek());
	}

	// Kth Smallest(Max heap)
	private static void kthSmallest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		// 1,2,3,4,6,7,8,9

		for (int j = k; j < arr.length; j++) {
			if (arr[j] < pq.peek()) {
				pq.poll();
				pq.add(arr[j]);
			}
		}
		System.out.println(k + "th smallest element is " + pq.peek());
	}
}
