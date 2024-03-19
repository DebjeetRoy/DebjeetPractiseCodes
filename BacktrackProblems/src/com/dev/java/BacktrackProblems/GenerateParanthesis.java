package com.dev.java.BacktrackProblems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	public static void main(String[] args) {
		int n = 3;
		List<String> al = new ArrayList<>();
		al = generateParanthesis(n, "", 0, 0, 0, al);

		for (String str : al) {
			System.out.println(str);
		}
	}

	public static List<String> generateParanthesis(int n, String str, int i, int open, int close, List<String> al) {
		// Base case
		if (i == 2 * n) {
			al.add(str);
			return al;
		}

		// Checking open Paranthesis Conditions
		if (open < n) {
			str = str + "(";
			generateParanthesis(n, str, i + 1, open + 1, close, al);
			str = str.substring(0, str.length() - 1); // backtracking
		}

		// Checking close Paranthesis Conditions
		if (close < open) {
			str = str + ")";
			generateParanthesis(n, str, i + 1, open, close + 1, al);
		}
		return al;
	}
}
