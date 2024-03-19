package com.dev.TwoDarray;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int n = matrix.length; // Row
		int m = matrix[0].length; // Col

		// Printing
		System.out.println("Matrix => ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("Spiral Matrix => ");
		printSpiral(matrix, n, m);
	}

	private static void printSpiral(int[][] arr, int n, int m) {
		int startRow = 0;
		int endRow = arr.length - 1;
		int startCol = 0;
		int endCol = arr[0].length - 1;

		// Setting the boundary
		while (startRow <= endRow && startCol <= endCol) {

			// Top part
			for (int j = startCol; j <= endCol; j++) {
				System.out.print(arr[startRow][j] + " ");
			}

			// Right part
			for (int i = startRow + 1; i <= endRow; i++) {
				System.out.print(arr[i][endCol] + " ");
			}

			// bottom
			for (int j = endCol - 1; j >= startCol; j--) {
				if (startRow == endRow) {
					break;
				}
				System.out.print(arr[endRow][j] + " ");
			}

			// left
			for (int i = endRow - 1; i >= startRow + 1; i--) {
				if (startCol == endCol) {
					break;
				}
				System.out.print(arr[i][startCol] + " ");
			}

			startCol++;
			startRow++;
			endCol--;
			endRow--;
		}
	}
}
