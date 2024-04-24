package com.java.dev.queueImpl;

import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingDeque {
	public static class Queue {
		Deque<Integer> deque = new LinkedList<>();

		// Adding elements to Rear
		public void add(int data) {
			deque.addLast(data);
		}

		// Removing elements from Front
		public int remove() {
			return deque.removeFirst();
		}

		// Peek element from Front
		public int peek() {
			return deque.getFirst();
		}
	}

	public static void main(String[] args) {
		Queue s = new Queue();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);

		System.out.println("Peek : " + s.peek());

		System.out.println("Removed : " + s.remove());
		System.out.println("Removed : " + s.remove());
		System.out.println("Removed : " + s.remove());
		System.out.println("Removed : " + s.remove());
	}
}
