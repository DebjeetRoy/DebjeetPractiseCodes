package com.dev.java.String;

public class SplitMethod {

	public static void main(String[] args) {
		final String str = "Hi I am Debjet";

		final String[] split = str.split(" ");

		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}
	}
}
