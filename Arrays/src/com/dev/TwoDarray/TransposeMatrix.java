package com.dev.TwoDarray;

public class TransposeMatrix {
	public static int[][] transpose(int[][] arr) {

		int transpose[][] = new int[arr.length][arr[0].length];
		// TRANSPOSE LOGIC
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i] == arr[j]) {
					transpose[i][j] = arr[i][j];
				} else {
					transpose[i][j] = arr[j][i];
				}
			}
		}
		return transpose;
	}

	public static void main(String[] args) {
		int[][] matrix = { 
				{ 10, 20, 30, 40 }, 
				{ 15, 25, 35, 45 }, 
				{ 27, 29, 37, 48 }, 
				{ 32, 33, 39, 50 } };
		
		int n = matrix.length;
		int m = matrix[0].length;

		System.out.println("Original Matrix => ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		if (n != m) {
			System.out.println("Transpose is not possible as given matrix is not a square matrix");
		} else {
			System.out.println("Transpose of given Matrix => ");
			int[][] transposedMatrix = transpose(matrix);

			printTranpose(transposedMatrix);
		}
	}

	// Printing transpose of a given matrix
	private static void printTranpose(int[][] transposedMatrix) {
		for (int i = 0; i < transposedMatrix.length; i++) {
			for (int j = 0; j < transposedMatrix[0].length; j++) {
				System.out.print(transposedMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
