package com.java.stackProblems;

import java.util.ArrayDeque;

public class InfixToPostfix {

	public static boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
	}

	public static int precedence(String op) {
		switch (op) {
		case "^":
			return 3;
		case "*":
		case "/":
			return 2;
		case "+":
		case "-":
			return 1;

		default:
			return -1;
		}
	}

	public static String infixToPostfix(String str) {
		String[] tokens = str.split("");
		ArrayDeque<String> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		for (String token : tokens) {
			if (token.equals("(")) {
				stack.push(token);
			} else if (isOperator(token)) {
				while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
					String temp = stack.pop();
					sb.append(temp).append(" ");
				}
				stack.push(token);
			} else if (token.equals(")")) {
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					String temp = stack.pop();
					sb.append(temp).append(" ");
				}
				stack.pop();
			} else {// operand
				sb.append(token).append(" ");
			}
		}

		// Remove any remaining operators in stack
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// String s = "a+b*(c^d-e)^(f+g*h)-i";
		String s = "A * ( B + C ) + D * ( E + F )";
		s = s.replace(" ", "");

		System.out.println(infixToPostfix(s));
	}
}
