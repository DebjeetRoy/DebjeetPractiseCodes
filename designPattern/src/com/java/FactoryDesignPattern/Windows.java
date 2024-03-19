package com.java.FactoryDesignPattern;

public class Windows implements OperatingSystem {

	@Override
	public void feature() {
		System.out.println("This is feature() of Windows class !!");
	}
}
