package com.dev.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
	private String empName;
	private String email;
	private String gender;

	public Employee(String empName, String email, String gender) {
		this.empName = empName;
		this.email = email;
		this.setGender(gender);
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", email=" + email + ", gender=" + gender + "]";
	}
}

public class CountDomains {

	public static void main(String[] args) {
		Employee emp1 = new Employee("A", "A@google.com", "Male");
		Employee emp2 = new Employee("B", "B@gmail.com", "Female");
		Employee emp3 = new Employee("C", "C@gmail.com", "Male");

		List<Employee> empList = new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);

		System.out.println("Count of Email Domains : " + countEmailDomains(empList));

		empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())).entrySet().stream()
				.forEach(x -> {
					System.out.print(x.getKey() + " -> " + x.getValue());
				});
	}

	private static long countEmailDomains(List<Employee> empList) {
		return empList.stream().map(Employee::getEmail).count();
	}
}
