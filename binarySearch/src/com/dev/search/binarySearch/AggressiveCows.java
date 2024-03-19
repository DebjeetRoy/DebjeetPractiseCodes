package com.dev.search.binarySearch;

import java.util.Arrays;

public class AggressiveCows {
	public static int aggressiveCows(int[] a, int k) { // TC: max(O(log(h) * n)+nlogn)(sorting)
		int l = 0, h = (int) 1e9;
		int ans = -1;
		Arrays.sort(a);

		while (l <= h) {
			int m = l + (h - l) / 2;
			if (isPossible(a, k, m)) {
				ans = m;
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return ans;
	}

	public static boolean isPossible(int[] a, int k, int dis) {
		int count = 1;
		int previous = a[0];

		for (int i = 1; i < a.length; i++) {
			if (a[i] - previous >= dis) {
				count++;
				previous = a[i];
			}
		}
		return count >= k;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 8, 9 };
		int k = 3;

		System.out.println(aggressiveCows(a, k));
	}
}
