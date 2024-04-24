package com.dev.java.String;

import java.math.BigDecimal;

public class Add2Strings {
	public static void main(StringTest[] args) {
		final String num1 = "23";
		final String num2 = "15";

		final BigDecimal val1 = BigDecimal.valueOf(Long.parseLong(num1));
		final BigDecimal val2 = BigDecimal.valueOf(Long.parseLong(num2));

		final BigDecimal ans = val1.add(val2);
		System.out.println(String.valueOf(ans));
	}
}
