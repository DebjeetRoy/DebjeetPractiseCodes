package com.dev.java8.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WithAndWithoutFlatMap {
	public static void main(String[] args) {
		List<String> list1 = List.of("Dev", "Raj", "Mohit", "Gaurav");
		List<String> list2 = List.of("Amy", "Vipin", "Ayush", "Raiyan");

		List<List<String>> al = new ArrayList<>();
		al.add(list1);
		al.add(list2);

		/*
		 * Flattening content of 2 list to one without using FlatMap
		 */
		List<String> allNameList = new ArrayList<>();

		for (List<String> namesList : al) {
			for (String name : namesList) {
				allNameList.add(name);
			}
		}
		System.out.println("List of all names are :- " + allNameList);

		/*
		 * Flattening content of 2 list to one using FlatMap
		 */
		List<String> namesFM = al.stream().flatMap(List::stream).collect(Collectors.toList());

		System.out.println("List of all names are :- " + namesFM);
	}
}
