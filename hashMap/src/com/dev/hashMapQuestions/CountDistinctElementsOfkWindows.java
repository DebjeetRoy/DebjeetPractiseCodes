package com.dev.hashMapQuestions;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctElementsOfkWindows {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 1, 3, 1, 1, 3 };
		int k = 4;

		kWindows(arr, k);
	}

	private static void kWindows(int[] arr, int k) {
		for (int i = 0; i < arr.length; i++) {
			Set<Integer> set = new HashSet<>();
			int limit = k + i - 1;
			if (limit < arr.length) {
				for (int j = i; j <= limit; j++) {
					set.add(arr[j]);
				}
			} else
				break;
			System.out.println((i) + " Window -> " + set.size());
		}
	}
}
