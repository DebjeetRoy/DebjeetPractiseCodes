package com.dev.java.interfaceChanges;

public interface A {
	public void fly();

	default public void test() {
		System.out.println("This is test() of interface A");
	}

	static void sample() {
		System.out.println("This is sample() of interface A");
	}
}
