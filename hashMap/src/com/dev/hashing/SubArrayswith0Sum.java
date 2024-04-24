package com.dev.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubArrayswith0Sum {

	public static int zeroSumSubarray(int[] a) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		int cs = 0;

		int index = -1;
		ArrayList<Integer> al = new ArrayList<>();
		al.add(-1);
		int max = Integer.MIN_VALUE;
		int len = 0;

		map.put(0, al);
		for (int i = 0; i < a.length; i++) {
			cs += a[i];
			al.add(index + 1);

			if (!map.containsKey(cs)) {
				map.put(cs, al);
				len++;
			} else if (cs == 0) {
				map.get(cs).add(index);
				max = Math.max(max, len);
				len = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, -5, 2, 3, -3, 3 };

		System.out.println(zeroSumSubarray(arr));
	}
}
