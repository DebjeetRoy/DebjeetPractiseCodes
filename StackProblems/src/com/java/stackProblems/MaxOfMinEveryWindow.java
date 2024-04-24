package com.java.stackProblems;

import java.util.Arrays;

public class MaxOfMinEveryWindow {
	public static int[] maxMinArray(int[] a) {
		int n = a.length;
		int left[] = SmallerElementOnLeft.smallerElementOnLeft(a);
		int right[] = SmallerElementOnRight.smallerOnRight(a);

		int[] ans = new int[n];
		Arrays.fill(ans, Integer.MIN_VALUE);

		for (int i = 0; i < n; i++) {
			int wl = right[i] - left[i] - 1;
			ans[wl - 1] = Math.max(ans[wl - 1], a[i]);
		}

		for (int i = n - 2; i >= 0; i--) {
			ans[i] = Math.max(ans[i], ans[i + 1]);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] a = { 1, 6, 4, 10, 2, 4 };
		int[] ans = maxMinArray(a);

		for (int ele : ans) {
			System.out.print(ele + " ");
		}
	}
}
