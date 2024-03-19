package com.dev.TwoDarray;

import java.util.Scanner;

public class MatrixRepresentation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of rows :");
		int n = in.nextInt();

		System.out.println("Enter number of columns :");
		int m = in.nextInt();

		int[][] matrix = new int[n][m];
		n = matrix.length;
		m = matrix[0].length;
		int key = 5;

		printMatrixData(matrix, n, m, in); // n - Rows, m - Columns
		searchKey(matrix, n, m, key);
	}

	public static void printMatrixData(int[][] matrix, int n, int m, Scanner in) {
		System.out.println("Enter elements of " + n + "X" + m + " Array matrix : ");

		// Fetching inputs from user
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = in.nextInt();
			}
		}

		// Printing
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean searchKey(int[][] matrix, int n, int m, int key) {
		System.out.println("Searching for Key -> " + key);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == key) {
					System.out.println("Key " + key + " is found at (" + i + "," + j + ")");
					return true;
				}
			}
		}
		return false;
	}
}
