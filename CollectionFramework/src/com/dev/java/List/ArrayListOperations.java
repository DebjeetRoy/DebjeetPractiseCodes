package com.dev.java.List;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOperations {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 6, 7, 8, 9 };

		// Add operation - O(1)
		List<Integer> al = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			al.add(arr[i]);
		}
		System.out.println("Array List values -> " + al);

		// Get operation TC = O(1)
		System.out.println("Element at 3rd index is :- " + al.get(3));
		System.out.println("Size of Current ArrayList = " + al.size());

		// Remove element TC = O(n)
		Integer removedElement = al.remove(2);
		System.out.println("Removed Element is " + removedElement);

		System.out.println("New Array List data :- " + al);

		al.set(2, removedElement);
		System.out.println("Adding Removed element again !!");
		System.out.println("New Array List data :- " + al);

		System.out.println(al.contains(7));// O(n)
		System.out.println("Size of final ArrayList = " + al.size());

		System.out.println(al.toArray());
	}
}
