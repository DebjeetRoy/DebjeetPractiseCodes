package com.java.MultipleInhExample;

public class Main {

	public static void main(String[] args) {
		Animal ref1 = new Fish();
		Animal ref2 = new Dog();

		ref1.livesIn();
		ref2.livesIn();
	}
}
