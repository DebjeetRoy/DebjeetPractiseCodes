package com.dev.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithMedianK {
	public static int countSubarrays(int[] nums, int k) {
		// You can code here
		final int kIndex = find(nums, k);
		if (kIndex == 0)
			return 0;
		int ans = 0;
		Map<Integer, Integer> count = new HashMap<>();

		for (int i = kIndex, balance = 0; i >= 0; i--) {
			if (nums[i] < k)
				--balance;
			else if (nums[i] > k)
				++balance;
			count.merge(balance, 1, Integer::sum);
		}

		for (int i = kIndex, balance = 0; i < nums.length; i++) {
			if (nums[i] < k)
				--balance;
			else if (nums[i] > k)
				++balance;
			// The subarray that has balance == 0 or 1 having median equal to k.
			// So, add count[0 - balance] and count[1 - balance] to the `ans`.
			ans += count.getOrDefault(-balance, 0) + count.getOrDefault(1 - balance, 0);
		}

		return ans;
	}

	private static int find(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == k)
				return i;
		}
		return 0;
	}

	public int countSubarraysWay2(int[] nums, int k) {
		// You can code here
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int ans = 0, sum = 0;
		boolean flag = false;
		// 3 2 1 4 5
		// sum=-3
		for (int i : nums) {
			if (i < k)
				--sum;
			else if (i > k)
				++sum;
			else {
				flag = true;
			}
			if (flag) {
				ans += map.getOrDefault(sum, 0) + map.getOrDefault(sum - 1, 0);
			} else {
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}

		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 4, 5 };
		int k = 4;

		System.out.println("Count of Subarrays with median = " + k + " is ");
		System.out.println(countSubarrays(nums, k));
	}
}
