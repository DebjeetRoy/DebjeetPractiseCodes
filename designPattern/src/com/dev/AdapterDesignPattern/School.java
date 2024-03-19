package com.dev.AdapterDesignPattern;

public class School {

	public static void main(String[] args) {

		Pen pp = new PenAdapter();
		AssignmentWork aw = new AssignmentWork();
		aw.setPen(pp);
		aw.writeAssignment("Bit tired now");
	}
}
