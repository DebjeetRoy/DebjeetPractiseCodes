package com.dev.java.Consumer;

import java.util.function.Consumer;

public class Demo {
	public static void main(String[] args) {
		Consumer<String> c = s -> System.out.print(s + " ");
		Consumer<String> c1 = s -> System.out.print(s.charAt(0) + " Have a great day !!");
		c.andThen(c1).accept("Demo class");
	}
}
