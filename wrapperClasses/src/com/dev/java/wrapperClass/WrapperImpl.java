package com.dev.java.wrapperClass;

public class WrapperImpl {
	public static void main(String[] args) {

		int i = 5;
		Integer a = i; // Auto-Boxing
		Integer a1 = Integer.valueOf(i); // Boxing
		String s = "10";
		int m = a.intValue(); // unboxing
		int n = a; // Auto-unboxing
		int b = Integer.parseInt(s);

		System.out.println("Auto-Boxing = " + a);
		System.out.println("Boxing = " + a1);
		System.out.println("Unboxing = " + m);
		System.out.println("Auto-Unboxing(Integer) = " + n);
		System.out.println("Unboxing : String -> Integer = " + b);
	}
}
