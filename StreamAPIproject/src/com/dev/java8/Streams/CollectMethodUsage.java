package com.dev.java8.Streams;

import java.util.ArrayList;
import java.util.List;

public class CollectMethodUsage {
	public static void main(String[] args) {
		List<Stud> studList = new ArrayList<>();
		Stud stud1 = new Stud("akar@gmail.com");
		Stud stud2 = new Stud("dev@gmail.com");
		studList.add(stud1);
		studList.add(stud2);

		// Using Lambda
		System.out.println("Using Lambda -> ");
		studList.stream().map(Stud::getEmailId)
				.collect(ArrayList::new, (list, element) -> list.add(element), (list1, list2) -> list1.addAll(list2))
				.forEach(System.out::println);

		System.out.println();

		// Using Method reference
		System.out.println("Using Method reference");
		studList.stream().map(Stud::getEmailId).collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
				.forEach(System.out::println);
	}
}

class Stud {
	private String emailId;

	public Stud(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
