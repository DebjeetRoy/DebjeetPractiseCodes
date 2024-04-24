package com.modelMapping.demo.dto;

import lombok.Data;

@Data
public class EmployeeDto {
	private String empId;
	private String empName;
	private String empAddress;

	public EmployeeDto() {

	}

	public EmployeeDto(String empId, String empName, String empAddress) {
		this.empId = empId;
		this.empName = empName;
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

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "EmployeeDto [empId=" + empId + ", empName=" + empName + ", empaAddress=" + empAddress + "]";
	}
}
