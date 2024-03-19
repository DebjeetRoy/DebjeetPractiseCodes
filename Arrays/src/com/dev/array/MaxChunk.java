package com.dev.array;

public class MaxChunk {

	public static int maxChunk(int[] a) {
		if (a.length == 0)
			return 0;

		int chunk = 0;
		int i = 0;
		int maxSoFar = 0;

		while (i < a.length) {
			maxSoFar = Math.max(maxSoFar, a[i]);

			if (i == maxSoFar)
				chunk++;
			i++;
		}
		return chunk;
	}

	public static int maxChunk2(int[] a) {
		int n = a.length;
		int left[] = new int[n];
		int right[] = new int[n];

		left[0] = a[0];
		right[n - 1] = a[n - 1];

		// left array operation
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], a[i]);
		}

		// right array operation
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.min(right[i + 1], a[i]);
		}
		int count = 0;

		// Calculating max number of chunks to make array sorted
		for (int i = 0; i < n - 1; i++) {
			if (left[i] <= right[i + 1]) {
				count++;
			}
		}
		return count + 1;
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 4, 3 };
		int[] a1 = { 2, 0, 1, 5, 3, 4, 6 };
		int[] a2 = { 3, 4, 5, 2, 0, 1, 6 };

		System.out.println("-----Calculating no of chunks for array elements <= length of array");
		System.out.println(maxChunk(a));
		System.out.println(maxChunk(a1));
		System.out.println(maxChunk(a2));

		System.out.println("-----Calculating no of chunks for any array elements");
		// Extra space is required: O(N)
		int[] arr = { 3, 1, 4, 6, 5, 8, 15 };
		System.out.println(maxChunk2(arr));
	}
}
