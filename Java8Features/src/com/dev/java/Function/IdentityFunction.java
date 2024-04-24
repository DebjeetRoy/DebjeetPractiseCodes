package com.dev.java.Function;

import java.util.function.Function;

public class IdentityFunction {

	public static void main(String[] args) {
		String str = "Rajesh";

		Function<String, String> f = Function.identity();

		System.out.println(f.apply(str));
	}
}
