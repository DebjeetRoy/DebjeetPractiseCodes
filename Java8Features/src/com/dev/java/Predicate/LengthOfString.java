package com.dev.java.Predicate;

import java.util.function.Predicate;

public class LengthOfString {

	public static void main(String[] args) {

		Predicate<String> p = s -> s.charAt(0) == 'M';

		Predicate<String> p1 = s -> s.length() < 10;

		System.out.println(p.and(p1).test("Debjeet"));

		System.out.println(p.negate().test("Debjeet"));
	}
}
