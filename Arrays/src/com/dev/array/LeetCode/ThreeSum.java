package com.dev.array.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		int nums[] = { -5, 0, 2, 1, 3, 2, 5, 2, 4, 7 };
		// int target = 9;

		Arrays.sort(nums);
		List<List<Integer>> triplets = new ArrayList<>();
		System.out.println("3 Sum Problem -> ");

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			List<List<Integer>> twoSumList = TwoSum.twoSum2Pointer(nums, i + 1, -nums[i]);

			for (List<Integer> temp : twoSumList) {
				temp.add(0, nums[i]);
				triplets.add(temp);
			}
		}
		System.out.println(triplets);
	}
}
