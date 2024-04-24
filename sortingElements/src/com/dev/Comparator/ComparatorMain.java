package com.dev.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorMain {
	public static void main(String[] args) {
		Student st1 = new Student("STUD101", "Shruti", "Uttam Nagar, New Delhi", 86);
		Student st2 = new Student("STUD102", "Janvi", "Agra", 86);
		Student st3 = new Student("STUD103", "Abhit", "Kota", 86);
		Student st4 = new Student("STUD105", "Dev", "Bangalore", 86);
		Student st5 = new Student("STUD104", "Dev", "Rajasthan", 86);

		List<Student> studList = new ArrayList<>();
		studList.add(st1);
		studList.add(st2);
		studList.add(st3);
		studList.add(st4);
		studList.add(st5);

		System.out.println("----------------Sorting using Anonymous Inner Class---------------------");

		Collections.sort(studList, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				int value = o1.getStudentName().compareTo(o2.getStudentName());

				if (value != 0) {
					return value;
				} else {
					return o1.getStudentId().compareTo(o2.getStudentId());
				}
			}
		});

		for (Student stud : studList) {
			System.out.println(stud.getStudentId() + " " + stud.getStudentName() + " ");
		}
		System.out.println();
		System.out.println();

		System.out.println("----------------Sorting using Lambda---------------------");
		Collections.sort(studList, (stud1, stud2) -> {
			int value = ((Student) stud1).getStudentName().compareTo(((Student) stud2).getStudentName());

			if (value != 0) {
				return value;
			} else {
				return ((Student) stud1).getStudentId().compareTo(((Student) stud1).getStudentId());
			}
		});
		for (Student stud : studList) {
			System.out.println(stud.getStudentId() + " " + stud.getStudentName() + " ");
		}
		System.out.println();
		System.out.println();

		System.out.println("----------------Sorting using Streams---------------------");

		List<String> studNameList = studList.stream().sorted(Comparator.comparing(Student::getStudentName))
				.map(Student::getStudentName).collect(Collectors.toList());

		System.out.println(studNameList);
	}
}
