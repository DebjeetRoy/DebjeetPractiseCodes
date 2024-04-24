package com.dev.exception.Impl;

public class TryCatchImpl {

	public static void main(String[] args) {
		System.out.println("Stack overflow Demo...");

		try {
			test();
		} catch (Error e) {
			System.out.println("One method calling another");
		}
		System.out.println("End of try-catch");
	}

	private static void test() {
		drive();
	}

	private static void drive() {
		test();
	}
}
