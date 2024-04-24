package com.dev.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
		List<Integer> al = new ArrayList();
		for (int ele : nums) {
			al.add(ele);
		}

		List<Integer> res = al.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
		// return a.size();
		int k = 0;
		// int[] nums1 = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			nums[k++] = nums[i];
			if (k == res.size() - 1)
				break;
		}
		return nums.length;
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 2 };

		System.out.println(removeDuplicates(a));
		// removeDuplicates(a);
	}

}
