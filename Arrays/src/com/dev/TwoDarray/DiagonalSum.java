package com.dev.TwoDarray;

import java.util.Scanner;

public class DiagonalSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of rows :");
		int n = in.nextInt();

		System.out.println("Enter number of columns :");
		int m = in.nextInt();

		int[][] matrix = new int[n][m];
		n = matrix.length;
		m = matrix[0].length;

		MatrixRepresentation.printMatrixData(matrix, n, m, in);

		optimizedDiagonalSum(matrix, n);
	}

	// O(n^2)
	private static void diagonalSum(int[][] matrix, int n, int m) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((i == j) || (i + j == matrix.length - 1)) {
					sum += matrix[i][j];
				}
			}
		}
		System.out.println("Diagonal Sum is : " + sum);
	}

	public static void optimizedDiagonalSum(int[][] matrix, int n) {
		int sum = 0;
		// O(n+m)
		for (int i = 0; i < n; i++) {
			// primary Diagonal
			sum += matrix[i][i];

			// secondary diagonal condition to not print overlapping diag element.
			if (i != n - 1 - i) {
				sum += matrix[i][n - 1 - i];
			}
		}
		System.out.println("Diagonal Sum is : " + sum);
	}
}
