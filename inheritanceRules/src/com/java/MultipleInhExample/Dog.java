package com.java.MultipleInhExample;

public class Dog implements Animal, Terrestrial {

	@Override
	public void livesIn() {
		System.out.println("Hey !! I am Dog, a terrestrial animal");
	}
}
