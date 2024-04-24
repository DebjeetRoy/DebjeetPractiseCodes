package com.dev.Comparable;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
	private String empId;

	private String empName;

	private int empAge;

	private String empAddress;

	public Employee(String empId, String empName, int empAge, String empAddress) {
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empAddress = empAddress;
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

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public int compareTo(Employee o) {
		return this.empName.compareTo(o.empName);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empAddress=" + empAddress
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(empAddress, empAge, empId, empName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee employee = (Employee) obj;
		return Objects.equals(empAddress, employee.empAddress) && empAge == employee.empAge;
	}

}
