package com.dev.java.HeapProblems;

import java.util.PriorityQueue;

public class ConnectNropes {

	public static void main(String[] args) {
		int[] ropes = { 2, 3, 3, 4, 6 };

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int rope : ropes) {
			pq.add(rope);
		}

		// Running loop for finding min cost till only 1 size remains in array
		int cost = 0;
		while (pq.size() > 1) {
			int min1 = pq.remove();
			int min2 = pq.remove();
			// Adding all min costs
			cost += min1 + min2;
			pq.add(min1 + min2);
		}
		System.out.println("Minimum cost to connect N ropes : " + cost);
	}
}
