package com.java.linkedList;

import com.java.linkedList.MiddleNodeLinkedList.MyNode;

public class ReorderLL {

	public static MyNode reorderLL(MyNode head) {
		MyNode slow = head;
		MyNode fast = head;

		// Finding out middle node after which rest needs to be reversed
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		MyNode l2 = ReverseLL.reverseList(slow);
		MyNode l1 = head;

		while (true) {
			if (l1 == l2) {
				l1.next = null;
				break;
			}
			if (l2 == null) {
				l1.next = null;
				break;
			}
			MyNode l1Next = l1.next;
			MyNode l2Next = l2.next;

			l1.next = l2;
			l2.next = l1Next;

			l1 = l1Next;
			l2 = l2Next;
		}
		return head;
	}

	private static void printLinkedList(MyNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyNode head = new MyNode(1);
		MyNode n1 = new MyNode(2);
		MyNode n2 = new MyNode(3);
		MyNode n3 = new MyNode(4);

		head.next = n1;
		n1.next = n2;
		n2.next = n3;

		System.out.println("Original LinkedList => ");
		printLinkedList(head);

		System.out.println("Linkedlist after reordering => ");
		MyNode reordered = reorderLL(head);
		printLinkedList(reordered);
	}
}
