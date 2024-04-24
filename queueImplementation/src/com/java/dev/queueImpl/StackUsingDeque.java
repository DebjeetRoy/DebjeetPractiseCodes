package com.java.dev.queueImpl;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {
	public static class Stack {
		Deque<Integer> deque = new LinkedList<>();

		// Adding elements to Last
		public void push(int data) {
			deque.addLast(data);
		}

		// Removing elements from Last
		public int pop() {
			if (deque.isEmpty()) {
				System.out.println("Deque is Empty !!");
				return -1;
			}
			return deque.removeLast();
		}

		// Peek element from Deque
		public int peek() {
			if (deque.isEmpty()) {
				System.out.println("Deque is Empty !!");
				return -1;
			}
			return deque.getLast();
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);

		System.out.println("Peek : " + s.peek());

		System.out.println("Removed : " + s.pop());
		System.out.println("Removed : " + s.pop());
		System.out.println("Removed : " + s.pop());
		System.out.println("Removed : " + s.pop());
	}
}
