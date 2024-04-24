package com.java.dev.queueImpl.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueImpl { // Default implementation is min heap
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		pq.add(20);
		pq.add(10);
		pq.add(40);
		pq.add(1);

		while (!pq.isEmpty()) {
			System.out.println(pq.poll() + " ");
		}
	}
}
