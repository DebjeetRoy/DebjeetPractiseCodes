package com.java.dev.queueImpl.PriorityQueue;

import java.util.PriorityQueue;

class Student implements Comparable<Student> {
	private String studId;
	private String studName;
	private int studRank;

	public Student(String studId, String studName, int studRank) {
		this.studId = studId;
		this.studName = studName;
		this.studRank = studRank;
	}

	public String getStudId() {
		return studId;
	}

	public void setStudId(String studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getStudRank() {
		return studRank;
	}

	public void setStudRank(int studRank) {
		this.studRank = studRank;
	}

	@Override
	public int compareTo(Student st) {
		return this.studRank - st.studRank;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studRank=" + studRank + "]";
	}
}

public class PriorityQueueForObjects {
	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<>();

		Student st1 = new Student("ST101", "Raj", 100);
		Student st2 = new Student("ST102", "Mahesh", 90);
		Student st3 = new Student("ST103", "Dev", 70);
		Student st4 = new Student("ST104", "Rajesh", 74);

		pq.add(st1);
		pq.add(st2);
		pq.add(st3);
		pq.add(st4);

		while (!pq.isEmpty()) {
			System.out.println(pq.peek().getStudName() + " -> " + pq.peek().getStudRank());
			pq.remove();
		}
	}
}
