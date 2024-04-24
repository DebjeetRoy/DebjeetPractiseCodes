package com.java.recursion;

public class IncreasingOrderPrint {
	public static void main(String[] args) {
		int n = 10;

		increasingPrint(n);
	}

	private static void increasingPrint(int n) {
		if (n == 1) {
			System.out.print(n + " ");
			return;
		}
		increasingPrint(n - 1);
		System.out.print(n + " ");
	}
}
