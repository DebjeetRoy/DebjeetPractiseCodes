package com.dev.java.String;

public class ReverseEachWord {

	public static void main(String[] args) {

		final String str = "I found a pretty girl";

		final String[] split = str.split(" ");
		final StringBuffer sb = new StringBuffer("");

		for (int i = 0; i < split.length; i++) {
			final String toBeRev = split[i];
			for (int j = toBeRev.length() - 1; j >= 0; j--) {
				sb.append(toBeRev.charAt(j));
			}
			sb.append(" ");
		}
		System.out.println("Reversed string = " + sb.toString());
	}
}
