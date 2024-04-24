package com.java.dev.queueImpl;

import java.util.LinkedList;
import java.util.Queue;

public class Interleave2Halves {
	public static void main(String[] args) {
		// Queue is of even length
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);
		q.add(8);
		q.add(9);
		q.add(10);

		int mid = q.size() / 2;
		Queue<Integer> q1 = new LinkedList<>();

		// 1st half of queue
		for (int i = 0; i < mid; i++) {
			q1.add(q.remove());
		}
		printQueue(q1, q);
	}

	// Printing Final Queue
	private static void printQueue(Queue<Integer> q1, Queue<Integer> q2) {
		Queue<Integer> finalQueue = new LinkedList<>();
		while (!q1.isEmpty() && !q2.isEmpty()) {
			finalQueue.add(q1.remove());
			finalQueue.add(q2.remove());
		}
		while (!finalQueue.isEmpty()) {
			System.out.print(finalQueue.peek() + " ");
			finalQueue.remove();
		}
	}
}
