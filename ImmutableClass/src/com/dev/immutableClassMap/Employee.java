package com.dev.immutableClassMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public final class Employee {
	private final String empId;
	private final String empName;
	private final Map<String, String> departments;

	public Employee(String empId, String empName, Map<String, String> depatmentList) {
		this.empId = empId;
		this.empName = empName;

		final Map<String, String> clonedDepartment = new HashMap<>();
		for (final Entry<String, String> mp : depatmentList.entrySet()) {
			clonedDepartment.put(mp.getKey(), mp.getValue());
		}
		this.departments = clonedDepartment;
	}

	public String getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public Map<String, String> getDepartments() {
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
		final Employee other = (Employee) obj;
		return Objects.equals(departments, other.departments) && Objects.equals(empId, other.empId)
				&& Objects.equals(empName, other.empName);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", departments=" + departments + "]";
	}

	public static void main(String[] args) {
		final Map<String, String> deptMap = new HashMap<>();

		deptMap.put("1", "DEPT101");
		deptMap.put("2", "DEPT102");

		final Employee emp = new Employee("EMP101", "Rajesh", deptMap);
		System.out.println(emp);
		deptMap.put("3", "DEPT103");
		deptMap.put("4", "DEPT104");

		final Employee emp1 = emp;
		// emp1.empId = "EMP102"; // -> If field is not set as final then we can change
		// its value with shallow cloning

		System.out.println();
		System.out.println("After setting new value in map");
		System.out.println(emp);
	}
}