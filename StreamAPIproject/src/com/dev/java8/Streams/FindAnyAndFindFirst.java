package com.dev.java8.Streams;

import java.util.Arrays;

public class FindAnyAndFindFirst {

	public static void main(String[] args) {

		Integer[] numbers = { 4, 2, 6, 7, 3, 8 };

		int any = Arrays.stream(numbers).filter(x -> x < 7).findAny().get();
		System.out.println("Any value less than 7 is " + any);

		int first = Arrays.stream(numbers).filter(x -> x < 7).findFirst().get();
		System.out.println("First value less than 7 is " + first);
	}
}
