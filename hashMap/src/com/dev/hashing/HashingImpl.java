package com.dev.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashingImpl {

	static class Student {
		private int studId;
		private String studName;
		private String studAddress;

		public Student(int studId, String studName, String studAddress) {
			this.studId = studId;
			this.studName = studName;
			this.studAddress = studAddress;
		}

		public int getStudId() {
			return studId;
		}

		public void setStudId(int studId) {
			this.studId = studId;
		}

		public String getStudName() {
			return studName;
		}

		public void setStudName(String studName) {
			this.studName = studName;
		}

		public String getStudAddress() {
			return studAddress;
		}

		public void setStudAddress(String studAddress) {
			this.studAddress = studAddress;
		}

		@Override
		public String toString() {
			return "Student [studId=" + studId + ", studName=" + studName + ", studAddress=" + studAddress + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(studAddress, studId, studName);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			return Objects.equals(studAddress, other.studAddress) && studId == other.studId
					&& Objects.equals(studName, other.studName);
		}
	}

	public static void main(String[] args) {
		Student s1 = new Student(101, "Dev", "UP");
		Student s2 = new Student(101, "Dev", "UP");

		System.out.println("s1 hashcode : " + s1.hashCode());
		System.out.println("s2 hashcode : " + s2.hashCode());

		String s = "AB";
		System.out.println(s.hashCode()); // hash = s.charAt(i)*31 + s.charAt(i+1)

		int[] arr = { 2, 4, 1, 6, 1, 2 };
		System.out.println(distinct(arr, arr.length));
	}

	public static int distinct(int[] arr, int len) {
		// You can code here
		int distinctCount = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.get(arr[i]) == null ? 1 : map.get(arr[i]) + 1);
		}

		return map.size();
	}
}
