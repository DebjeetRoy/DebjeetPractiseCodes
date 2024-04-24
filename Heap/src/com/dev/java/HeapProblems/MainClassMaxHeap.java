package com.dev.java.HeapProblems;

public class MainClassMaxHeap {
	public static void main(String[] args) throws Exception {
		MaxHeap mh = new MaxHeap(10);
		mh.insert(50);
		mh.insert(100);
		mh.insert(10);

		System.out.println(mh.pop());
		mh.print();

		mh.insert(5);
		mh.insert(20);

		System.out.println(mh.pop());
		mh.print();
	}
}
