package com.dev.java8.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class GroupingBy {

	public static void main(String[] args) {
		Person p1 = new Person("Dev", 34, "Lucknow");
		Person p2 = new Person("Raj", 24, "Bihar");
		Person p3 = new Person("Mahesh", 26, "UP");
		Person p4 = new Person("Axar", 29, "Bihar");
		Person p5 = new Person("Mohit", 30, "UP");
		Person p6 = new Person("Balmukund", 26, "UP");
		Person p7 = new Person("Vinita", 23, "Kolkata");
		Person p8 = new Person("Aman", 31, "Kolkata");

		List<Person> personList = new ArrayList<>();
		personList.add(p8);
		personList.add(p7);
		personList.add(p6);
		personList.add(p5);
		personList.add(p4);
		personList.add(p3);
		personList.add(p2);
		personList.add(p1);

		Map<String, List<Person>> map = personList.stream().collect(Collectors.groupingBy(Person::getAddress));

		BiConsumer<? super String, ? super List<Person>> biConsumer = (address, persons) -> {
			System.out.println(address + " -> ");
			System.out.println(persons);
			System.out.println();
		};
		map.forEach(biConsumer);
	}
}
