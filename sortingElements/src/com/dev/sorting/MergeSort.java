package com.dev.sorting;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 4, 2, 1, 3, 9, 0 };
		System.out.println("Original Array :-");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		divide(arr, 0, arr.length - 1);

		// printing array
		System.out.println("Array values after Merge Sorting :-");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	// Divide and Conquer approach
	// TC = O(nlog(n))
	private static void divide(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;

		divide(arr, start, mid);// left part
		divide(arr, mid + 1, end); // right part

		conquer(arr, start, mid, end);
	}

	private static void conquer(int[] arr, int start, int mid, int end) {
		// Creating a temporary array to sort elements for left and right
		// and keep in it.
		int[] merged = new int[end - start + 1];
		int il = start;// iterator for left part
		int ir = mid + 1;// iterator for right part
		int x = 0; // Iterator for temporary array

		while (il <= mid && ir <= end) {
			if (arr[il] <= arr[ir]) {
				merged[x++] = arr[il++];
			} else {
				merged[x++] = arr[ir++];
			}
		}

		// left part
		while (il <= mid) {
			merged[x++] = arr[il++];
		}

		// right part
		while (ir <= end) {
			merged[x++] = arr[ir++];
		}

		// Copy elements of merged array to original array
		for (int i = 0, j = start; i < merged.length; i++, j++) {
			arr[j] = merged[i];
		}
	}
}
