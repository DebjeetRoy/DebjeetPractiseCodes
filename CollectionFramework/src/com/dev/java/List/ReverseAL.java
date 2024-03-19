package com.dev.java.List;

import java.util.ArrayList;
import java.util.List;

public class ReverseAL {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 6, 7, 8, 9 };

		List<Integer> al = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			al.add(i);
		}
		System.out.println("Initial ArrayList values ->");
		System.out.println(al);

		// Reverse al
		reverse(al);
		System.out.println();
	}

	private static void reverse(List<Integer> al) {

		System.out.println("Reversed ArrayList ->");
		for (int i = al.size() - 1; i >= 0; i--) {
			System.out.print(al.get(i) + " ");
		}
	}
}
