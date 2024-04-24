package com.dev.java.HeapProblems;

import java.util.PriorityQueue;

public class SlidingWindowMax {
	static class Pair implements Comparable<Pair> {
		int idx;
		int val;

		public Pair(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}

		@Override
		public int compareTo(Pair p2) {
			// Descending for MaxHeap
			return p2.val - val;
		}
	}

	// TC : O(nlogk)
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int k = 4;
		int n = arr.length;
		int[] res = new int[n - k + 1];

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		// 1st window
		for (int i = 0; i < k; i++) {
			pq.add(new Pair(i, arr[i]));
		}

		res[0] = pq.peek().val;

		// Adding data in priority Queue
		for (int i = k; i < n; i++) {
			while (pq.size() > 0 && pq.peek().idx <= i - k) {
				pq.remove();
			}
			pq.add(new Pair(i, arr[i]));
			res[i - k + 1] = pq.peek().val;
		}

		// Print
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
