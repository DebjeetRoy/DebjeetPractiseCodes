package com.dev.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 1, 3, 9, 0 };
		System.out.println("Original Array :-");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		insertionSort(arr);
	}

	// TC : O(n^2)
	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];
			int prev = i - 1;

			// Finding correct position to insert element.
			while (prev >= 0 && arr[prev] > current) {
				arr[prev + 1] = arr[prev]; // Comparing and pusing element to next index
											// as given number is smaller than other.
				prev--;
			}
			// insertion
			arr[prev + 1] = current;
		}
		// printing array
		System.out.println("Array values after Insertion Sorting :-");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
