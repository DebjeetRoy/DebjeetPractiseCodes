package com.java.recursion;

public class Factorial {
	public static void main(String[] args) {
		int n = 6;

		System.out.println("Factorial of " + n + " is " + factorial(n));
	}

	private static int factorial(int n) { // TC - O(n), SC = O(n)
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
}
