package com.java.recursion;

public class XtopowerN2Optimized {
	public static void main(String[] args) {
		int base = 2;
		int power = 10;

		System.out.println(powerFunction(base, power));
	}

	private static double powerFunction(int base, int power) { // TC = O(log(n))
		if (power == 0) {
			return 1;
		}
		double hpower = powerFunction(base, power / 2);
		double hpowerSq = hpower * hpower;

		if (power % 2 == 0) {
			return hpowerSq;
		}

		return base * hpowerSq;
	}
}
