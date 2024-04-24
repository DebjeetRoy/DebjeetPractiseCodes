package com.java.MultipleInheritance;

public class Demo implements Run1, Run2 {

	/*
	 * Default implementation should be given for particular interface
	 */
	@Override
	public void view() {
		Run2.super.view();
		System.out.println(Run2.sum(5, 6));
	}
}
