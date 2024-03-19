package com.dev.array;

public class LargestInArray {
	public static void main(String[] args) {
		final int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 0;
		arr[2] = 9;
		arr[3] = 7;
		arr[4] = -3;

		System.out.println("Array elements are -> ");
		for (int i = 0; i <= arr.length - 1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] > max) {
				max = arr[j];
			} else if (arr[j] < min) {
				min = arr[j];
			}
		}
		System.out.println("Maximum element present in above array -> " + max);
		System.out.println("Minimum element present in above array -> " + min);
	}
}
