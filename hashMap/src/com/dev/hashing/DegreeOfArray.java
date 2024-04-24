package com.dev.hashing;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {
	public static int findShortestSubArray(int[] nums) {
		// You can code here
		Map<Integer, Integer> map = new HashMap<>();
		int l = 0, r = 0;
		int ans = 0;

		while (r < nums.length) {
			if (!map.containsKey(nums[r]) || map.get(nums[r]) < l) {
				ans = Math.max(ans, r - l + 1);
			} else {
				l = map.get(nums[r]) + 1;
			}
			map.put(nums[r], r++);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 1 };
		System.out.println(findShortestSubArray(nums));
	}

}
