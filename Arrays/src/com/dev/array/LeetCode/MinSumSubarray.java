package com.dev.array.LeetCode;

public class MinSumSubarray {

	public static int minSumSubarray(int[] arr, int target) {
		int l = 0, r = 0;
		int currSum = 0;
		int minLength = Integer.MAX_VALUE;
		int n = arr.length;

		while (r < n) {
			currSum += arr[r];

			while (currSum >= target) {
				minLength = Math.min(minLength, r - l + 1);
				currSum -= arr[l];
				l++;
			}
			r++;
		}
		if (minLength == Integer.MAX_VALUE) {
			minLength = 0;
		}
		return minLength;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 6, 1, 7, 9 };
		int target = 11;

		System.out.println(minSumSubarray(arr, target));
	}
}
