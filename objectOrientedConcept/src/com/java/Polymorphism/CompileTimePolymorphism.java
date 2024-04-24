package com.java.Polymorphism;

public class CompileTimePolymorphism {

	public static void main(String[] args) {

		System.out.println("Calculate area of Square");
		System.out.println(area(5));

		System.out.println("Calculate area of Rectangle");
		System.out.print(area(5, 7));

	}

	/*
	 * Area of a square
	 */
	public static int area(int length) {
		return length * length;
	}

	/*
	 * Area of a rectangle
	 */
	public static int area(int length, int breadth) {
		return length * breadth;
	}

}
