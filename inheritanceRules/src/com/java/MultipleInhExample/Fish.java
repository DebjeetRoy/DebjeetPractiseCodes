package com.java.MultipleInhExample;

public class Fish implements Animal, Aquatic {

	@Override
	public void livesIn() {
		System.out.println("Hey !! I am Fish, an aquatic animal");
	}
}
