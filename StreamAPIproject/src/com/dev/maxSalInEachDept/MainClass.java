package com.dev.maxSalInEachDept;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) {
		final Department dept1 = new Department("DEPT101", "IT Department");
		final Department dept2 = new Department("DEPT102", "Science Department");

		final Employee emp1 = new Employee("EMP101", "Rajesh", 500000L, dept1);
		final Employee emp2 = new Employee("EMP102", "Akhilesh", 1000000L, dept1);
		final Employee emp3 = new Employee("EMP103", "Sam", 300000L, dept2);
		final Employee emp4 = new Employee("EMP104", "Dev", 1500000L, dept2);
		final Employee emp5 = new Employee("EMP105", "Sankalp", 700000L, dept1);

		final List<Employee> empList = new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);

		System.out.println("Fetching max salary in each department => ");

		empList.stream()
				.collect(Collectors.groupingBy(x -> x.getDept().getDeptId(),
						Collectors.maxBy(Comparator.comparing(Employee::getEmpSalary))))
				.entrySet().stream().forEach(x -> {
					if (x.getValue().isPresent()) {
						System.out.println("Department ID : " + x.getValue().get().getDept().getDeptId() + " -> "
								+ "Max Salary : " + x.getValue().get().getEmpSalary());
					}
				});
	}
}
