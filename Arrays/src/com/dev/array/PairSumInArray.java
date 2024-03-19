package com.dev.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairSumInArray {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 1, 3, 2, 5, 5, 7, 8, 9, 10 };
		System.out.println(findPair(arr));
	}

	public static List<List<Integer>> findPair(int[] arr) {
		int n = arr.length;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}
		boolean found = false;
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (set.contains(arr[i] + arr[j])) {
					List<Integer> pair = new ArrayList<>();
					pair.add(arr[i]);
					pair.add(arr[j]);
					res.add(pair);
					found = true;
				}
			}
		}
		if (found) {
			res.sort((a, b) -> {
				int cmp = Integer.compare(a.get(0), b.get(0));
				if (cmp == 0) {
					return Integer.compare(a.get(1), b.get(1));
				}
				return cmp;
			});
		}
		return res;
	}
}
