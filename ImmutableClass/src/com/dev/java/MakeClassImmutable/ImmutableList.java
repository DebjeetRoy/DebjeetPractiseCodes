package com.dev.java.MakeClassImmutable;

import java.util.ArrayList;
import java.util.List;

public class ImmutableList {


	public static void main(String[] args) {
		List<String> fruits = new ArrayList<>();
		fruits.add("Banana");
		fruits.add("Orange");
		fruits.add("Pear");
		fruits.add("Apple");
		
		//Before Java9
//		fruits = Collections.unmodifiableList(fruits);
//		fruits.add("abc");
//		System.out.println(fruits);

		// After Java9
		List<String> fruitList = List.of("Banana", "Orange", "Mango", "Pear");
		fruitList.add("A");
		System.out.println(fruits);
	}

}
