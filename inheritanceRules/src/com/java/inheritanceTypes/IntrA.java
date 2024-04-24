package com.java.inheritanceTypes;

public interface IntrA {
	public void t();

	default public void test() {
		System.out.println("This is default() of Interface A");
	}

	static void display() {
		System.out.println("This is static() of Interface A");
	}
}
