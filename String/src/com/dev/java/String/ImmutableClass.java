package com.dev.java.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

//Make class final so that no other class can inherit this class.
public final class ImmutableClass {

	// all mutable fields should be final(can't create more than 1 instance) and all
	// fields should be private
	private final int id;
	private final String name;
	private final HashMap<String, String> testMap;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// Getter function for mutable objects
	public HashMap<String, String> getTestMap() {
		return (HashMap<String, String>) testMap.clone();
	}

	// Constructor method performing a deep copy
	private ImmutableClass(int i, String name, HashMap<String, String> hm) {
		this.id = i;
		this.name = name;

		// Deep Copy
		final HashMap<String, String> tempMap = new HashMap<>();
		String key;
		final Iterator<String> iterator = hm.keySet().iterator();
		while (iterator.hasNext()) {
			key = iterator.next();
			tempMap.put(key, hm.get(key));
		}
		this.testMap = tempMap;

		////////////////
		final List<StringTest> givenList = new ArrayList<>();
		final List<StringTest> tempList = new ArrayList<>();

		final Iterator<StringTest> it = givenList.listIterator();
		while (it.hasNext()) {
			tempList.add(it.next());
		}
		// this.givenList = tempList;
	}

	// Test the immutable class
	public static void main(StringTest[] args) {
		final HashMap<String, String> h1 = new HashMap<String, String>();
		h1.put("1", "first");
		h1.put("2", "second");

		String s = "original";

		int i = 10;

		final ImmutableClass ce = new ImmutableClass(i, s, h1);
		final ImmutableClass ce1 = ce; // Changing fields via shallow copy
		// ce1.id = 90;

		/*
		 * We have to keep fields final otherwise we can change it's data through
		 * shallow copy technique.
		 */
		// ce1.name = "Varun";

		// print the ce values
		System.out.println("ce id: " + ce.getId());
		System.out.println("ce name: " + ce.getName());
		System.out.println("ce testMap: " + ce.getTestMap());
		// change the local variable values
		i = 20;
		s = "modified";
		h1.put("3", "third");
		// print the values again
		System.out.println("ce id after local variable change: " + ce.getId());
		System.out.println("ce name after local variable change: " + ce.getName());
		System.out.println("ce testMap after local variable change: " + ce.getTestMap());

		final HashMap<String, String> hmTest = ce.getTestMap();
		hmTest.put("4", "new");

		System.out.println("ce testMap after changing variable from getter methods: " + ce.getTestMap());

	}
}
