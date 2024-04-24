package com.java.recursion;

public class SortedArray {
	public static void main(String[] args) {

		int[] arr = { 1, 3, 2, 4, 5 };
		// int i = 0;
		System.out.println(isSortedArray(arr, arr.length));
	}

	private static boolean isSortedArray(int[] arr, int size) {
		if (size == 1) {
			return true;
		}
		if (arr[size - 2] > arr[size - 1]) {
			return false;
		}
		return isSortedArray(arr, size - 1);
	}
}
