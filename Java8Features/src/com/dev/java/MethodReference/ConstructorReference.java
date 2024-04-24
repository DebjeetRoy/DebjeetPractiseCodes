package com.dev.java.MethodReference;

import java.util.Optional;

public class ConstructorReference {
	public static void main(String[] args) {
		// Creating a Constructor Reference
		SampleInterfceRef ref = Sample::new;
		Sample sample = ref.fetch();
	}
}

class Sample {
	Sample() {
		int[] a = { 9, 5, 6 };
		Optional.ofNullable(a).get();
		System.out.println("Constructor of Sample class");
	}
}
