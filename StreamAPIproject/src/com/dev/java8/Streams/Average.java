package com.dev.java8.Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Average {
	public static void main(String[] args) {
		final Student st1 = new Student("Ashish", 16, "Lucknow", 70);
		final Student st2 = new Student("Mahesh", 18, "Lucknow", 67);
		final Student st3 = new Student("Vinita", 19, "Lucknow", 45);
		final Student st4 = new Student("Ramesh", 15, "Lucknow", 90);
		final Student st5 = new Student("Raja", 19, "Lucknow", 95);

		final List<Student> al = new ArrayList<>();
		al.add(st1);
		al.add(st2);
		al.add(st3);
		al.add(st4);
		al.add(st5);

		final Double average = al.stream().mapToDouble(Student::getStudMarks).average().getAsDouble();
		System.out.println("Average of given array elements is : " + average);

		al.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getStudMarks))).ifPresentOrElse(
				x -> System.out.println("Maximum marks of all students : " + x.getStudMarks()),
				() -> System.out.println("Stud marks not found"));
//		if (optional.isPresent()) {
//			System.out.println("Maximum marks of all students : " + optional.get());
//		}

		System.out.println("Average : " + al.stream().collect(Collectors.averagingDouble(Student::getStudMarks)));
	}
}

class Student {
	private String studName;
	private int studAge;
	private String studAddress;
	private double studMarks;

	public Student(String studName, int studAge, String studAddress, double studMarks) {
		this.studName = studName;
		this.studAge = studAge;
		this.studAddress = studAddress;
		this.studMarks = studMarks;
	}

	public String getStudName() {
		return studName;
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

	public String getStudAddress() {
		return studAddress;
	}

	public void setStudAddress(String studAddress) {
		this.studAddress = studAddress;
	}

	public double getStudMarks() {
		return studMarks;
	}

	public void setStudMarks(double studMarks) {
		this.studMarks = studMarks;
	}

	@Override
	public String toString() {
		return "Student [studName=" + studName + ", studAge=" + studAge + ", studAddress=" + studAddress
				+ ", studMarks=" + studMarks + "]";
	}

}
