package com.dev.search.binarySearch;

public class SearchInSortedRotatedArray {
	public static int findInSortedRotatedArray(int[] arr, int n, int key) {
		int start = 0;
		int end = n - 1;
		int ans = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[start] <= arr[mid]) { // left part is sorted
				if (arr[start] <= key && arr[mid] >= key) {
					end = mid - 1;
					ans = mid;
				} else {
					start = mid + 1;
				}
			} else { // right part is sorted
				if (key > arr[mid] && key <= arr[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
					ans = mid;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 10, 13, 2, 2, 2, 4, 7, 7, 9 };
		int k = 9;
		int n = arr.length;

		System.out.println(findInSortedRotatedArray(arr, n, k));
	}
}
