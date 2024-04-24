package com.dev.java.Function;

import java.util.function.Function;

public class NumberOfSpaces {

	public static void main(String[] args) {
		String[] arr = { "Debjeet is great", "Rajesh is a handsome guy", "Mahesh loves icecream" };

		Function<String, Integer> f = s -> s.length();
		Function<String, Integer> f1 = s -> s.replaceAll(" ", "").length();

		for (int i = 0; i < arr.length; i++) {
			// System.out.println(arr[i] + " -> " + f.andThen(f1));
		}
	}
}
