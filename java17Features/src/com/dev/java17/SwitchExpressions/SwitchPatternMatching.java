package com.dev.java17.SwitchExpressions;

sealed abstract class Vehicle permits Car, Boat, Train {
}

final class Car extends Vehicle {
	public String onRoad() {
		return "It's an on-road car";
	}
}

final class Boat extends Vehicle {
}

final class Train extends Vehicle {
}

public class SwitchPatternMatching {
	public static void ifStatements(Vehicle v) {
		if (v instanceof Car c) {
			System.out.println("It's a Car" + c.onRoad());
		} else if (v instanceof Boat) {
			System.out.println("It's a Boat");
		} else if (v instanceof Train) {
			System.out.println("It's a Train");
		} else {
			throw new IllegalArgumentException("Invalid Type !!");
		}
	}

	public static void patternMatching(String v) {
		switch (v) {
		case "car" -> {
			System.out.println("It's a Car");
			System.out.println("Using Switch expression");
		}
		}
	}

	public static void main(String[] args) {

	}
}
