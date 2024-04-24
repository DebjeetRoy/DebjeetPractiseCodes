package com.java.Ser_Des;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * Generated Serial version UID
	 */
	private static final long serialVersionUID = -3586188393568441359L;

	transient int empId;
	static double empSalary;
	String empName;
	int empAge;

	// Default constructor
	public Employee(String name, int age, int id, double salary) {
		this.empName = name;
		this.empAge = age;
		this.empId = id;
		this.empSalary = salary;
	}
}
