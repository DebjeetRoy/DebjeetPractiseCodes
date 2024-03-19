package com.dev.java.List;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
	public static void main(String[] args) {

		int[] arr = { 3, 1, 6, 7, 8, 9 };

		List<Integer> al = new ArrayList<>();
		al.add(4);
		// al.add("Hi");
		// al.add(4.0f);

		System.out.println(al);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
