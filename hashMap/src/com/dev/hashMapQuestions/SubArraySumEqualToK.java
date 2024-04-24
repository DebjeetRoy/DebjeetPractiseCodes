package com.dev.hashMapQuestions;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualToK {
	public static void main(String[] args) {

		// Key is Sum and Value is Count
		// sum(0,j) - sum(0,i-1) = sum(i,j)
		// sum(j)-sum(i) = k => sum(j) -k = sum(i)
		Map<Integer, Integer> map = new HashMap<>();
		int[] arr = { 10, 2, -2, -20, 10 };
		int k = -10;

		map.put(0, 1); // if total sum of elements becomes = K then sum(j)-K can become 0

		int sum = 0;
		int ans = 0;

		for (int i = 0; i < arr.length; i++) { // O(n)
			sum += arr[i];
			int remSum = sum - k;
			if (map.containsKey(remSum)) {
				ans += map.get(remSum);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		System.out.println("Count of subarrays with sum = " + k + " is " + ans);
	}
}
