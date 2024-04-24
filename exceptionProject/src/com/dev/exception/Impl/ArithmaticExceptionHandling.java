package com.dev.exception.Impl;

public class ArithmaticExceptionHandling {

	public static void main(String[] args) {
		System.out.println("Divide by Zero ...");
		int a = 11;

		try {
			a = a / 0;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		String str = null;
		str.toCharArray();

		System.out.println("a = " + a);

	}

}
