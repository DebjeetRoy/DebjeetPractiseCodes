package com.dev.sorting;

//Pivot and Partition
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 7, 4, 10, 9, 3, 6 };
		System.out.println("Original Array :-");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		quickSort(arr, 0, arr.length - 1);

		// printing array
		System.out.println("Array values after Quick Sorting :-");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/*
	 * Recursive quick sort approach TC : O(nlogn), worst case TC : O(n^2) SC :
	 * O(logn)
	 */
	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	/*
	 * Get the Pivot index after partition
	 */
	private static int partition(int[] arr, int l, int h) {
		int pivot = arr[l];
		int i = l;
		int j = h;

		while (i <= j) {
			while (i <= h && arr[i] <= pivot)
				i++;
			while (j >= 0 && arr[j] > pivot)
				j--;

			// swapping elements lesser than pivot to left and
			// larger than pivot to the right
			if (i < j)
				swap(arr, i, j);
		}
		// partition element(l) gets swapped with element at jth index
		swap(arr, l, j);
		return j;
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
