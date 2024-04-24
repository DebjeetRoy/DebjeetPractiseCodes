package com.java.stackProblems;

import java.util.Stack;

public class PushAtBottom {
	public static void pushAtBottom(Stack<Integer> stack, int data) {

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

		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(6);
		stack.push(7);

		int toBePushed = 8;

		System.out.println("Stack after pushing " + toBePushed + " at the bottom is : ");
		pushAtBottom(stack, toBePushed);

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
