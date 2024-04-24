package com.dev.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dev.Stream.Employee.Subject;

class Student {
	private String id;
	private String name;
	private List<Subject> subjects;

	Student(String id, String name, List<Subject> subjects) {
		this.id = id;
		this.name = name;
		this.subjects = subjects;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", subjects=" + subjects + "]";
	}
}

public class CountOfSubjects {
	public static void main(String[] args) {
		final List<Subject> al1 = new ArrayList<>();
		final Subject s1 = new Subject("1", "Chemistry");
		final Subject s2 = new Subject("2", "Physics");
		final Subject s3 = new Subject("3", "Maths");
		final Subject s4 = new Subject("4", "Sanskrit");
		final Subject s5 = new Subject("5", "Bio");
		final Subject s6 = new Subject("6", "Geo");
		final Subject s7 = new Subject("7", "History");
		final Subject s8 = new Subject("8", "Commerce");

		al1.add(s1);
		al1.add(s2);
		al1.add(s3);

		final List<Subject> al2 = new ArrayList<>();
		al2.add(s4);
		al2.add(s2);
		al2.add(s5);

		final List<Subject> al3 = new ArrayList<>();
		al3.add(s6);
		al3.add(s7);
		al3.add(s5);
		al3.add(s8);

		final List<Subject> al4 = new ArrayList<>();
		al4.add(s1);
		al4.add(s2);
		al4.add(s8);

		final Student stud1 = new Student("ST1", "Raj", al1);
		final Student stud2 = new Student("ST2", "Prakhar", al2);
		final Student stud3 = new Student("ST3", "Dev", al3);
		final Student stud4 = new Student("ST4", "Amy", al4);

		final List<Student> studList = new ArrayList<>();
		studList.add(stud1);
		studList.add(stud2);
		studList.add(stud3);
		studList.add(stud4);

		// Students with number of subjects List
//		studList.stream()
//				.collect(Collectors.groupingBy(Student::getId,
//				Collectors.mapping(x -> x.getSubjects().size(), Collectors.toList())))
//				.entrySet().stream()
//				.forEach(System.out::println);

		studList.stream().collect(
				Collectors.groupingBy(Student::getSubjects, Collectors.mapping(x -> x.getName(), Collectors.toList())))
				.entrySet().stream().forEach(x -> {
					System.out.println(x.getValue() + " -> " + x.getKey());
				});
	}
}
