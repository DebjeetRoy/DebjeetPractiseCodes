package com.java.Exception_Overriding;

import java.io.FileNotFoundException;

public class ChildClass extends SuperClass {

	/*
	 * 1. If super class doesn't throw any exception then overridden method of
	 * subclass can throw only unchecked Exception or no exception.
	 */
	/*
	 * 2. If super class throws Unchecked Exception then child class can only throw
	 * unchecked exceptions or no exception.
	 */
	/*
	 * 3. If super class throws Checked exception then subclass will throw exception
	 * which are equal to or below super class exception.
	 */
	@Override
	public void method() throws FileNotFoundException {
		System.out.println("SuperClass method");
	}
}
