package com.java.dev.queueImpl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);

		Stack<Integer> stack = new Stack<>();
		while (!q.isEmpty()) {
			stack.push(q.remove());
		}
		while (!stack.isEmpty()) {
			q.add(stack.pop());
		}

		printStack(q);
	}

	private static void printStack(Queue<Integer> q) {
		while (!q.isEmpty()) {
			System.out.print(q.remove() + " ");
		}
	}
}
