package com.java.linkedList;

import com.java.linkedList.MiddleNodeLinkedList.MyNode;

public class ReverseLL {

	public static MyNode reverseLLrecursive(MyNode head) {
		// Base case
		if (head == null || head.next == null) {
			return head;
		}

		MyNode headOfSubproblem = reverseLLrecursive(head.next);
		head.next.next = head;
		head.next = null;

		return headOfSubproblem;
	}

	public static MyNode reverseList(MyNode head) {
		// Base case
		if (head == null || head.next == null) {
			return head;
		}
		MyNode prev = null;
		MyNode curr = head;
		MyNode next = null;

		while (null != curr) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return head = prev;
	}

	public static void main(String[] args) {
		MyNode head = new MyNode(1);
		head.next = new MyNode(2);
		head.next.next = new MyNode(3);
		head.next.next.next = new MyNode(4);
		head.next.next.next.next = new MyNode(5);
		head.next.next.next.next.next = new MyNode(6);

		System.out.println("Original LinkedList => ");
		printLinkedList(head);

		System.out.println("Reversed LinkedList(Iterative Approach) => ");
		MyNode head1 = reverseList(head);
		printLinkedList(head1);

		System.out.println("Reversed LinkedList(Recursive Approach) => ");
		MyNode head2 = reverseLLrecursive(head1);
		printLinkedList(head2);
	}

	private static void printLinkedList(MyNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println();
	}
}
