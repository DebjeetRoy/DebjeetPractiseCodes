package com.dev.Stream.Employee;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
	private String empId;

	private String empName;

	private BigDecimal empSalary;

	private String empAddress;

	public Employee(String empId, String empName, BigDecimal empSalary, String empAddress) {
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
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

	public BigDecimal getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(BigDecimal empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empAddress, empId, empName, empSalary);
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
		return Objects.equals(empAddress, emp.empAddress) && Objects.equals(empId, emp.empId)
				&& Objects.equals(empName, emp.empName) && Objects.equals(empSalary, emp.empSalary);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empAddress="
				+ empAddress + "]";
	}
}
