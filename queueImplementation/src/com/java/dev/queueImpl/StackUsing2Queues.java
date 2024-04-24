package com.java.dev.queueImpl;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queues {
	static class Stack {
		static Queue<Integer> q1 = new LinkedList<>();
		static Queue<Integer> q2 = new LinkedList<>();

		public static boolean isEmpty() {
			return q1.isEmpty() && q2.isEmpty();
		}

		// Add in Stack using 2 Queue approach
		public void push(int data) { // O(1)
			if (!q1.isEmpty()) {
				q1.add(data);
			} else
				q2.add(data);
		}

		// Remove from Stack using 2 Queue approach
		public int pop() { // O(n)
			if (isEmpty()) {
				System.out.println("Empty Stack");
				return -1;
			}
			int top = -1;

			// Case-1
			if (!q1.isEmpty()) {
				while (!q1.isEmpty()) {
					top = q1.remove();
					if (q1.isEmpty()) {
						break;
					}
					q2.add(top);
				}
				// Case-2
			} else {
				while (!q2.isEmpty()) {
					top = q2.remove();
					if (q2.isEmpty()) {
						break;
					}
					q1.add(top);
				}
			}
			return top;
		}

		public static int peek() {
			if (isEmpty()) {
				System.out.println("Empty Stack");
				return -1;
			}
			int top = -1;

			// Case-1
			if (!q1.isEmpty()) {
				while (!q1.isEmpty()) {
					top = q1.remove();
					q2.add(top);
				}
				// Case-2
			} else {
				while (!q2.isEmpty()) {
					top = q2.remove();
					q1.add(top);
				}
			}
			return top;
		}
	}

	public static void main(String[] args) {
		Stack s1 = new Stack();

		s1.push(1);
		s1.push(2);
		s1.push(3);
		// System.out.println(s1.pop());

		while (!Stack.isEmpty()) {
			System.out.println(Stack.peek());
			s1.pop();
		}
	}
}
