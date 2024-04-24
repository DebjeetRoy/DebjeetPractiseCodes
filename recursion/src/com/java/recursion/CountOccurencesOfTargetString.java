package com.java.recursion;

public class CountOccurencesOfTargetString {
	public static void main(String[] args) {
		String src = "aabbaababbbbs";
		String target = "bb";

		int occurence = countOccurence(src, target);
		System.out.println(target + " Occured " + occurence + " times !!");
	}

	private static int countOccurence(String src, String target) {
		return countOccurenceHelper(src, target, 0);
	}

	private static int countOccurenceHelper(String src, String target, int i) {
		// Base case
		if (i > src.length() - target.length()) {
			return 0;
		}
		int subProblem = countOccurenceHelper(src, target, i + 1);

		if (src.substring(i, i + target.length()).equals(target)) {
			return subProblem + 1;
		}
		return subProblem;
	}
}
