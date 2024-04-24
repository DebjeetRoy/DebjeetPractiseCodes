package com.java.recursion;

public class DecreasingOrderPrint {
	public static void main(String[] args) {
		int n = 10;

		decreasingPrint(n);
	}

	private static void decreasingPrint(int n) {
		if (n == 1) {
			System.out.print(n + " ");
			return;
		}
		System.out.print(n + " ");
		decreasingPrint(n - 1);
	}
}
