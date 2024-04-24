package com.java.InheritanceWithExceptions;

import java.io.IOException;

public class ChildClass extends BaseClass {

	// 1) If super class constructor doesn't throw any exception then child class
	// constructor
	// can throw any or NO exception
	//
	// 2) If super class throws Runtime or unchecked exception then child class
	// constructor can throw any or No exceptions.
	//
	// 3) If Super class is throwing Checked exception of particular type then child
	// class constructor will throw same exception or upper level checked exception.
	// It can't go below super class exception or any unchecked exception.
	//
	ChildClass() throws IOException {
		System.out.println("This is Child class implementing Base class");
	}

	public void test() {
		System.out.println("test() of Child class");
	}
}
