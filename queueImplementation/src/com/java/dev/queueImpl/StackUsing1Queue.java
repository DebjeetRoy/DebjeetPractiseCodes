package com.java.dev.queueImpl;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing1Queue {
	public static class MyStack {
		private Queue<Integer> queue = new LinkedList<>();

		public void push(int data) {
			queue.offer(data);
		}

		public int pop() {
			if (queue.isEmpty())
				return -1;

			int size = queue.size();
			for (int i = 0; i < size - 1; i++) {
				queue.offer(queue.poll());
			}
			return queue.poll();
		}
	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();

		stack.push(10);
		stack.push(20);
		System.out.println(stack.pop());
		stack.push(30);
		System.out.println(stack.pop());
		stack.push(40);
		System.out.println(stack.pop());
	}
}
