package com.greedy.algo;

public class WineBuyingSelling {
	public static long wineSelling(int a[], int n) {
		// You can code here
		int b = 0, s = 0;
		long ans = 0l;
		while (b < n && s < n) {
			// Getting buyer count
			while (a[b] <= 0) {
				b++;
				if (b == n) {
					return ans;
				}
			}

			// Getting seller count
			while (a[s] >= 0) {
				s++;
				if (s == n)
					return ans;
			}

			// If buyer > seller
			if (Math.abs(a[b]) >= Math.abs(a[s])) {
				ans += Math.abs(b - s) * Math.abs(a[s]);
				a[b] += a[s];
				a[s] = 0;
			} else {
				// If seller > buyer
				ans += Math.abs(b - s) * a[b];
				a[s] += a[b];
				a[b] = 0;
			}
		}

		return ans;
//-4 1 1 -3 5

	}

	public static void main(String[] args) {
		int n = 5;
		int[] a = { 5, -4, 1, -3, 1 };

		System.out.println(wineSelling(a, n));
	}
}
