package com.java.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsets {
	public static void main(String[] args) {
		String str = "abc";
		List<String> listSubset = printSubset(str, 0, "");

		for (String s : listSubset) {
			System.out.println(s);
		}
	}

	private static List<String> printSubset(String str, int i, String curr) {
		List<String> al = new ArrayList<>();
		return printSubsetHelper(str, i, curr, al);
	}

	private static List<String> printSubsetHelper(String str, int i, String curr, List<String> subsets) {
		if (i == str.length()) {
			subsets.add(curr);
			return subsets;
		}
		printSubsetHelper(str, i + 1, curr + str.charAt(i), subsets); // Adding next element
		printSubsetHelper(str, i + 1, curr, subsets); // Not adding next element
		return subsets;
	}
}
