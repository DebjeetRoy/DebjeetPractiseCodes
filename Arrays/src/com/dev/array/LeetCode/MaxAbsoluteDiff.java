package com.dev.array.LeetCode;

import java.util.Arrays;
import java.util.List;

public class MaxAbsoluteDiff {
	public static void main(String[] args) {
		int[] arr = { 12, 9, 8, 2, 11, 5, 4, 5 };

		System.out.println("Maximum Difference => ");
		System.out.println(maxDiff((Arrays.stream(arr).boxed().toList())));
	}

	public static int maxDiff(List<Integer> arr) {
		int len = arr.size();

		int aipi[] = new int[len];
		int aimi[] = new int[len];

		for (int i = 0; i < len; i++) {
			aipi[i] = arr.get(i) + i;// a[i] plus i
			aimi[i] = arr.get(i) - i;// a[i] minus i
		}

		int minaipi = Integer.MAX_VALUE;
		int maxaipi = Integer.MIN_VALUE;

		int minaimi = Integer.MAX_VALUE;
		int maxaimi = Integer.MIN_VALUE;

		for (int ele : aipi) {
			minaipi = Math.min(minaipi, ele);
			maxaipi = Math.max(maxaipi, ele);
		}

		for (int ele : aimi) {
			minaimi = Math.min(minaimi, ele);
			maxaimi = Math.max(maxaimi, ele);
		}

		int diffaipi = maxaipi - minaipi;
		int diffaimi = maxaimi - minaimi;

		return Math.max(diffaipi, diffaimi);
	}
}
