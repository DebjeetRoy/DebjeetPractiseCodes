package com.dev.java.Lambda;

public class ThreadUsingRunnable {

	public static void main(String[] args) {
		Runnable r = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Thread execution... " + i);
			}
		};

		Thread t1 = new Thread(r);
		t1.start();

		for (int j = 0; j < 10; j++) {
			System.out.println("Main thread " + j);
		}
	}
}
