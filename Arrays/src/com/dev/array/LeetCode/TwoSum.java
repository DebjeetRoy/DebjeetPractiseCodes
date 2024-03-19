package com.dev.array.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSum {
	public static void main(String[] args) {
		int nums[] = { -5, 0, 2, 1, 3, 2, 5, 2, 4, 7 };
		int target = 5;

		System.out.println("2 Sum using brute Force approach -> ");
		System.out.println(twoSum(nums, target));

		System.out.println("2 Sum using 2 Pointer approach -> ");
		Arrays.sort(nums);
		System.out.println(twoSum2Pointer(nums, 0, target));
	}

	/*
	 * Brute-force approach TC = O(n^2)
	 */
	public static List<List<Integer>> twoSum(int[] nums, int target) {
		Set<Set<Integer>> ans = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == (target - nums[j])) {
					Set<Integer> res = new HashSet<>();
					res.add(nums[i]);
					res.add(nums[j]);
					ans.add(res);
				}
			}
		}
		List<List<Integer>> al = new ArrayList<>();
		for (Set<Integer> set : ans) {
			List<Integer> res = new ArrayList<>();
			for (Integer ele : set) {
				res.add(ele);
			}
			al.add(res);
		}
		return al;
	}

	/*
	 * 2 pointer approach
	 */
	public static List<List<Integer>> twoSum2Pointer(int[] arr, int start, int k) {
		int st = start;
		int end = arr.length - 1;
		List<List<Integer>> ans = new ArrayList<>();

		while (st < end) {
			if (st > start && arr[st] == arr[st - 1]) {
				st++;
				continue;
			}
			if (end < arr.length - 1 && arr[end] == arr[end + 1]) {
				end--;
				continue;
			}
			if (arr[st] + arr[end] < k) {
				st++;
			} else if (arr[st] + arr[end] > k) {
				end--;
			} else {
				List<Integer> al = new ArrayList<>();
				al.add(arr[st]);
				al.add(arr[end]);
				// al.contains(arr[st]);
				ans.add(al);
				st++;
				end--;
			}
		}
		return ans;
	}
}
