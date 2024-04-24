package com.java.linkedList;

import com.java.linkedList.MiddleNodeLinkedList.MyNode;

public class ReverseLLwithKgroups {

	public static void main(String[] args) {
		MyNode head = new MyNode(1);
		head.next = new MyNode(2);
		head.next.next = new MyNode(3);
		head.next.next.next = new MyNode(4);
		head.next.next.next.next = new MyNode(5);
		// head.next.next.next.next.next = new MyNode(6);

		System.out.println("Original LinkedList => ");
		printLinkedList(head);

		int k = 2;
		System.out.println("Reversing in groups of " + k);
		MyNode reverseGroup = reverseKgroups(head, k);
		printLinkedList(reverseGroup);
	}

	private static MyNode reverseKgroups(MyNode head, int k) {
		MyNode dummy = new MyNode(-1);
		dummy.next = head;

		MyNode prevTail = dummy;
		MyNode currHead = head;

		while (currHead != null) {
			MyNode currTail = findTailAfterK(currHead, k);
			if (currTail == null)
				break;

			MyNode nextHead = currTail.next;
			reverseKTimes(currHead, k);
			prevTail.next = currTail;
			prevTail = currHead;
			currHead = nextHead;
		}
		prevTail.next = currHead;
		return dummy.next;
	}

	private static MyNode findTailAfterK(MyNode head, int k) {
		for (int i = 0; i < k - 1; i++) {
			head = head.next;
			if (head == null)
				return null;
		}
		return head;
	}

	private static MyNode reverseKTimes(MyNode head, int k) {
		if (head == null || head.next == null)
			return head;

		MyNode curr = head;
		MyNode prev = null;
		int count = 0;

		while (count < k && curr != null) {
			MyNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		return prev;
	}

	private static void printLinkedList(MyNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println();
	}

}
