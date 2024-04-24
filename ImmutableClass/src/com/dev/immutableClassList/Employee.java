package com.dev.immutableClassList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Employee { // No class can inherit this class
	private final String empId; // private - not visible to outside class
								// final - no shallow copy
	private final String empName;
	private final List<String> departments;

	public Employee(String empId, String empName, List<String> depatmentList) {
		this.empId = empId;
		this.empName = empName;
		
		// Deep cloning
		List<String> clonedDeptList = new ArrayList<>();
		for (String s : depatmentList) {
			clonedDeptList.add(s);
		}
		this.departments = clonedDeptList;
	}

	public String getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public List<String> getDepartments() {
		return departments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departments, empId, empName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(departments, other.departments) && Objects.equals(empId, other.empId)
				&& Objects.equals(empName, other.empName);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", departments=" + departments + "]";
	}

	public static void main(String[] args) {
		List<String> deptList = new ArrayList<>();
		deptList.add("DEPT101");
		deptList.add("DEPT102");
		deptList.add("DEPT103");
		
		Employee emp = new Employee("EMP101", "Rajesh", deptList);
		System.out.println(emp);

		Employee emp2 = emp;
		// emp2.empId = "Dolly"; // Shallow cloning
		
		//Trying to modify the list value
		deptList.add("DEPT500");
		deptList.add("DEPT600");

		System.out.println(emp);
	}
}
