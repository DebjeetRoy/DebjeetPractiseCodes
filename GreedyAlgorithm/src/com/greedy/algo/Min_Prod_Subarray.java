package com.greedy.algo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Min_Prod_Subarray {
	public static int minProductSubset(int a[], int n) {
		// You can code here
		if (n == 1)
			return a[0];

		// Find count of negative numbers,
		// count of zeros, maximum valued
		// negative number, minimum valued
		// positive number and product of
		// non-zero numbers
		int negmax = Integer.MIN_VALUE;
		int posmin = Integer.MAX_VALUE;
		int count_neg = 0, count_zero = 0;
		int product = 1;

		for (int i = 0; i < n; i++) {

			// if number is zero,count it
			// but dont multiply
			if (a[i] == 0) {
				count_zero++;
				continue;
			}

			// count the negative numbers
			// and find the max negative number
			if (a[i] < 0) {
				count_neg++;
				negmax = Math.max(negmax, a[i]);
			}

			// find the minimum positive number
			if (a[i] > 0 && a[i] < posmin)
				posmin = a[i];

			product *= a[i];
		}

		// if there are all zeroes
		// or zero is present but no
		// negative number is present
		if (count_zero == n || (count_neg == 0 && count_zero > 0))
			return 0;

		// If there are all positive
		if (count_neg == 0)
			return posmin;

		// If there are even number except
		// zero of negative numbers
		if (count_neg % 2 == 0 && count_neg != 0) {

			// Otherwise result is product of
			// all non-zeros divided by maximum
			// valued negative.
			product = product / negmax;
		}
		return product;
	}

	public static char nonRepeatingCharacter(String s) {
		// You can code here
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map.put(ch, map.get(ch) == 0 ? 1 : map.get(ch) + 1);
		}

		for (Map.Entry<Character, Integer> mp : map.entrySet()) {
			if (mp.getValue() == 1) {
				return mp.getKey().charValue();
			}
		}
		return '#';
	}

	public static void main(String[] args) {
		int[] a = { -1, -1, -2, 4, 3 };
		int n = 5;

		System.out.println("Minimum Subset Product = " + minProductSubset(a, n));
	}
}
