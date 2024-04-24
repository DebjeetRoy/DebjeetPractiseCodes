package com.dev.java8.Streams;

import java.util.stream.Stream;

public class DistinctValues {

	public static void main(String[] args) {
		Stream<Integer> arr = Stream.of(1, 4, 4, 5, 5, 2, 7, 7);

		arr.distinct().forEach(System.out::println);
		System.out.println();

		// Set<Integer> set = arr.collect(Collectors.toSet());
		// set.forEach(System.out::println);
	}
}
