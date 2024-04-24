package com.java.function;

class A {
	String i, j;

	A(String i, String j) {
		this.i = i;
		this.j = j;
	}
}

public class SampleOutput {

	public static void main(String[] args) {
		final A a = new A(null, null);
		System.out.println(a.i + " " + a.j);
	}
}
