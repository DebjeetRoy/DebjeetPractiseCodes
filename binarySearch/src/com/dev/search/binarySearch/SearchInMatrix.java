package com.dev.search.binarySearch;

public class SearchInMatrix {

	// TC = O(n^2)
	public int searchMatrix(int[][] A, int B) {
		// You can code here
		int len = 0;

		// Counting the size;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				len++;
			}
		}
		int[] arr = new int[len];
		int k = 0;

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				int num = A[i][j];
				arr[k++] = num;
			}
		}

		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == B) {
				return 1;
			} else if (B < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return 0;
	}

	// TC = O(logn)
	public static int searchMatrixOptimized(int[][] A, int B) {
		int rows = A.length;
		int cols = A[0].length;
		int left = 0;
		int right = rows * cols - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int element = A[mid / cols][mid % cols];

			if (element == B) {
				return 1; // Found B in the matrix.
			} else if (element < B) {
				left = mid + 1; // Search in the right half.
			} else {
				right = mid - 1; // Search in the left half.
			}
		}

		return 0; // B is not in the matrix.
	}

	public static void main(String[] args) {
		int[][] arr = { { 2, 4, 9, 11 }, { 13, 17, 19, 111 }, { 222, 224, 777, 888 } };
		System.out.println(searchMatrixOptimized(arr, 19));
	}
}
