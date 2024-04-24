package com.java.function;

public class FunctionExample {

	public static void main(String[] args) {
		int a = 5;
		int b = 6;

		int sum = sum(a, b); // call by Values

		System.out.println("a = " + a + " and b = " + b);

		// int sum = a + b;
		System.out.println(sum);

	}

	/*
	 * Sum of 2 numbers
	 */
	private static int sum(int a, int b) {
		a = a + 5; // 10
		b = b + 5; // 11
		int sum = 0;

		sum = a + b; // 21

		return sum;
	}

}
