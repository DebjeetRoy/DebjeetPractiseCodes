package com.dev.Stream.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMain {
	public static void main(String[] args) {

		Employee emp1 = new Employee("EMP101", "Raj", BigDecimal.valueOf(20000), "UP");
		Employee emp2 = new Employee("EMP102", "Dev", BigDecimal.valueOf(10000), "Bihar");
		Employee emp3 = new Employee("EMP103", "Saumya", BigDecimal.valueOf(50000), "Kolkata");
		Employee emp4 = new Employee("EMP104", "Abhishek", BigDecimal.valueOf(100000), "Tamil Nadu");
		Employee emp5 = new Employee("EMP105", "Kevin", BigDecimal.valueOf(200000), "Hyderabad");
		Employee emp6 = new Employee("EMP101", "Raj", BigDecimal.valueOf(20000), "UP");

		List<Employee> al = new ArrayList<>();

		al.add(emp1);
		al.add(emp2);
		al.add(emp3);
		al.add(emp4);
		al.add(emp5);
		al.add(emp6);

		List<Employee> filteredList = al.stream()
				.filter(emp -> emp.getEmpSalary().compareTo(BigDecimal.valueOf(50000)) < 0).distinct()
				.sorted(Comparator.comparing(Employee::getEmpSalary).thenComparing(Employee::getEmpAddress))
				.collect(Collectors.toList());

		for (Employee emp : filteredList) {
			System.out.println(emp);
		}

		System.out.println("**********Count operation*********");
		long count = al.stream().filter(emp -> emp.getEmpSalary().compareTo(BigDecimal.valueOf(50000)) < 0).distinct()
				.count();

		System.out.println("Count of employees < 50k = " + count);

		System.out.println("*********Increment by 10%***********");

		al.stream().map(emp -> emp.getEmpSalary().add(BigDecimal.valueOf(0.1).multiply(emp.getEmpSalary())))
				.forEach(System.out::println);
	}
}
