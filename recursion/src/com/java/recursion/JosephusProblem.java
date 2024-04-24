package com.java.recursion;

public class JosephusProblem {
	public static void main(String[] args) {
		int n = 3;
		int k = 2;

		System.out.println(josephus(n, k));
	}

	private static int josephus(int n, int k) {
		if (n == 1)
			return 0;
		// Mapping with sub-problems => (sub + k) % n;
		return (josephus(n - 1, k) + k) % n;
	}
}
