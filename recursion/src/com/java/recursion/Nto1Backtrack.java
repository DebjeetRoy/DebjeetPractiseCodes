package com.java.recursion;

public class Nto1Backtrack {
	public static void printNto1(int i, int N) {
		if (i < 1) {
			return;
		}
		System.out.println(i);
		printNto1(i - 1, N);
	}

	public static void main(String[] args) {
		int N = 4;
		printNto1(4, N);
	}
}
