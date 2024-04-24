package com.greedy.algo;

import java.util.Arrays;

public class MaxSumAbsDiffOfAnyPermutation {

	public static int maxSumAbsDiff(int[] a) {
		Arrays.sort(a);
		int sum = 0;
		int n = a.length;
		int[] arr = new int[a.length];

		// 1 2 4 6 9
		// 1 9 2 6 4

		int j = 0;
		int k = n - 1;

		// Getting permutation to get Max Sum Absolute Difference
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				arr[i] = a[j++];
			} else {
				arr[i] = a[k--];
			}
		}

		// Get Max Sum
		for (int i = 0; i < arr.length - 1; i++) {
			sum += Math.abs(arr[i + 1] - arr[i]);
		}
		sum += arr[arr.length - 1] - arr[0];

		for (int ele : arr) {
			System.out.print(ele + " ");
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 6, 9 };
		System.out.println("Max Sum = " + maxSumAbsDiff(arr));
	}
}
