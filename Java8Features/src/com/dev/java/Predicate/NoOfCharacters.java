package com.dev.java.Predicate;

import java.util.function.Predicate;

public class NoOfCharacters {

	public static void main(String[] args) {

		Predicate<String> len = l -> l.length() < 10;

		System.out.println(len.test("Debjeet"));
	}
}
