package com.dev.array.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegersContaining1_2_3 {

	public static List<Integer> find123Digits(int[] arr, int n) {
		// You can code here
		List<Integer> al = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			int comp = Integer.MAX_VALUE;
			int[] sort = new int[10];
			int j = 0;
			while (num != 0) {
				int rem = num % 10;
				num /= 10;
				sort[j++] = rem;
			}
			Arrays.sort(sort);
//			if (sort == num) {
//				al.add(sort);
//			}
		}
		return al;

	}

	public static void main(String[] args) {

	}

}
