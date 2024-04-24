package com.dev.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndMap {
	public static void main(String[] args) {
		List<Integer> al = new ArrayList<>();
		al.add(2);
		al.add(1);
		al.add(4);
		al.add(3);
		al.add(9);

		System.out.println("Filter operation");
		al.stream().filter(x -> (x % 2 != 0)).collect(Collectors.toList()).forEach(System.out::println);

		System.out.println("Map operation");
		al.stream().map(x -> x * x).collect(Collectors.toList()).forEach(System.out::println);
	}
}
