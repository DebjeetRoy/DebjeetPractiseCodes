package com.dev.array;

public class LinearSearch {

	public static void main(String[] args) {
		final int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 0;
		arr[2] = 9;
		arr[3] = 7;
		arr[4] = -3;

		final int key = 7;
		int count = 0;
		int position = 0;
		for (int index = 0; index < arr.length; index++) {
			if (key == arr[index]) {
				count++;
				position = index;
				break;
			}
		}
		if (count == 0) {
			System.out.println(key + " is not present in this array !!");
		} else {
			System.out.println(key + " is present at position " + position);
		}
	}
}
