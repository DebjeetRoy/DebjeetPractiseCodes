package com.java.dev.queueImpl;

import java.util.Deque;
import java.util.LinkedList;

public class DequeImpl {

	public static void main(String[] args) {
		Deque<Integer> deque = new LinkedList<>();

		deque.addFirst(1);
		deque.addFirst(2);
		deque.addLast(3);
		deque.addLast(4);
		// deque.addFirst(5);

		System.out.println(deque);

		System.out.println("Remove First : " + deque.removeFirst());
		System.out.println(deque);
		System.out.println("Remove Last : " + deque.removeLast());
		System.out.println(deque);
		System.out.println("Get First : " + deque.getFirst());
		System.out.println("Get Last : " + deque.getLast());
	}
}
