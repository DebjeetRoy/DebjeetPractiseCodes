package com.dev.java.Function;

import java.util.function.Function;

public class RemoveSpacesFromString {

	public static void main(String[] args) {

		String[] arr = { "Debjeet is great", "Rajesh is handsome", "Mahesh loves icecream" };

		Function<String, String> f = s -> s.replaceAll(" ", "");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(f.apply(arr[i]));
		}
	}
}
