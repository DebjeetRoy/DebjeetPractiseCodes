package com.dev.array.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinDifference {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 5 };

		System.out.println("Elements paird with minimum difference => " + minimumDiff(a));
	}

	// TC : O(nlogn)
	public static List<List<Integer>> minimumDiff(int a[]) {
		List<List<Integer>> ans = new ArrayList<>();
		int minDiff = Integer.MAX_VALUE;
		Arrays.sort(a);

		// Finding the minimum difference number
		for (int i = 1; i < a.length; i++) {
			minDiff = Math.min(minDiff, a[i] - a[i - 1]);
		}

		// Checking the elements with same difference in pairs
		for (int i = 1; i < a.length; i++) {
			if (a[i] - a[i - 1] == minDiff) {
				List<Integer> al = new ArrayList<>();
				al.add(a[i]);
				al.add(a[i - 1]);
				ans.add(al);
			}
		}
		return ans;
	}
}
