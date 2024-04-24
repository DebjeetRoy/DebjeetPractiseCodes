package com.java.dev.queueImpl;

import java.util.LinkedList;
import java.util.Queue;

public class KconsecutiveBitFlips {
	public int minKBitFlips(int[] a, int k) {
		// You can code here

		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		int n = a.length;

		for (int i = 0; i < n; i++) {
			// odd condition
			if ((q.size() & 1) != 0) {
				a[i] = a[i] ^ 1;
			}
			if (a[i] == 0) {
				if (i + k > n) {
					return -1;
				}
				count++;
				q.offer(i + k - 1);
			}
			if (!q.isEmpty() && q.peek() == i) {
				q.poll();
			}
		}
		return count;
	}

	public static void main(String[] args) {

	}
}
