package com.dev.java.HeapProblems;

public class MaxHeap {
	int[] a;
	int capacity;
	int size;

	public MaxHeap(int capacity) {
		this.capacity = capacity;
		a = new int[capacity];
		size = 0;
	}

	// O(log n)
	public boolean insert(int e) {
		if (size == capacity)
			return false;

		a[size] = e;
		int i = size;

		while (i > 0) {
			int parent = (i - 1) / 2;
			if (a[parent] < a[i]) {
				swap(i, parent);
				i = parent; // Swim up or Heapify up
			} else
				break;
		}
		size++;
		return true;
	}

	// TC = O(n)
	// largest element is swapped with last element in maxheap to maintain complete
	// Binary Tree
	public int pop() throws Exception {
		if (size == 0)
			throw new Exception("Empty PQ");

		size--;
		int temp = a[0];
		a[0] = a[size];
		heapify(0);
		return temp;
	}

	public void heapify(int i) {
		if (i >= size)
			return;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		int larger = i;

		if (left < size && a[left] > a[i]) {
			larger = left;
		}
		if (right < size && a[right] > a[larger]) {
			larger = right;
		}
		if (larger != i) {
			swap(larger, i);
			heapify(larger);
		}
	}

	public void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/////////////////// Priority Queue 2///////////////////

	// O(n)
	public void buildHeap(int[] b) {
		if (b.length > capacity)
			return;

		for (int i = 0; i < b.length; i++) {
			a[i] = b[i];
		}
		size = b.length;

		// Calling heap from last element and last is leaf node for which there are
		// no children so no work is being done so i=size/2 - 1 instead of size-1.
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(i);
		}

		for (int i = 0; i < b.length; i++) {
			b[i] = a[i];
		}
	}

	/*
	 * Heap Sort
	 */
	public void heapSort(int[] b) throws Exception {
		buildHeap(b);
		for (int i = b.length - 1; i >= 0; i--) {
			b[i] = pop();
		}
	}
}
