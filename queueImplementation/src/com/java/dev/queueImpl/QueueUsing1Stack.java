package com.java.dev.queueImpl;

import java.util.Stack;

public class QueueUsing1Stack {
	static class MyQueue {
		Stack<Integer> stack = new Stack<>();

		void Push(int x) {
			// You can code here
			stack.push(x);
		}

		public boolean isEmpty() {
			return stack.size() == 0;
		}

		int Pop() {
			// You can code here

			// Base case
			if (stack.isEmpty()) {
				return -1;
			}
			if (stack.size() == 1) {
				return stack.pop();
			}

			// Logic
			int top = stack.pop();
			int ans = Pop();
			stack.push(top);
			return ans;
		}
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.Push(1);
		queue.Push(2);
		queue.Push(3);

		queue.Pop();
		// queue.Pop();

		while (!queue.isEmpty()) {
			System.out.println(queue.Pop());
		}
	}
}
