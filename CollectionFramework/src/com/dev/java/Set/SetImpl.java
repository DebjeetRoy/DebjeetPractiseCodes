package com.dev.java.Set;

import java.util.Set;
import java.util.TreeSet;

public class SetImpl {
	public static void main(String[] args) {
		Set<String> set = new TreeSet<>();

		set.add("Zaidi");
		set.add("Raj");
		set.add("Ram");
		set.add("Ram");
		set.add("Dev");

		System.out.println(set);
	}
}
