package com.dev.java.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OccurenceOfWord {

	static void occurence(String str) {
		String[] s = str.split(" ");
		Set<String> set = new HashSet<>();
		Arrays.stream(s).filter(x -> !set.add(x)).collect(Collectors.toList()).forEach(System.out::println);
	}

	public static void main(String[] args) {
		String str = "I am doing an interview at EPAM I work for EPAM";

		System.out.println("Words that are duplicating : ");
		occurence(str);
	}
}
