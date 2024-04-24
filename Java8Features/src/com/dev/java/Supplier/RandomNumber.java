package com.dev.java.Supplier;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class RandomNumber {
	public static void main(String[] args) {
		Supplier<Integer> supply = () -> (int) (Math.random() * 100);

		System.out.println(supply.get());
		IntStream.range(1, 10).limit(10).forEach(System.out::print);
	}
}
