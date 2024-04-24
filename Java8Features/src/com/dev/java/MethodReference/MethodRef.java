package com.dev.java.MethodReference;

/*
 * Code Reuability is there with Method Reference.
 * Instead of repeating code we can directly refer m1 to m2.
 * Only arguements should be same, return type, access specifiers can be changed
 * Method reference is alternate syntax to Lambda Expression
 */
public class MethodRef {

	public static void m2(int a, int b) {
		System.out.println("m2() used for method reference, Sum = " + (a + b));
	}

	public static void main(String[] args) {
		// IntrfaceEx ref = (a, b) -> System.out.println(a + b);
		IntrfaceEx ref = MethodRef::m2;
		ref.m1(6, 4);
	}
}
