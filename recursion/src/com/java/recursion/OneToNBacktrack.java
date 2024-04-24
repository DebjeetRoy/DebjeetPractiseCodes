package com.java.recursion;

public class OneToNBacktrack {
	public static void print1ToN(int i, int N) {
		if (i < 1) {
			return;
		}
		print1ToN(i - 1, N);
		System.out.println(i);
	}

	public static void main(String[] args) {
		int N = 4;
		print1ToN(4, N);
	}
}
