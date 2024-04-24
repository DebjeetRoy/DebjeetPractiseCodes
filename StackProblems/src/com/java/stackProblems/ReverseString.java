package com.java.stackProblems;

import java.util.Stack;

public class ReverseString {

	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();

		String str = "Debjeet Roy";

		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}

		String reversedString = reverseString(stack);

		System.out.println("The reverse String for " + str + " is " + reversedString);
	}

	private static String reverseString(Stack<Character> stack) {
		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty()) {
			sb.append(stack.peek());
			stack.pop();
		}
		return sb.toString();
	}
}
