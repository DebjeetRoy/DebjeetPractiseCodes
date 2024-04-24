package com.java.recursion;

public class PalinRecursion {
	public static void main(String[] args) {
		String str = "MADAM";

		System.out.println(isPalin(str));
	}

	private static boolean isPalin(String str) {
		return isPalinHelper(str, 0, str.length() - 1);
	}

	// Check Palindrome
	private static boolean isPalinHelper(String s, int l, int r) {
		// TC = O(n/2)
		if (l >= r) {
			return true;
		}
		if (s.charAt(l) == s.charAt(r)) {
			return isPalinHelper(s, l + 1, r - 1);
		}
		return false;
	}
}
