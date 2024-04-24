package com.dev.hashSet;

import java.util.HashSet;

public class TwoSumHS {
	public static boolean hasArrayTwoCandidates(int arr[], int n, int x) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if ((!hs.isEmpty()) && hs.contains(x - arr[i])) {
				return true;
			} else {
				hs.add(arr[i]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 9, 4 };
		int sum = 8;

		System.out.println(hasArrayTwoCandidates(arr, arr.length, sum));
	}
}
