package com.java.stackProblems;

import java.util.Stack;

public class ReverseStack {
	/*
	 * Logic to Reverse a Stack
	 */
	public static void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int top = stack.pop();
		reverseStack(stack);

		PushAtBottom.pushAtBottom(stack, top);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println("Stack after reversing : ");
		reverseStack(stack);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
