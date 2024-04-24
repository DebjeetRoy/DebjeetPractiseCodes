package com.dev.java.String;

public class ReverseString {

	public static void main(String[] args) {
		final String str = "Raj is a Good Boy";

		final StringBuffer sb = new StringBuffer("");
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		final String revString = sb.toString();

		System.out.println("Reversed String = " + revString);

		if (str.equalsIgnoreCase(revString)) {
			System.out.println(str + " is a palindrome");
		} else {
			System.out.println(str + " is NOT a palindrome");
		}
	}
}
