package com.java.stackProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallerElementOnLeft {

	public static int[] smallerElementOnLeft(int[] a) {
		int[] ans = new int[a.length];

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				ans[i] = -1;
			} else {
				ans[i] = stack.peek();
			}
			stack.push(i);
		}
		return ans;
	}

	public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
		// You can code here
		int[] ans = new int[A.size()];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < A.size(); i++) {
			while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				ans[i] = -1;
			} else {
				ans[i] = stack.peek();
			}
			stack.push(i);
		}

		for (int val : ans) {
			al.add(val);
		}
		return al;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 6, 4, 10, 2, 4 };

		System.out.println("Given input array => ");
		for (int input : arr) {
			System.out.print(input + " ");
		}
		System.out.println();

		int[] ans = smallerElementOnLeft(arr);
		System.out.println("Next smaller element array => ");

		for (int element : ans) {
			System.out.print(element + " ");
		}
		System.out.println();

		System.out.println("----------- Using ArrayList -------------");
		List<Integer> al = Arrays.stream(arr).boxed().toList();
		ArrayList<Integer> res = prevSmaller(new ArrayList<>(al));

		for (Integer val : res) {
			System.out.print(val + " ");
		}
	}
}
