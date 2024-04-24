package com.java.objectOriented;

public class CollegeMain {

	public static void main(String[] args) {
		Student stud = new Student();

		stud.setStudentGender("Male");
		stud.setStudentMarks(70);
		stud.setStudentType("Studious");

		System.out.println("Properties of Student is -> " + " Gender - " + stud.getStudentGender() + " Type - "
				+ stud.getStudentType() + " marks obtained " + stud.getStudentMarks());

		stud.getMarks(60, 70, 100);
	}

}

class Student {
	Student(){
		
	}
	private String studentType;

	private String studentGender;

	private double studentMarks;

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public double getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(double studentMarks) {
		this.studentMarks = studentMarks;
	}

	public void getMarks(double physics, double maths, double chemistry) {
		physics = 50;
		maths = 70;
		chemistry = 80;

		double percentage = ((physics + maths + chemistry) / 300) * 100;

		System.out.println("Percentage of marks = " + percentage);
	}
}
