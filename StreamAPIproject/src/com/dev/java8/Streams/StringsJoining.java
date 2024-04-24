package com.dev.java8.Streams;

import java.util.List;
import java.util.stream.Collectors;

public class StringsJoining {
	public static void main(String[] args) {

		List<String> names = List.of("Dev", "Raj", "Mohit", "Gaurav");

		String joins = names.stream().map(String::toUpperCase).collect(Collectors.joining("|"));
		System.out.println("Final joined value - " + joins);
	}
}
