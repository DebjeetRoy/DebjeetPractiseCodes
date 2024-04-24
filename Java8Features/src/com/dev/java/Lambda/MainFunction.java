package com.dev.java.Lambda;

public class MainFunction {

	public static void main(String[] args) {
		int a = 4;
		int b = 5;

		LambdaInterface sum = (x, y) -> x + y;
		int result = sum.sum(a, b);
		System.out.println(result);
	}
}
