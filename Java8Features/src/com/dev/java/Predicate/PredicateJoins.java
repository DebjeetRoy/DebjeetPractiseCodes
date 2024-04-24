package com.dev.java.Predicate;

import java.util.function.Predicate;

public class PredicateJoins {

	public static void main(String[] args) {

		String[] arr = { "Debjeet", "Rajesh", "Mahesh", "Suresh", "Mohit" };

		Predicate<String> p1 = s -> s.charAt(0) == 'M';
		Predicate<String> p2 = s -> s.length() < 6;

		// and(T t)
		System.out.println("Checking and() for above condition");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " " + p1.and(p2).test(arr[i]));
		}
		System.out.println();

		// or(T t)
		System.out.println("Checking or() for above condition");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " " + p1.or(p2).test(arr[i]));
		}
		System.out.println();

		// negate()
		System.out.println("Checking negate() for above condition");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " " + p1.negate().test(arr[i]));
		}
	}
}
