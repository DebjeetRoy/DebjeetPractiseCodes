package com.dev.java.Supplier;

import java.util.function.Supplier;

public class RandomNameGenerator {

	public static void main(String[] args) {

		Supplier<String> s = () -> {
			String[] s1 = { "Dev", "Rajesh", "Suresh", "Raj" };
			int n = (int) (Math.random() * 4);
			return s1[n];
		};
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());
	}
}
