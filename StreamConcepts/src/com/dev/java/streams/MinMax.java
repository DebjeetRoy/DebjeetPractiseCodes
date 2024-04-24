package com.dev.java.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinMax {
	public static void main(String[] args) {
		List<Integer> al = new ArrayList<>();
		al.add(3);
		al.add(1);
		al.add(0);
		al.add(2);

		System.out
				.println(al.stream().skip(1).collect(Collectors.maxBy(Comparator.comparing(Integer::intValue))).get());
		System.out.println(al.stream().max(Comparator.comparing(Integer::valueOf)).get().intValue());
		System.out.println("Average : " + al.stream().collect(Collectors.averagingDouble(Integer::intValue)));
	}
}
