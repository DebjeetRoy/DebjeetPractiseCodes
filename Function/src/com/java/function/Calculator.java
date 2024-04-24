package com.java.function;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter 4 numbers");
		int num1 = in.nextInt();
		int num2 = in.nextInt();

		float num3 = in.nextFloat();
		float num4 = in.nextFloat();

		System.out.println("Sum of " + num1 + " and " + num2 + " is " + sum(num1, num2));

		System.out.println("Subtraction of " + num1 + " and " + num2 + " is " + subtract(num1, num2));

		System.out.println("Subtraction(FO) of " + num3 + " and " + num4 + " is " + subtract(num3, num4));

		System.out.println("Multiplication of " + num1 + " and " + num2 + " is " + multiply(num1, num2));

		System.out.println("Division of " + num1 + " and " + num2 + " is " + divide(num1, num2));

		System.out.println("Modulus of " + num1 + " and " + num2 + " is " + modulus(num1, num2));

		System.out.println("Power of " + num1 + " and " + num2 + " is " + power(num1, num2));

		in.close();
	}

	private static double power(int num1, int num2) {
		return Math.pow(num1, num2);

	}

	private static float modulus(int num1, int num2) {
		float modulus = 0;
		modulus = num1 % num2;

		return modulus;

	}

	private static float divide(int num1, int num2) {
		float div = 0;
		div = num1 / num2;

		return div;

	}

	private static int multiply(int num1, int num2) {
		int mult = 0;
		mult = num1 * num2;

		return mult;

	}

	/*
	 * 
	 * Number of arguements, order of arguements and type of arguements.
	 */
	private static int subtract(int num1, int num2) {
		int subtract = 0;
		subtract = num1 - num2;

		return subtract;

	}

	private static float subtract(float num1, float num2) {
		float subtract = 0;
		subtract = num1 - num2;

		return subtract;
	}

	private static int sum(int num1, int num2) {
		int sum = 0;
		sum = num1 + num2;

		return sum;
	}

}
