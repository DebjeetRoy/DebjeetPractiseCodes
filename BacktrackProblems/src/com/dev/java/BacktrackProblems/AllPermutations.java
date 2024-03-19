package com.dev.java.BacktrackProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPermutations {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };

		List<List<Integer>> finalList = new ArrayList<>();
		List<List<Integer>> sortedListOfList = new ArrayList<>();
		finalList = permutation(a, 0, a.length - 1, finalList);

		List<Integer> sortedfinalList = new ArrayList<>();

		for (List<Integer> newList : finalList) {
			String str = new String();
			for (Integer i : newList) {
				str = str + i;
			}
			sortedfinalList.add(Integer.parseInt(str));
		}
		Collections.sort(sortedfinalList);
		sortedListOfList.add(sortedfinalList);

		List<String> orderList = new ArrayList<>();
		for (Integer i : sortedfinalList) {
			String st = String.join(",", String.valueOf(i));
			orderList.add(st);
		}

		System.out.println(sortedListOfList);
	}

	/*
	 * Backtracking algo for Permutation of a number
	 */
	private static List<List<Integer>> permutation(int[] a, int left, int right, List<List<Integer>> finalList) {
		// Base case
		if (left == right) {
			// printArray(a);
			List<Integer> al = new ArrayList<>();
			for (int i = 0; i < a.length; i++) {
				al.add(a[i]);
			}
			finalList.add(al);
		}

		// Algo
		for (int i = left; i <= right; i++) {
			swap(a, i, left);
			permutation(a, left + 1, right, finalList);
			swap(a, i, left);
		}
		return finalList;
	}

	// Swapping
	private static void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
}
