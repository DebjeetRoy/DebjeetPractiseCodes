package com.dev.array.LeetCode;

import java.util.Arrays;
import java.util.Collections;

public class MakeMatrixEqual {

	public static void main(String[] args) {
		int[][] a = { { 3, 63, 42 }, { 18, 12, 12 }, { 15, 21, 18 }, { 33, 84, 24 } };

		int k = 3; // number of operations required to convert
		System.out.println(
				"Minimum No of operations requried to make all elements of matrix same is " + makeMatrixEqual(a, k));
	}

	public static int makeMatrixEqual(int[][] a, int k) {
		int n = a.length;
		if (n == 0)
			return 0;

		int m = a[0].length;
		int total = n * m;

		int[] b = new int[total];

		// Converting 2D array to 1D array for median calculation
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				b[i * m + j] = a[i][j];
			}
		}
		Arrays.sort(b);
		int median = b[total / 2];
		Collections.emptyList();

//		for (int i = 0; i < total; i++) {
//			System.out.println(i + " " + b[i] + " " + makeMatrixEqualHelper(b, b[i], k));
//		}
		return makeMatrixEqualHelper(b, median, k);
	}

	public static int makeMatrixEqualHelper(int b[], int m, int k) {
		int count = 0;

		for (int i = 0; i < b.length; i++) {
			count += Math.abs(b[i] - m) / k;
		}
		return count;
	}
}
