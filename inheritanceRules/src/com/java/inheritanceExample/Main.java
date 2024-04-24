package com.java.inheritanceExample;

public class Main {
	public static void main(String[] args) {

		/*
		 * If A and B class have same method where B extends A then it will override
		 * method of Subclass whereas if both inherited class has diff. method then
		 * child class method gets hidden while upcasting B to A e.g A obj = new B()
		 */
		A obj = new B(); // Upcasting
		B ref = (B) obj;
		obj.testA();
		System.out.println(obj.a);
		ref.testB();
//
//		C c = new C();
//		System.out.println("a=" + c.a);
//		obj.testA();
//
//		B obj1 = new B();
//		obj1.testA();
	}
}
