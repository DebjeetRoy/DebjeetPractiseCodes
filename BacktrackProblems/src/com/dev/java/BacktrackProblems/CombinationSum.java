package com.dev.java.BacktrackProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] a = { 4, 3, 1, 2 };
		int target = 5;
		Arrays.sort(a);

		List<List<Integer>> ans = combinationSum(a, target);

		for (List<Integer> al : ans) {
			System.out.println(al);
		}
	}

	static List<List<Integer>> combinationSum(int[] a, int target) {
		List<List<Integer>> ans = new ArrayList<>();

		helperCombination(a, ans, 0, target, new ArrayList<Integer>());

		return ans;
	}

	static void helperCombination(int[] a, List<List<Integer>> ans, int index, int sum, List<Integer> curr) {
		// Base case
		if (sum == 0) {
			List<Integer> curCopy = new ArrayList<>(curr);
			ans.add(curCopy);
			return;
		}

		for (int i = index; i < a.length; i++) {
			System.out.println(i + "  " + index + "  " + sum);
			// first element should not be compared with itself so i>index is checked
			if (i > index && a[i] == a[i - 1])
				continue;
			curr.add(a[i]);
			helperCombination(a, ans, i + 1, sum - a[i], curr);
			curr.remove(curr.size() - 1); // Backtracking
		}
	}
}
