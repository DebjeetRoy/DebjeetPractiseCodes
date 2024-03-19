package com.dev.array;

import java.util.Arrays;

public class WaveArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		// waveArrayNonLexographic(arr);

		waveArrayLexographic(arr);

		for (int element : arr) {
			System.out.print(element + " ");
		}
	}

	public static void waveArrayLexographic(int[] arr) {
		Arrays.sort(arr); // O(nlogn)
		int n = arr.length;

		for (int i = 1; i < n; i += 2) {
			swap(arr, i, i - 1);
		}
	}

	// O(n)
	public static void waveArrayNonLexographic(int[] arr) {
		int n = arr.length;

		// Element should be smaller than (i-1) and (i+1)th position
		for (int i = 1; i < n; i += 2) {
			if (arr[i] > arr[i - 1]) {
				swap(arr, i, i - 1);
			}
			if (i < n - 1 && arr[i] > arr[i + 1]) {
				swap(arr, i, i + 1);
			}
		}
	}

	// Swap function
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
