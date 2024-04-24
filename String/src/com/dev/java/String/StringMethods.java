package com.dev.java.String;

public class StringMethods {

	public static void main(String... args) {
		String str = "Debjeet";

		final String firstThree = str.substring(0, 3);

		final String str1 = str.substring(3);

		System.out.println(str1);

		final char[] ch = str.toCharArray();

		// System.out.println("Character Array values are :- " + ch);

		System.out.println("Character Array values are :- ");
		for (int i = 0; i < ch.length; i++) {
			System.out.print(ch[i] + " ");
		}
		System.out.println("Char at 2nd index is :- " + str.charAt(2));

		str = str.replaceAll("ee", "mm");
		str.split("m");
		System.out.println("New String is :- " + str);
	}

}
