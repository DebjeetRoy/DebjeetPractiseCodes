package com.java.FactoryDesignPattern;

public class MainFlow {
	public static void main(String[] args) {
		FactoryClass fc = new FactoryClass();
		OperatingSystem os = fc.getOperatingSystem("Licensed123");
		os.feature();
	}
}
