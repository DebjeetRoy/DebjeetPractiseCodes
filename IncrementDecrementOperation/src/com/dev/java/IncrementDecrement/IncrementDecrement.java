package com.dev.java.IncrementDecrement;

public class IncrementDecrement {

	public static void main(String[] args) {
		int a = 2, b = 5;

		// int f = ++a + 2;
		// int f1 = ++b + ++b;
		// int f2 = ++a * 7 + 2 - b--;
		// int f3 = (++a) + (--b) + (--a) + (b++);
		// int f4 = (a--) * (++a) + (b++) * (--b);
		int f5 = (a++) / (--b) * (--a) + (b++);

		// System.out.println(f);
		// System.out.println(f1);
		// System.out.println(f2);
		// System.out.println(f3);
		// System.out.println(f4);
		System.out.println(f5);
	}
}
