package com.javs.dev.PriorityQueue;

public class CheckForBinaryHeap {

	// Leaf node starts at n/2
	public static boolean isBinaryMaxHeap(int[] arr, int n) {
		return isHelper(arr, n, 0);
	}

	private static boolean isHelper(int[] arr, int n, int i) {
		if (i >= n / 2)
			return true;

		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (arr[i] >= arr[left] && isHelper(arr, n, left)) {
			if (right < n) {
				return arr[i] >= arr[right] && isHelper(arr, n, right);
			} else
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] a = { 90, 15, 10, 7, 12, 2 };
		int n = a.length;

		boolean isBinaryHeap = isBinaryMaxHeap(a, n);
		if (isBinaryHeap)
			System.out.println("Its a Binary Heap");
		else
			System.out.println("It's not");
	}
}
