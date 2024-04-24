package com.java.MultipleInheritance;

public interface Run2 {
	default public void view() {
		System.out.println("This is view() of Run2 interface");
	}

	public static int sum(int a, int b) {
		return a + b;
	}
}
