package com.java.recursion;

public class Problem2XNTiling {

	// tiling - Vertical and Horizontal Choices.
	public static int tilingProblem(int n) {
		// Base case
		if (n == 0 || n == 1) {
			return 1;
		}

		// Recursion
		// Vertical
		int vertical = tilingProblem(n - 1);

		// Horizontal
		int horizontal = tilingProblem(n - 2);

		// Adding all choices
		return vertical + horizontal;
	}

	public static void main(String[] args) {

		int n = 5; // 2X1 (2 - Breadth, 1 - Length)
		System.out.println("No. of ways : " + tilingProblem(n));
	}
}
