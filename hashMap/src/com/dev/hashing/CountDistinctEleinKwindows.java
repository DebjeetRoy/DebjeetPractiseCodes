package com.dev.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctEleinKwindows {
	// TC : O(N)
	// SC : O(K)
	static int[] countDistinctinKwindows(int[] a, int k) {
		int n = a.length;
		Map<Integer, Integer> map = new HashMap<>();
		int[] ans = new int[n - k + 1];

		for (int i = 0; i < k; i++) {
			map.put(a[i], !map.containsKey(a[i]) ? 1 : map.get(a[i]) + 1);
		}

		for (int i = k; i < n; i++) {
			ans[i - k] = map.size();
			int leftIndex = i - k;
			int rightIndex = i;

			int freqLeft = map.get(a[leftIndex]);

			if (freqLeft == 1) {
				map.remove(a[leftIndex]);
			} else {
				map.put(a[leftIndex], freqLeft - 1);
			}

			map.put(a[rightIndex], map.containsKey(a[rightIndex]) ? (map.get(a[rightIndex]) + 1) : 1);
		}
		ans[n - k] = map.size();
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
		int K = 4;

		int[] al = countDistinctinKwindows(arr, K);

		System.out.println("Number of distinct elements in window of " + K + " from above array is : ");
		for (int ele : al) {
			System.out.print(ele + " ");
		}
	}
}
