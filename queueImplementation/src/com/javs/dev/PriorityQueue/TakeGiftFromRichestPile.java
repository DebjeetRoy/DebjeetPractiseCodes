package com.javs.dev.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGiftFromRichestPile {
	public static long pickGifts(int[] gifts, int k) {
		// You can code here

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int ele : gifts) {
			pq.add(ele);
		}
		long sum = 0;
		while (!pq.isEmpty() && k != 0) {
			int ele = pq.peek();
			int remaining = (int) Math.sqrt(ele);
			pq.poll();
			pq.add(remaining);
			// sum += remaining;
			k--;
		}
		for (Integer ele : pq) {
			sum += ele;
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] arr = { 25, 64, 9, 4, 100 };
		int k = 4;

		System.out.println(pickGifts(arr, k));
	}
}
