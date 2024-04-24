package com.dev.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 1, 3, 9, 0 };
		System.out.println("Original Array :-");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		selectionSort(arr);
	}

	// TC : O(n^2)
	private static void selectionSort(int[] arr) {
		// i-> for sorted
		// last element is already sorted so till length-1 we have to go.
		for (int i = 0; i < arr.length - 1; i++) {
			int smallest = i;
			// j-> start of unsorted array part
			for (int j = i + 1; j <= arr.length - 1; j++) {
				if (arr[j] < arr[smallest]) {
					// Finding the index of smallest element.
					smallest = j;
				}
			}
			// swap
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
		}

		// printing array
		System.out.println("Array values after Selection Sorting :-");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
