package com.java.stackProblems;

import java.util.Stack;

public class ValidParanthesis {
	public static void main(String[] args) {

		final String str = "(({}))";

		final boolean isValid = checkValidParanthesis(str);

		if (isValid) {
			System.out.println(str + " is a valid paranthesis");
		} else {
			System.out.println(str + " is NOT a valid paranthesis");
		}
	}

	private static boolean checkValidParanthesis(String str) {
		final Stack<Character> stack = new Stack<>();
		boolean status = false;

		if (str.charAt(0) == ')' || str.charAt(0) == '}' || str.charAt(0) == ']')
			return false;

		for (int i = 0; i <= str.length() - 1; i++) {
			final char ch = str.charAt(i);

			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else if (stack.size() > 0 && ((stack.peek() == '(' && ch == ')') || (stack.peek() == '{' && ch == '}')
					|| (stack.peek() == '[' && ch == ']'))) {
				stack.pop();
			} else
				status = false;
		}
		if (stack.isEmpty())
			status = true;
		return status;
	}
}
