package com.java.recursion;

public class XtopowerN {
	public static void main(String[] args) {
		int base = 2;
		int power = 30;

		System.out.println(powerFunction(base, power));
	}

	private static int powerFunction(int base, int power) { // TC = O(n)
		if (power == 0) {
			return 1;
		}
		return base * powerFunction(base, power - 1);
	}
}
