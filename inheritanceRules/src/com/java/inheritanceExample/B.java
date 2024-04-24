package com.java.inheritanceExample;

public class B extends A {
	int a = 7;

	B() {
		System.out.println("This is constructor of class B");
		// System.out.println(6);
	}

	public void testB() {
		System.out.println("This is testB() of subclass B");
	}

	public void testA() {
		System.out.println("This is testA() of subclass B");
	}
}
