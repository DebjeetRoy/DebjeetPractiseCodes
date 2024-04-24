package com.java.stackProblems;

import java.util.ArrayDeque;

public class Postfix {

	public static boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
	}

	public static int postfix(String str) {
		String[] token = str.split(" ");

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (String ele : token) {
			if (isOperator(ele)) {
				int second = stack.pop();
				int first = stack.pop();

				int result = 0;

				switch (ele) {
				case "+":
					result = first + second;
					break;

				case "-":
					result = first - second;
					break;

				case "*":
					result = first * second;
					break;

				case "/":
					result = first / second;
					break;

				case "^":
					result = (int) Math.pow(first, second);
					break;
				}
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(ele));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String str = "3 4 * 6 /"; // At runtime Postfix => Infix

		System.out.println("Postfix final value : " + postfix(str));
	}
}
