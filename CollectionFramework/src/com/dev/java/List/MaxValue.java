package com.dev.java.List;

import java.util.ArrayList;
import java.util.List;

public class MaxValue {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 6, 7, 8, 9 };

		List<Integer> al = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			al.add(arr[i]);
		}
		maxValue(al);
	}

	private static void maxValue(List<Integer> al) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= al.size() - 1; i++) {
			if (al.get(i) > max) {
				max = al.get(i);
			}
		}
		System.out.println("Max value in arrayList is -> " + max);
	}
}
