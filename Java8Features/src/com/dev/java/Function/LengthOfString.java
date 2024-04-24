package com.dev.java.Function;

import java.util.function.Function;

public class LengthOfString {

	public static void main(String[] args) {

		String str = "Rajesh";

		Function<String, Integer> f = s -> s.length();

		System.out.println(f.apply(str));
	}
}
