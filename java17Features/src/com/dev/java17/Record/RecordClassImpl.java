package com.dev.java17.Record;

//class Alien {
//	private int studId;
//	private String studName;
//
//	public Alien(int studId, String studName) {
//		this.studId = studId;
//		this.studName = studName;
//	}
//
//	public int getStudId() {
//		return studId;
//	}
//
//	public String getStudName() {
//		return studName;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(studId, studName);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Alien other = (Alien) obj;
//		return studId == other.studId && Objects.equals(studName, other.studName);
//	}
//
//	@Override
//	public String toString() {
//		return "Alien [studId=" + studId + ", studName=" + studName + "]";
//	}
//}

/*
 * Only record class can extend record class
 * all fields are private, final as it's immutable in nature
 * all required fields should be kept within the parameters only.
 * There is no Getters and Setters so there will be no confusionon.
 */
record Alien(int studId, String studName) {
	public Alien {
		if (studId == 0) {
			throw new IllegalArgumentException("Student Id can't be 0");
		}
	}
}

public class RecordClassImpl {
	public static void main(String[] args) {
		Alien a1 = new Alien(1001, "Dev");
		Alien a2 = new Alien(1002, "Raj");
		// Alien a3 = new Alien(0, "Shyam");

		System.out.println(a1.equals(a2));
		System.out.println(a1);
		// System.out.println(a3);
		System.out.println("Student Id : " + a1.studId() + "Student Name : " + a1.studName());
	}
}
