package com.branching.conditions;

public class InheritanceConcept {
	public static void main(String[] args) {
	
		A obj = new B();
		System.out.println(obj.x);
		obj.test();
		
	}
}

class A {
	int x=4;
	public void test() {
		System.out.println("This is test() of class A");
	}
}

class B extends A{
	int x = 6;
	public void test() {
		System.out.println("This is test() of class B");
	}
}
