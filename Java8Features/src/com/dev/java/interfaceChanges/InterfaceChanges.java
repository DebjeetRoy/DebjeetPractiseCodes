package com.dev.java.interfaceChanges;

public class InterfaceChanges implements A, B {

	public static void main(String[] args) {
		A ref = new InterfaceChanges();
		A.sample();
		ref.fly();
		ref.test();
	}

	@Override
	public void fly() {
		System.out.println("This is fly()");
	}

	@Override
	public void test() {
		A.super.test();
	}
}
