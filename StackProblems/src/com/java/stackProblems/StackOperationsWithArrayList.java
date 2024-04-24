package com.java.stackProblems;

import java.util.ArrayList;
import java.util.List;

public class StackOperationsWithArrayList {

	static class StackCustom {
		static List<Integer> list = new ArrayList<>();

		public boolean isEmpty() {
			return list.size() == 0;
		}

		public void push(int data) {
			list.add(data);
		}

		public int pop() {
			if (isEmpty()) {
				return -1;
			}
			int top = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			return top;
		}

		public int peep() {
			if (isEmpty()) {
				return -1;
			}
			return list.get(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		StackCustom stackOperation = new StackCustom();

		stackOperation.push(1);
		stackOperation.push(2);
		stackOperation.push(3);
		stackOperation.push(4);
		stackOperation.push(5);

		while (!stackOperation.isEmpty()) {
			System.out.println(stackOperation.peep());
			stackOperation.pop();
		}
	}
}
