package com.dev.sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 4, 2, 1, 3, 9, 0 };
		System.out.println("Original Array :-");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		bubbleSort(arr);
	}

	// TC : O(n^2)
	private static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				// swap
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		// printing sorted array
		System.out.println("Array values after Bubble Sorting :-");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
