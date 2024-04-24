package com.dev.java8.Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinMax {
	public static void main(String[] args) {

		Stream<Double> doubleArr = Stream.of(1d, 4d, 2d);

		Stream<Integer> intArr = Stream.of(1, 4, 2);

		Optional<Integer> optional = intArr.max((num1, num2) -> num1 - num2);

		if (optional.isPresent()) {
			// System.out.println(optional.get());
		}
		List<Integer> sl = new ArrayList<>();
		sl.add(1);
		sl.add(4);
		sl.add(2);
		sl.add(0);
		sl.add(-3);

		// System.out.println(sl.stream().max((num1, num2) -> num1 - num2).get());
		// System.out.println(sl.stream().mapToDouble(Double::valueOf).max().getAsDouble());
		System.out.println(sl.stream().collect(Collectors.maxBy(Comparator.comparing(Double::valueOf))).get());
		// Print maximum without using Comparator
//		double doubleMax = doubleArr.mapToDouble(Double::valueOf).max().getAsDouble();
//		System.out.println("Maximum of all numbers(Double) -> " + doubleMax);
//
//		int intMax = intArr.mapToInt(Integer::valueOf).max().orElse(0);
//		System.out.println("Maximum of all numbers(Integer) -> " + intMax);

		// Average
//		double average = doubleArr.mapToDouble(Double::valueOf).average().orElse(0);
//		System.out.println("Average of all numbers(Integer) -> " + average);

		// Sum
//		int sum = intArr.mapToInt(Integer::valueOf).sum();
//		System.out.println("Sum of all numbers(Integer) -> " + sum);

		// SummaryStatistics
		DoubleSummaryStatistics summaryStatistics = doubleArr.mapToDouble(Double::valueOf).summaryStatistics();
		// System.out.println("Summary Statistics Data : " + summaryStatistics);
	}
}
