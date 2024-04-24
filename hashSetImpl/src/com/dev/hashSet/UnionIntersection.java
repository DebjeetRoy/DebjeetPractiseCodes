package com.dev.hashSet;

import java.util.HashSet;
import java.util.Set;

public class UnionIntersection {

	public static void main(String[] args) {

		int[] arr1 = { 7, 3, 9 };
		int[] arr2 = { 6, 3, 9, 2, 9, 4 };

		union(arr1, arr2);
		intersection(arr1, arr2);
	}

	private static void intersection(int[] arr1, int[] arr2) {
		Set<Integer> set = new HashSet<>();
		System.out.println("Intersection => ");

		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}

		int count = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (set.contains(arr2[i])) {
				count++;
				System.out.print(arr2[i] + " ");
				set.remove(arr2[i]);
			}
		}
		System.out.println();

		System.out.println("Intersection elements size = " + count);
	}

	private static void union(int[] arr1, int[] arr2) {
		Set<Integer> set = new HashSet<>();

		System.out.println("Union => ");
		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			set.add(arr2[i]);
		}

		System.out.println(set);
	}
}
