package com.java.inheritanceTypes;

public class SingleLevel {

	public static void main(String[] args) {
		C object = new C();

	}

}

class A {
	A() {
		System.out.println("This is Constructor of Class A");
	}

	public void testA() {

	}
}

class B extends A {
	B() {
		System.out.println("This is Constructor of Class B");
	}

	public void testB() {

	}
}

class C extends A {
	C() {
		System.out.println("This is Constructor of Class C");
	}
}
