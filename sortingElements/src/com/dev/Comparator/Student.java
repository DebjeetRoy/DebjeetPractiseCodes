package com.dev.Comparator;

public class Student {

	private String studentId;
	private String studentName;
	private String studentAddress;
	private float marksPercentage;

	public Student(String studentId, String studentName, String studentAddress, float marksPercentage) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.marksPercentage = marksPercentage;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public float getMarksPercentage() {
		return marksPercentage;
	}

	public void setMarksPercentage(float marksPercentage) {
		this.marksPercentage = marksPercentage;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", marksPercentage=" + marksPercentage + "]";
	}

}
