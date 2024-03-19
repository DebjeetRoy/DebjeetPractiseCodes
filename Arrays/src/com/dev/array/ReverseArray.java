package com.dev.array;

public class ReverseArray {
	public static void main(String[] args) {
		final int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 0;
		arr[2] = 9;
		arr[3] = 7;
		arr[4] = -3;

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i] + " ");
		}
	}
}
