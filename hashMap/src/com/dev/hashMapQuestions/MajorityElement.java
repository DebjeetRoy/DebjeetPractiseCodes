package com.dev.hashMapQuestions;

import java.util.HashMap;
import java.util.Map;

//Printing elements which occurs more than nums.length/4 times
public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			// map.put(nums[i], !map.containsKey(nums[i]) ? 1 : map.get(nums[i]) + 1);
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		for (Integer i : map.keySet()) {
			if (map.get(i) > nums.length / 4) {
				System.out.println(i + " occured " + map.get(i) + " times !! ");
			}
		}
	}
}
