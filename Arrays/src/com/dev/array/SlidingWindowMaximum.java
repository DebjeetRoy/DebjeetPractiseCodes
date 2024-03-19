package com.dev.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {

	public static int[] slidingWindow(int[] arr, int k) {
		ArrayDeque<Integer> dq = new ArrayDeque<>();

		int i = 0;
		while (i < k) {
			while (!dq.isEmpty() && dq.getLast() < arr[i]) {
				dq.pollLast();
			}
			dq.offerLast(arr[i]);
			i++;
		}

		int n = arr.length;
		int[] ans = new int[n - k + 1];
		for (; i < n; i++) {
			ans[i - k] = dq.peekFirst();

			if (arr[i - k] == dq.peekFirst()) {
				dq.pollFirst();
			}
			while (!dq.isEmpty() && dq.getLast() < arr[i]) {
				dq.pollLast();
			}
			dq.offerLast(arr[i]);
		}
		ans[n - k] = dq.peekFirst();
		return ans;
	}

	public static List<Integer> firstNegativeInWindow(int[] a, int k) {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		List<Integer> al = new ArrayList<>();

		int i = 0;
		while (i < k) {
			if (a[i] < 0) {
				dq.offerLast(a[i]);
			}
			i++;
		}
		int n = a.length;
		int[] ans = new int[n - k + 1];
		for (; i < n; i++) {
			if (dq.isEmpty()) {
				ans[i - k] = 0;
			} else {
				ans[i - k] = dq.peekFirst();
			}
			if (!dq.isEmpty() && dq.peekFirst() == a[i - k]) {
				dq.pollFirst();
			}
			if (a[i] < 0) {
				dq.offerLast(a[i]);
			}
		}
		// Last window answer not added yet, adding below
		if (dq.isEmpty()) {
			ans[n - k] = 0;
		} else {
			ans[n - k] = dq.peekFirst();
		}

		for (int ele : ans) {
			al.add(ele);
		}

		return al;
	}

	public static void main(String[] args) {
		int a[] = { 2, 1, 4, 2, 6, 7, 4, 5, 9 };
		// int b[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int k = 3;
//		int[] res = slidingWindow(a, k);
//
//		for (int i : res) {
//			System.out.print(i + " ");
//		}
		int c = 3;
		int[] b = { 2, -3, -1, 4, -5, -3, 2, 1, 4 };
		List<Integer> resNeg = firstNegativeInWindow(b, c);

		for (int i : resNeg) {
			System.out.print(i + " ");
		}
	}
}
