package com.java.recursion;

public class SumNnaturalNo {
	public static void main(String[] args) {
		int n = 100;

		System.out.println("Sum = " + sum(n));
	}

	private static int sum(int n) {
		// Base Condition
		if (n == 1) {
			return 1;
		}
		return n + sum(n - 1);
	}
}
