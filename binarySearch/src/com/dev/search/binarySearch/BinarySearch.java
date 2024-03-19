package com.dev.search.binarySearch;

public class BinarySearch {

	public static void main(String[] args) {
		final int[] values = { 2, 4, 6, 8, 10, 12, 14 };
		final int key = 2;
		final int position = binarySearch(values, key);

		System.out.println("Position of element " + key + " is " + position);
	}

	/*
	 * Binary Search
	 */
	private static int binarySearch(int[] values, int key) {
		int start = 0;
		int end = values.length - 1;

		while (start <= end) {
			final int mid = (start + (end - start) / 2);
			if (key == values[mid])
				return mid;
			else if (key < values[mid]) { // left
				end = mid - 1;
			} else { // right
				start = mid + 1;
			}
		}
		return -1;
	}
}
