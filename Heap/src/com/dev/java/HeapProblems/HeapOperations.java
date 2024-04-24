package com.dev.java.HeapProblems;

import java.util.ArrayList;

public class HeapOperations {
	static class Heap {
		ArrayList<Integer> al = new ArrayList<>();

		public void insert(int data) { // O(logn)
			// add at last index
			al.add(data);
			int x = al.size() - 1; // child node index
			int parent = (x - 1) / 2;// parent index

			// Swapping to satisfy min-heap
			while (al.get(x) < al.get(parent)) {
				int temp = al.get(x);
				al.set(x, al.get(parent));
				al.set(parent, temp);
			}
		}

		public int peek() {
			return al.get(0); // root of all ancestors is peek part of BT
		}

		public int remove() {
			int data = al.get(0);

			// Step-1 : swap first and last
			int temp = al.get(0);
			al.set(0, al.get(al.size() - 1));
			al.set(al.size() - 1, temp);

			// Step-2 : Delete last
			al.remove(al.size() - 1);

			// Step-3 : Heapify
			heapify(0); // call for root
			return temp;
		}

		private void heapify(int i) {
			int left = 2 * i + 1; // i is considered as root element.
			int right = 2 * i + 2;
			int minIndex = i;

			// checking left part of root node
			if (left < al.size() && al.get(minIndex) > al.get(left)) {
				minIndex = left;
			}

			// checking right part of root node
			if (right < al.size() && al.get(minIndex) > al.get(right)) {
				minIndex = right;
			}

			// Checking if root is minimum or not, if not then swap
			if (minIndex != i) {
				int temp = al.get(i);
				al.set(i, al.get(minIndex));
				al.set(minIndex, temp);

				// recursive call to check for minimum root value
				heapify(minIndex);
			}
		}
	}

	public static void main(String[] args) {

	}
}
