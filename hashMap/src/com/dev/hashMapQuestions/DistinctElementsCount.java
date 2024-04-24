package com.dev.hashMapQuestions;

import java.util.HashMap;
import java.util.Map;

public class DistinctElementsCount {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 1, 4, 2, 3, 2, 4, 3, 4 };

		countDistinct(arr);
	}

	private static void countDistinct(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		System.out.println("Duplicate Elements -> ");
		for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
			if (mp.getValue() > 1) {
				System.out.println(mp.getKey() + " occured " + mp.getValue() + " times.");
			}
		}
	}
}
