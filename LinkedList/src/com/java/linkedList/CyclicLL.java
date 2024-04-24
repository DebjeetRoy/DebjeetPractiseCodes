package com.java.linkedList;

import java.util.LinkedHashSet;
import java.util.Objects;

public class CyclicLL {
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
			val = 0;
			next = null;
		}

		ListNode(int val) {
			this.val = val;
			next = null;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public int hashCode() {
			return Objects.hash(val);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ListNode other = (ListNode) obj;
			return val == other.val;
		}
	}

	public static ListNode cyclicNode(ListNode head) {
		LinkedHashSet<ListNode> hashSet = new LinkedHashSet<>();

		while (head != null) {
			if (hashSet.contains(head)) {
				return head;
			} else {
				hashSet.add(head);
			}
			head = head.next;
		}
		return null;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);

		ListNode cyclicPoint = cyclicNode(head);

		if (cyclicPoint == null) {
			System.out.println("-1");
		} else
			System.out.println(cyclicPoint.val);
	}
}
