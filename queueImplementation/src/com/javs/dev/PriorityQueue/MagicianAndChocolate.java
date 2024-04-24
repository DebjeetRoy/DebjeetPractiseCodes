package com.javs.dev.PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolate {

	public static int magicianAndChocolates(int A, ArrayList<Integer> B) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (Integer ele : B) {
			pq.add(ele);
		}
		int sum = 0;

		while (!pq.isEmpty() && A != 0) {
			Integer ele = pq.peek();
			sum += pq.poll();
			pq.add(ele / 2);
			A--;
		}
		return sum;
	}

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();

		al.add(10);
		al.add(8);
		al.add(6);
		al.add(4);
		al.add(2);

		System.out.println("Maximum amount of chocolates kid can have = " + magicianAndChocolates(5, al));
	}
}
