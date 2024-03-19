package com.dev.java.List;

import java.util.LinkedList;

public class LinkedListImpl {
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();

		// add
		ll.add(3);
		ll.add(1);
		ll.add(5);
		ll.add(8);
		ll.add(2);

		System.out.println("Initial LinkedList : " + ll);

		// add
		System.out.println("Adding an element at First");
		ll.addFirst(10);
		System.out.println(ll);

		// addLast
		System.out.println("Adding an element at Last");
		ll.addLast(10);
		System.out.println(ll);

		// add at specified index position
		System.out.println("Adding an element at 3");
		ll.add(3, 30);
		System.out.println(ll);

		// Search for specific element (key = 8)
		System.out.println("Searching for key = 8");
		int key = 8;
		for (int i = 0; i < ll.size(); i++) {
			if (ll.get(i) == key) {
				System.out.println("Key is found at index : " + i);
			}
		}

		// Removing first or head element
		System.out.println(ll.removeFirst());
		System.out.println("LL after removing First element : " + ll);

		// Removing last or tail element
		System.out.println(ll.removeLast());
		System.out.println("LL after removing Last element : " + ll);

		// Reverse LinkedList
		System.out.println("Reverse LL");

		for (int i = ll.size() - 1; i >= 0; i--) {
			System.out.print(ll.get(i) + " ");
		}
	}
}
