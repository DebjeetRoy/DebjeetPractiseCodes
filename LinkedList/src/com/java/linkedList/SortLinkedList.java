package com.java.linkedList;

import com.java.linkedList.MiddleNodeLinkedList.MyNode;

public class SortLinkedList {

	public static void main(String[] args) {
		MyNode head = new MyNode(1);
		MyNode n1 = new MyNode(0);
		MyNode n2 = new MyNode(0);
		MyNode n3 = new MyNode(1);

		head.next = n1;
		n1.next = n2;
		n2.next = n3;

		System.out.println("Original LinkedList => ");
		RemoveDuplicates1.printLinkedList(head);

		System.out.println();

		System.out.println("LinkedList after Sorting => ");
		MyNode sortedNode = mergeSort(head);

		RemoveDuplicates1.printLinkedList(sortedNode);
	}

	// Merge Sort
	private static MyNode mergeSort(MyNode head) {
		// Base case
		if (head == null || head.next == null) {
			return head;
		}

		// find middle node
		MyNode middleNode = findMiddleNode(head);
		MyNode nextofMiddle = middleNode.next;

		// set the next of middle node to null
		middleNode.next = null;

		// Apply mergeSort on left list
		MyNode left = mergeSort(head);

		// Apply mergeSort on right list
		MyNode right = mergeSort(nextofMiddle);

		// Merge the left and right lists
		MyNode sortedlist = sortedMerge(left, right);

		return sortedlist;
	}

	// Merge sort Logic
	private static MyNode sortedMerge(MyNode left, MyNode right) {
		MyNode res = null;

		// Base case
		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		}

		if (left.val < right.val) {
			res = left;
			res.next = sortedMerge(left.next, right);
		} else {
			res = right;
			res.next = sortedMerge(left, right.next);
		}

		return res;
	}

	// Finding Middle node
	private static MyNode findMiddleNode(MyNode head) {
		if (head == null) {
			return head;
		}
		MyNode slow = head;
		MyNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
