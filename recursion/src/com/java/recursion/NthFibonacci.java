package com.java.recursion;

public class NthFibonacci {
	public static void main(String[] args) {
		int n = 6;

		System.out.println("Nth Fibonacci number is : " + nthFibonacci(n));
	}

	private static int nthFibonacci(int n) {
		// 0 1 1 2 3 5 8 13
		if (n == 0 || n == 1) {
			return n;
		}
		// int sum = 1; // Add sum to below recursive call to sum Fibonacci
		return nthFibonacci(n - 1) + nthFibonacci(n - 2);
	}
}
