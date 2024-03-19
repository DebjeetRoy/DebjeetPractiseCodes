package com.dev.TwoDarray;

public class SearchInSortedMatrix {
	public static void main(String[] args) {
		int[][] matrix = { 
				{ 10, 20, 30, 40 }, 
				{ 15, 25, 35, 45 }, 
				{ 27, 29, 37, 48 }, 
				{ 32, 33, 39, 50 } };

		int key = 50;

		searchKey(matrix, key);
	}

	/*
	 * Search operation with staircase : O(nlogn) operations.
	 */
	private static boolean searchKey(int[][] matrix, int key) {
		int row = 0;
		int col = matrix.length - 1;

		while (row < matrix.length && col >= 0) {
			if (key == matrix[row][col]) {
				System.out.println("Key is found at (" + row + "," + col + ")");
				return true;
			} else if (key < matrix[row][col]) {
				col--;
			} else if (key > matrix[row][col]) {
				row++;
			}
		}
		return false;
	}
}
