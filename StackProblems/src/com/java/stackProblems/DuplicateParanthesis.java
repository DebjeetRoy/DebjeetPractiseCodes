package com.java.stackProblems;

import java.util.Stack;

public class DuplicateParanthesis {

	// Duplicate check
	public static boolean isDuplicateParanthesis(String str) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// closing braces
			if (ch == ')') {
				int count = 0;

				while (s.peek() != '(') {
					s.pop();
					count++;
				}
				if (count < 1) {
					return true; // duplicate braces
				} else {
					s.pop(); // opening pair
				}
			} else {
				// opening
				s.push(ch);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		String str = "((a+b)+c)";

		boolean isDuplicate = isDuplicateParanthesis(str);

		if (isDuplicate) {
			System.out.println(str + " is having duplicate braces");
		} else {
			System.out.println(str + " is fine");
		}
	}
}
