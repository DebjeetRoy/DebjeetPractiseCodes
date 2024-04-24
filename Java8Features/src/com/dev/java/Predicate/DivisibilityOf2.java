package com.dev.java.Predicate;

import java.util.function.Predicate;

public class DivisibilityOf2 {

	public static void main(String[] args) {

		// Scanner in = new Scanner(System.in);

		// System.out.println("Enter number to check");
		// int num = in.nextInt();

		int[] arr = { 2, 1, 5, 6, 3 };

		Predicate<Integer> p = s -> s % 2 == 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " " + p.test(arr[i]));
		}

		// in.close();
	}
}
