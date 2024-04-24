package com.dev.java.interfaceChanges;

public interface B {
	public void fly();

	default public void test() {
		System.out.println("This is test() of interface B");
	}

	static void sample() {
		System.out.println("This is sample() of interface B");
	}
}
