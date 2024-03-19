package com.dev.search.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class PeakElement {
	// Method to find the element which is greater than its neighbours using binary
	// search
	public static int findPeak(List<Integer> A) {
		// You Can Code Here
		int l = 0, r = A.size() - 1;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (A.get(m) < A.get(m + 1)) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		int[] A = { 4, 5, 6, 7, 8, 1 };

		List<Integer> al = new ArrayList<>();
		for (Integer a : A) {
			al.add(a);
		}

		System.out.println(findPeak(al));
	}
}
