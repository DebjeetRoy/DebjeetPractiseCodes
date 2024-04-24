package com.java.stackProblems;

import java.util.ArrayDeque;

public class RemoveKdigits {
	public static String removeKdigits(String num, int k) {
		// You can code here
		String[] tokens = num.split("");
		int maximum = Integer.MIN_VALUE;
		int minimum = Integer.MAX_VALUE;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		StringBuilder res = new StringBuilder();

		// ArrayDeque<Integer> resStack = new ArrayDeque<>();

		// Checking for maximum data
		for (String token : tokens) {
			int data = Integer.parseInt(token);
			maximum = Math.max(maximum, data);
		}

		// Check for minimum data
		for (String token : tokens) {
			int data = Integer.parseInt(token);
			minimum = Math.min(minimum, data);
		}

		if (maximum > k) {
			int count = 0;
			for (String token : tokens) {
				int data = Integer.parseInt(token);
				if (data < k) {
					pushAtBottom(stack, Integer.parseInt(token));
				} else {
					if (count > k - 1) {
						pushAtBottom(stack, Integer.parseInt(token));
					}
					count++;
				}
			}
		} else if (maximum == k || minimum == k) {
			int count = k;
			for (String token : tokens) {
				int data = Integer.parseInt(token);

				if (count <= 0) {
					pushAtBottom(stack, data);
				}
				count--;
			}
		}

		while (!stack.isEmpty()) {
			res = res.append(stack.pop());
		}
		return res.toString();
	}

	public static void pushAtBottom(ArrayDeque<Integer> stack, int data) {
		// Base case
		if (stack.isEmpty()) {
			stack.push(data);
			return;
		}
		int top = stack.pop();
		pushAtBottom(stack, data);
		stack.push(top);
	}

	public static void main(String[] args) {
		String num = "54321";
		int k = 1;

		System.out.println(removeKdigits(num, k));
	}
}
