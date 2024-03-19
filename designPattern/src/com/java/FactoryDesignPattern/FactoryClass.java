package com.java.FactoryDesignPattern;

/*
 * Implementation class
 */
public class FactoryClass {
	public OperatingSystem getOperatingSystem(String type) {
		OperatingSystem ref;

		switch (type) {
		case "Open Source":
			ref = new Android();
			break;

		case "Closed Source":
			ref = new Apple();
			break;

		case "Licensed":
			ref = new Windows();
			break;

		default:
			throw new IllegalArgumentException("Please provide correct type for OS");
		}
		return ref;
	}
}
