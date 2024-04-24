package com.javs.dev.PriorityQueue;

import java.util.PriorityQueue;

public class MergeKsortedLists {
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	// TC = O(NlogK) for K lists
	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
		for (ListNode head : lists) {
			if (head != null)
				pq.add(head);
		}

		ListNode dummy = new ListNode();
		ListNode tail = dummy;

		while (!pq.isEmpty()) {
			tail.next = pq.poll();
			tail = tail.next;

			if (tail.next != null) {
				pq.add(tail.next);
			}
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } };
		ListNode[] al = new ListNode[arr.length * arr[0].length];
		int i = 0;
		for (int[] ele : arr) {
			for (int value : ele) {
				al[i] = new ListNode(value);
				i++;
			}
		}

		ListNode res = mergeKLists(al);
		printListNodes(res);
	}

	private static void printListNodes(ListNode res) {
		while (res != null) {
			System.out.print(res.val + " -> ");
			res = res.next;
		}
		System.out.print("null");
	}
}
