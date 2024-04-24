package com.dev.java8.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class IntStreamEx {
	public static void main(String[] args) {
		IntStream.range(0, 10).forEach(System.out::print);
		System.out.println();
		IntStream.rangeClosed(0, 10).forEach(System.out::print);
		System.out.println();

		Person p = new Person("Dev", 30, "Kolkata");
		Person p1 = new Person("Abhit", 25, "Delhi");
		Person p2 = new Person("Raj", 32, "Bombay");

		System.out.println("List of Person objects...");

		List<Person> al = new ArrayList<>();
		al.add(p);
		al.add(p1);
		al.add(p2);

		forEachCall(al);

		System.out.println("Iterate operation on numbers");
		iterateOperation();

	}

	private static void iterateOperation() {
		IntStream.iterate(0, operand -> operand + 1).limit(10).forEach(System.out::print);
	}

	private static void forEachCall(List<Person> al) {
		IntStream.range(0, al.size()).forEach(index -> {
			Person person = al.get(index);
			System.out.println(person);
		});
	}
}

class Person {
	private String name;
	private int age;
	private String address;

	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
}
