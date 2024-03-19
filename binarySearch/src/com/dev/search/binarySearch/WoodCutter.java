package com.dev.search.binarySearch;

public class WoodCutter {

	public static int woodCutter(int[] arr, int k) {
		int l = 0, h = (int) 1e9;

		while (l <= h) {
			int m = l + (h - l) / 2;
			int totalWoodLength = getWoodAtCut(arr, m);

			if (totalWoodLength == k)
				return m;

			if (totalWoodLength > k) {
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return -1;
	}

	// Getting length of woods cut
	public static int getWoodAtCut(int[] a, int cut) {
		int ans = 0;

		for (int element : a) {
			ans += element > cut ? element - cut : 0;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] a = { 1, 7, 6, 3, 4, 7 };
		int k = 8;

		System.out.println(woodCutter(a, k));
	}
}
