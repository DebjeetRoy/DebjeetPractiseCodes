package com.java.recursion;

public class Combination_Problem {
	public static void main(String[] args) {
		int n = 5;
		int r = 3;

		int value = nCr(n, r);
		System.out.println("Resultant value : " + value);
	}

	private static int nCr(int n, int r) {
		if (n == r || r == 0) {
			return 1;
		}
		return nCr(n - 1, r - 1) + nCr(n - 1, r);
	}
}
