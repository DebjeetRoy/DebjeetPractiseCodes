package com.dev.java.Function;

import java.util.function.Function;

public class FunctionChaining {

	public static void main(String[] args) {

		int[] arr = { 4, 1, 6, 8, 4, 8 };

		// add
		Function<Integer, Integer> add = f -> f + f + f;

		// multiply
		Function<Integer, Integer> mult = f -> f * f;

		System.out.println("Values after andThen() operation");

		// andThen()
		for (int i = 0; i < arr.length; i++) {
			System.out.println(add.andThen(mult).apply(arr[i]));
		}
		System.out.println();

		System.out.println("Values after compose() operation");
		// compose()
		for (int i = 0; i < arr.length; i++) {
			System.out.println(add.compose(mult).apply(arr[i]));
		}
	}
}
