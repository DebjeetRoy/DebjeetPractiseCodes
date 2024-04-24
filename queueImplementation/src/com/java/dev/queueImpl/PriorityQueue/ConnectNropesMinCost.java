package com.java.dev.queueImpl.PriorityQueue;

import java.util.PriorityQueue;

public class ConnectNropesMinCost {
	public static void main(String[] args) {

		int[] arr = { 5, 2, 4, 8, 9, 6 };
		System.out.println("Sum of N ropes with min cost is : " + connectNropes(arr));
	}

	private static int connectNropes(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}

		int cost = 0;
		while (pq.size() >= 2) {
			int first = pq.poll();
			int second = pq.poll();

			int sum = first + second;
			cost += sum;
			pq.add(sum);
		}
		return cost;
	}
}
