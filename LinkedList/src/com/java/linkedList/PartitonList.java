package com.java.linkedList;

import com.java.linkedList.MiddleNodeLinkedList.MyNode;

public class PartitonList {
	// Partitioning the LinkedList by "b" by maintaining the order
	public static MyNode partition(MyNode head, int b) {
		if (head == null || head.next == null) {
			return head;
		}

		MyNode sHead = new MyNode(-1);
		MyNode lHead = new MyNode(-1);

		MyNode sTail = sHead;
		MyNode lTail = lHead;
		MyNode curr = head;

		while (curr != null) {
			if (curr.val < b) {
				sTail.next = curr;
				sTail = curr;
			} else {
				lTail.next = curr;
				lTail = curr;
			}
			curr = curr.next;
		}

		sTail.next = lHead.next;
		lTail.next = null;
		return sHead.next;
	}

	public static void main(String[] args) {
		int b = 3;

		MyNode head = new MyNode(1);
		head.next = new MyNode(4);
		head.next.next = new MyNode(3);
		head.next.next.next = new MyNode(2);
		head.next.next.next.next = new MyNode(5);
		head.next.next.next.next.next = new MyNode(2);

		partition(head, b);
	}
}
