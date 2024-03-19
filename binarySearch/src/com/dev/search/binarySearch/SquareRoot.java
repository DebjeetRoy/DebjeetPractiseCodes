package com.dev.search.binarySearch;

public class SquareRoot {

	public static void main(String[] args) {
		int n = 15;

		System.out.println("Square root of " + n + " is " + squareRoot(n));
	}

	private static int squareRoot(int n) {
		int start = 1;
		int end = n;

		if (n == 0 || n == 1) {
			return n;
		}

		while (start <= end) {
			System.out.println(start + " " + end);
			int mid = start + (end - start) / 2;
			if (mid * mid == n)
				return mid;

			else if ((long) mid * mid > (long) n) {
				end = mid - 1;
			} else {
				// ans = mid;
				start = mid + 1;
			}
		}
		return end;
	}
}
