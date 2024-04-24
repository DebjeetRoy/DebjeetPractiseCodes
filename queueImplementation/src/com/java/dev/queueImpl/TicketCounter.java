package com.java.dev.queueImpl;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TicketCounter {

	public static int distributeTicketRight(int N, int K) {
		// You can code here
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			dq.offerLast(i);
		}
		while (dq.size() > 1) {
			// Remove front K element
			int i = 1;
			while (dq.size() > 1 && i <= K) {
				dq.pollFirst();
				i++;
			}

			// remove last K element
			int j = 1;
			while (dq.size() > 1 && j <= K) {
				dq.pollLast();
				j++;
			}
		}
		return dq.pollFirst();
	}

	public static int distributeTicket(int N, int K) {
		// You can code here

		if (N == K) {
			return K;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		int ele = 0;

		while (!q.isEmpty()) {
			// Removing first K elements
			for (int i = 1; i <= K; i++) {
				q.remove();
			}

			Stack<Integer> s = new Stack<>();
			if (!q.isEmpty()) {
				while (!q.isEmpty()) {
					s.push(q.remove());
				}
				int stackSize = s.size();

				for (int j = 1; j <= stackSize; j++) {
					q.add(s.pop());
				}
				int i = 0;
				int queueSize = q.size();

				// Removing last K elements
				while (i < K && i < queueSize) {
					q.remove();
					i++;
				}
				if (q.size() == K) {
					ele = q.poll();
					break;
				}
			}
		}
		return ele;
	}

	public static void main(String[] args) {
		System.out.println(distributeTicketRight(9, 6));
	}
}
