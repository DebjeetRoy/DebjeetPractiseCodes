package com.dev.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableMain {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();

		Employee e1 = new Employee("EMP101", "Arijeet", 29, "Agra");
		Employee e2 = new Employee("EMP102", "Suresh", 27, "Kolkata");
		Employee e3 = new Employee("EMP103", "Raj", 31, "Bihar");
		Employee e4 = new Employee("EMP104", "Arun", 40, "Agra");
		Employee e5 = new Employee("EMP105", "Varun", 24, "Varanasi");

		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);

		Collections.sort(empList);
		System.out.println(empList);
	}
}
