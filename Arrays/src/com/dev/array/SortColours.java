package com.dev.array;

public class SortColours {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 0, 2, 1, 0, 2, 1, 0, 0 };

		sortArray(arr);
	}

	// Sorting in O(n) TC
	public static void sortArray(int[] arr) {
		int low = 0, mid = 0;
		int high = arr.length - 1;

		while (mid <= high) {
			if (arr[mid] == 0) {
				arr[mid] = arr[low];
				arr[low] = 0;
				low++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else if (arr[mid] == 2) {
				arr[mid] = arr[high];
				arr[high] = 2;
				high--;
			}
		}
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}

}
