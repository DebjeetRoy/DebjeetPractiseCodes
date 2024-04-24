package com.dev.entity;

import java.util.Objects;

public class Employee {
	String empId;
	String empName;
	int empAge;

	public Employee(String empId, String empName, int empAge) {
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empAge, empId, empName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee emp = (Employee) obj;
		return empAge == emp.empAge && Objects.equals(empId, emp.empId) && Objects.equals(empName, emp.empName);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + "]";
	}

}
