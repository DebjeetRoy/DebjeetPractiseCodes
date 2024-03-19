package com.dev.java.BacktrackProblems;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfGivenArray {
	public static void main(String[] args) {
		int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		List<List<Integer>> ans = subsequence(arr);

		for (List<Integer> al : ans) {
			System.out.println(al);
		}
	}

	static List<List<Integer>> subsequence(int[] a) {
		List<List<Integer>> ans = new ArrayList<>();
		helperSubsequence(a, ans, 0, new ArrayList<>());

		return ans;
	}

	private static void helperSubsequence(int[] a, List<List<Integer>> ans, int index, ArrayList<Integer> curr) {

		List<Integer> currCopy = new ArrayList<>(curr);
		ans.add(currCopy);

		for (int i = index; i < a.length; i++) {
			if (i > index && a[i] == a[i - 1]) {
				continue;
			}
			curr.add(a[i]);
			helperSubsequence(a, ans, i + 1, curr);
			curr.remove(curr.size() - 1);
		}
	}
}
