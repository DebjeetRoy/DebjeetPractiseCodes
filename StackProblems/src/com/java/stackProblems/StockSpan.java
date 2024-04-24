package com.java.stackProblems;

import java.util.ArrayDeque;

public class StockSpan {

	public static int[] stockSpan(int[] a) {
		int n = a.length;
		int[] s = new int[n];

		s[0] = 1;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(0);

		// Break whenever any element is found greater than current element
		for (int i = 1; i < n; i++) {
			while (!stack.isEmpty()) {
				int top = stack.peek();
				if (a[top] > a[i]) {
					break;
				} else
					stack.pop();
			}
			if (stack.isEmpty())
				s[i] = i + 1;
			else
				s[i] = i - stack.peek();

			stack.push(i);
		}
		return s;
	}

	public static void main(String[] args) {
		int price[] = { 100, 80, 60, 70, 60, 75, 85 };
		int[] res = stockSpan(price);

		for (int element : res) {
			System.out.print(element + " ");
		}
	}
}
