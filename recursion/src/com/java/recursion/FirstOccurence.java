package com.java.recursion;

public class FirstOccurence {
	public static void main(String[] args) {

		int[] arr = { 8, 3, 6, 9, 5, 10, 2, 5, 3, 5 };
		int key = 5;
		int indexFirst = firstOccurence(arr, key, 0);
		int indexLast = lastOccurence(arr, key, arr.length - 1);

		if (indexFirst > -1) {
			System.out.println(key + " is found at index : " + indexFirst + " from first");
		}
		if (indexLast > -1) {
			System.out.println(key + " is found at index : " + indexLast + " from last");
		}
		if (indexFirst == -1 && indexLast == -1)
			System.out.println(key + " not present in array !!");

	}

	private static int firstOccurence(int[] arr, int key, int index) {
		// Base case
		if (index == arr.length) {
			return -1;
		}

		if (key == arr[index]) {
			return index;
		}
		return firstOccurence(arr, key, index + 1);
	}

	private static int lastOccurence(int[] arr, int key, int index) {
		// Base case
		if (index == arr.length) {
			System.out.println("Key Not Found !!");
			return -1;
		}

		if (key == arr[index]) {
			System.out.println("Key Found !!");
			return index;
		}
		return firstOccurence(arr, key, index - 1);
	}
}
