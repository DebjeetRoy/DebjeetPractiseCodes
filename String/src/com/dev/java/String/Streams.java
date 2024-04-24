package com.dev.java.String;

import java.util.Arrays;
import java.util.List;

public class Streams {

	public static void main(StringTest[] args) {
		Integer[] num = { 2, 5, 4, 7 };

		List<Integer> al = Arrays.asList(num);

		System.out.println(al.stream().reduce(0, Integer::sum));

		System.out.println("Average = " + al.stream().mapToInt(Integer::intValue).average().getAsDouble());
		System.out.println("Sum = " + al.stream().mapToInt(Integer::intValue).sum());
	}
}
