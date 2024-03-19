package com.dev.search.binarySearch;

import java.math.BigDecimal;
import java.util.Arrays;

public class MedianOfTwoSortedArrays {

	public static double medianOf2SortedArrays(int[] a, int[] b) {
		int n1 = a.length;
		int n2 = b.length;
		int n = n1 + n2;
		int left = (n + 1) / 2;

		if (n1 > n2)
			return medianOf2SortedArrays(b, a);

		int l = 0, r = n1;

		while (l <= r) {
			int m1 = (l + r) / 2;
			int m2 = left - m1;

			int l1 = m1 <= 0 ? Integer.MIN_VALUE : a[m1 - 1];
			int l2 = m2 <= 0 ? Integer.MIN_VALUE : b[m2 - 1];

			int r1 = m1 >= n1 ? Integer.MAX_VALUE : a[m1];
			int r2 = m2 >= n2 ? Integer.MAX_VALUE : b[m2];

			if (l1 <= r2 && l2 <= r1) {
				if (n % 2 == 0) {
					return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
				} else {
					return Math.max(l1, l2);
				}
			} else if (l1 > r2) {
				r = m1 - 1;
			} else if (l2 > r1) {
				l = m1 + 1;
			}
		}
		return -1;
	}

	public static double median(int[] a, int[] b) {
		int[] finalArray = new int[a.length + b.length];

		int k = 0;
		for (int i : a) {
			finalArray[k++] = i;
		}
		for (int j : b) {
			finalArray[k++] = j;
		}
		Arrays.sort(finalArray);

		BigDecimal median = BigDecimal.valueOf(0);
		int mid = (0 + finalArray.length) / 2;
		if (finalArray.length % 2 == 0) {
			BigDecimal add = (BigDecimal.valueOf(Double.parseDouble(String.valueOf(finalArray[mid])))
					.add(BigDecimal.valueOf(Double.parseDouble(String.valueOf(finalArray[mid - 1])))));

			median = add.divide(BigDecimal.valueOf(2));

		} else if (finalArray.length % 2 != 0) {
			median = BigDecimal.valueOf(Double.parseDouble(String.valueOf(finalArray[mid])));
		}

		return Double.parseDouble(median.toString());
	}

	public static void main(String[] args) {
		int[] a = { 3, 5, 6 };
		int[] b = { 2, 4, 10, 12 };

		System.out.println("Median : " + median(a, b));
		System.out.println("Median : " + medianOf2SortedArrays(a, b));
	}
}
