package com.dev.java8.Streams;

import java.util.Arrays;

public class Reduce {
	public static void main(String[] args) {
		Integer[] arr = { 4, 2, 5, 2, 5, 3, 5, 7 };

		System.out.println("Calculating sum with Lambda using Reduction");
		int sum1 = Arrays.stream(arr).reduce(0, (a, b) -> a + b);
		System.out.println(sum1);

		System.out.println("Calculating sum with Method Reference using Reduction");
		int sum2 = Arrays.stream(arr).reduce(0, Integer::sum);
		System.out.println(sum2);
	}
}
