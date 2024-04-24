package com.dev.hashSet;

import java.util.HashSet;
import java.util.Set;

import com.dev.entity.Employee;

public class HashSetFunction {

	public static void main(String[] args) {

		Set<String> hs = new HashSet<>();

		hs.add("data");
		hs.add("data");

		System.out.println(hs.size());
		String str = new String("Hello");
		String str1 = new String("Hello");
		String str2 = "Hello";
		System.out.println("str.hashCode() -> " + str.hashCode());
		System.out.println("str1.hashCode() -> " + str1.hashCode());
		System.out.println("str == str1 -> " + (str == str1));
		System.out.println("str == str2 -> " + (str == str2));
		System.out.println("str.hashCode() == str2.hashCode() -> " + (str.hashCode() == str2.hashCode()));
		System.out.println("str.equals(str1) -> " + str.equals(str1));

		Set<Employee> employeeSet = new HashSet<>();
		Employee emp = new Employee("EMP103", "Harsh", 30);
		Employee emp1 = new Employee("EMP103", "Harsh", 30);
		Employee emp2 = new Employee("EMP101", "Dev", 26);
		Employee emp3 = new Employee("EMP102", "Raj", 45);

		employeeSet.add(emp);
		System.out.println("emp hashcode() -> " + emp.hashCode());
		employeeSet.add(emp1);
		System.out.println("emp hashcode() -> " + emp1.hashCode());

		System.out.println("Employee size : " + employeeSet.size());

		employeeSet.add(emp2);
		employeeSet.add(emp3);

		employeeSet.remove(emp);
		System.out.println(employeeSet);
	}
}
