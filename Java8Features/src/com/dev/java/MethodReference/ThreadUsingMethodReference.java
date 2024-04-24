package com.dev.java.MethodReference;

public class ThreadUsingMethodReference {

	public void a1() {
		for (int i = 0; i < 10; i++) {
			System.out.println("a1() is called");
		}
	}

	public static void main(String[] args) {

		ThreadUsingMethodReference th = new ThreadUsingMethodReference();
		Runnable r = th::a1;

		Thread t1 = new Thread(r);
		t1.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("Main thread continues...");
		}
	}
}
