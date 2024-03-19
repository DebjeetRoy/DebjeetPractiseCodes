package com.dev.search.binarySearch;

public class UpperAndLowerBound {

	public static int upperBound(int[] arr, int n, int key) {
		int start = 0;
		int end = n - 1;
		int ans = n;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (key == arr[mid]) {
				return mid;
			}

			if (key < arr[mid]) {
				ans = mid;
				end = mid - 1;
			} else if (key >= arr[mid]) {
				start = mid + 1;
			}
		}
		return ans;
	}

	public static int lowerBound(int[] arr, int n, int key) {
		int start = 0;
		int end = n - 1;
		int ans = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (key <= arr[mid]) {
				end = mid - 1;
			} else if (key > arr[mid]) {
				ans = mid;
				start = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 5, 7, 9 };
		int n = arr.length;
		int k = 0;
		System.out.println("Next greater element's index than " + k + " is at index " + upperBound(arr, n, k));

		System.out.println("Next smaller element's index than " + k + " is at index " + lowerBound(arr, n, k));
	}
}
