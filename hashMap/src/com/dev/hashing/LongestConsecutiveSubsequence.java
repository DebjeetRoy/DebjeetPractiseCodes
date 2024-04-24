package com.dev.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSubsequence {
	public static int longestConsecutive(int[] A) {
		// You can code here
		Arrays.sort(A);
		Map<Integer, Integer> map = new LinkedHashMap<>();
		List<Integer> al = new ArrayList<>();
		int lenCount = 1;

		if (A.length == 1)
			return 1;
		else if (A.length == 0)
			return 0;

		for (int i = 0; i < A.length; i++) {
			map.put(A[i], !map.containsKey(A[i]) ? 1 : map.get(A[i]) + 1);
		}

		for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
			al.add(mp.getKey());
		}

		int lenMax = Integer.MIN_VALUE;
		for (int i = 1; i < al.size(); i++) {
			if (al.get(i) - al.get(i - 1) == 1) {
				lenCount++;
			} else {
				lenMax = Math.max(lenCount, lenMax);
				lenCount = 1;
			}
		}
		return Math.max(lenCount, lenMax);
	}

	public static void main(String[] args) {
		int[] arr = { 55, 56, 54, 53, 52, 51, 1, 2, 3 };
		// 1 2 3 51 52 53 54 55 56
		System.out.println("Longest consecutive subsequence is : " + longestConsecutive(arr));
	}
}
