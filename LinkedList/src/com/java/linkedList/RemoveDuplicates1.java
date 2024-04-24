package com.java.linkedList;

import com.java.linkedList.MiddleNodeLinkedList.MyNode;

public class RemoveDuplicates1 {

	public static MyNode removeDuplicate(MyNode head) {
		MyNode original = head;
		MyNode newHead = null;
		MyNode temp = head;

		while (original != null) {
			while (original.next != null && original.val == original.next.val) {
				original = original.next;
			}

			if (newHead == null) {
				newHead = temp = original;
			} else {
				temp.next = original;
				temp = original;
			}
			original = original.next;
		}
		return newHead;
	}

	public static void main(String[] args) {
		MyNode head = new MyNode(1);
		MyNode node2 = new MyNode(2);
		MyNode node3 = new MyNode(2);
		MyNode node4 = new MyNode(2);
		MyNode node5 = new MyNode(3);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		System.out.println("Original LinkedList : ");
		printLinkedList(head);

		System.out.println();

		System.out.println("LinkedList without Duplicates : ");
		MyNode newNode = removeDuplicate(head);

		printLinkedList(newNode);
	}

	public static void printLinkedList(MyNode temp) {
		while (temp != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}
}
