package com.java.stackProblems;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] arr = { 3, 9, 2, 0, 1, 11 };

		Stack<Integer> stack = new Stack<>();
		int nextGreater[] = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			// 1 - while loop to remove smaller elements to right
			// to store index in stack and not number itself.
			while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}

			// 2 - if else
			if (stack.isEmpty()) {
				nextGreater[i] = -1;
			} else {
				nextGreater[i] = arr[stack.peek()];
			}

			// 3 - Push to stack
			stack.push(i);
		}

		for (int i = 0; i < nextGreater.length; i++) {
			System.out.print(nextGreater[i] + " ");
		}
		System.out.println();
	}

}
