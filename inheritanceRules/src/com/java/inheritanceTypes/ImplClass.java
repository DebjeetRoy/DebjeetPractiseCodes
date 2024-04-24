package com.java.inheritanceTypes;

public class ImplClass implements IntrA, IntrB {

	@Override
	public void t() {
		System.out.println("I am new here");

	}

	@Override
	public void drive() {
		System.out.println("I am Driving");

	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		IntrB.super.test();
	}
}
