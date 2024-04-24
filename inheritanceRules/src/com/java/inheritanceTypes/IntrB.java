package com.java.inheritanceTypes;

public interface IntrB {
	public void drive();

	default public void test() {
		System.out.println("This is default() of Interface B");
	}

	static void display() {
		System.out.println("This is static() of Interface A");
	}
}
