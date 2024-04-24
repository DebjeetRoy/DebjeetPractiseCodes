package com.dev.java8.Streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByWithCount {

	public static void main(String[] args) {
		List<String> al = List.of("Raj", "Mohit", "Raj", "Dev");

		Map<String, Long> map = al.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		map.forEach((name, count) -> {
			System.out.println(name + " -> " + count);
		});
	}
}
