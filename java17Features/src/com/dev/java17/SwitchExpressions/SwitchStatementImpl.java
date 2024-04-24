package com.dev.java17.SwitchExpressions;

public class SwitchStatementImpl {
	public static void main(String[] args) {

		String day = "Saturday";
		String result = "";

		/*
		 * We can replace : yield with "->"(Lambda expression)
		 */
		result = switch (day) {
		case "Monday":
			yield "8 AM alarm";

		case "Saturday", "Sunday":
			yield "6 AM alarm";

		default:
			yield "7 AM alarm";
		};

		System.out.println(result);
	}
}
