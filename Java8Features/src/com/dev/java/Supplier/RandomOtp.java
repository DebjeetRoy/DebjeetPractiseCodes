package com.dev.java.Supplier;

import java.util.function.Supplier;

public class RandomOtp {

	public static void main(String[] args) {

		Supplier<String> s = () -> {
			String otp = "";
			for (int i = 1; i < 5; i++) {
				otp += (int) (Math.random() * 8);
			}
			return otp;
		};
		System.out.println(s.get());
	}
}
