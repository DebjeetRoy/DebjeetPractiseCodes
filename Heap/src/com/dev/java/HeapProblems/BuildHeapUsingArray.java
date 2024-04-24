package com.dev.java.HeapProblems;

public class BuildHeapUsingArray {
	public static void main(String[] args) {
		int[] b = { 5, 1, 8, 2, 3, 15 };

		MaxHeap mh = new MaxHeap(10);
		mh.buildHeap(b);
		for (int ele : b) {
			System.out.print(ele + " ");
		}
	}
}