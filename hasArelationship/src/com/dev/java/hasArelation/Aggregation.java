package com.dev.java.hasArelation;

class Student {
	private String studId;
	private String studName;
	private int studAge;

	public Student(String studId, String studName, int studAge) {
		this.studId = studId;
		this.studName = studName;
		this.studAge = studAge;
	}

	public String getStudId() {
		return studId;
	}

	public void setStudId(String studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return "Deb";
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getStudAge() {
		return studAge;
	}

	public void setStudAge(int studAge) {
		this.studAge = studAge;
	}

	public void studentDetails() {
		System.out.println("Student details => " + studId + " -> " + studName);
	}
}

class Library {
	static Student s1 = new Student("STU1", "Rajesh", 30);

	static Student s2 = new Student("STU2", "Sourabh", 25);
}

public class Aggregation {
	public static void main(String[] args) {
		Library.s1.studentDetails();
	}
}
