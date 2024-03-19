package com.dev.search.binarySearch;

public class FirstOccurence {
	public static int firstOccurence(int[] arr, int key, int n) {
		int ans = -1;
		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + (end - start) / 2);
			if (arr[mid] < key) {
				start = mid + 1;
			} else if (arr[mid] > key) {
				end = mid - 1;
			} else {
				end = mid - 1;
				ans = mid;
			}
		}
		return ans;
	}

	public static int lastOccurence(int[] arr, int key, int n) {
		int ans = -1;
		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + (end - start) / 2);
			if (arr[mid] < key) {
				start = mid + 1;
			} else if (arr[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
				ans = mid;
			}
		}
		return ans;
	}

	public static int countOccurences(int[] arr, int n, int x) {
		// You can code here
		int countOfOccurences = 0;
		int firstOccurence = firstOccurence(arr, x, n);
		int lastOccurence = lastOccurence(arr, x, n);

		if (firstOccurence == -1 && lastOccurence == -1) {
			countOfOccurences = 0;
		} else {
			countOfOccurences = lastOccurence - firstOccurence + 1;
		}
		return countOfOccurences;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 2, 2, 2, 6 };
		int key = 2;
		int n = arr.length;

		System.out.println("First occurence of " + key + " is at index = " + firstOccurence(arr, key, n));
		System.out.println("Last occurence of " + key + " is at index = " + lastOccurence(arr, key, n));

		System.out.println("Count of occurences of " + key + " is: " + countOccurences(arr, n, key));
	}
}
