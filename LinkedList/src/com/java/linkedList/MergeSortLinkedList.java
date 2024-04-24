package com.java.linkedList;

public class MergeSortLinkedList {
	public static Node head;
	public static Node tail;
	public static int size = 0;

	/*
	 * Add nodes in first position
	 */
	public void addFirst(int data) {
		Node newNode = new Node(data);
		size++;

		if (head == null) {
			head = tail = newNode;
			return;
		}
		newNode.next = head; // link
		head = newNode;
	}

	/*
	 * Add nodes in last position
	 */
	public void addLast(int data) {
		Node newNode = new Node(data);
		size++;

		if (head == null) {
			head = tail = newNode;
			return;
		}
		tail.next = newNode;
		tail = newNode;
	}

	/*
	 * Printing LinkedList
	 */
	public void printLinkedList() {
		if (null == head) {
			System.out.println("Linked List is empty !!");
		}
		Node temp = head;

		while (null != temp) {
			System.out.print(temp.data);
			temp = temp.next;
			if (temp != null) {
				System.out.print(" -> ");
			}
		}
	}

	/*
	 * Functionality to impplement Merge Sort
	 */
	public Node mergeSort(Node head) { // TC = O(nlogn)
		if (head == null || head.next == null) {
			return head;
		}

		// find mid
		Node mid = getMid(head);

		// left and right separation
		Node rightHead = mid.next;
		mid.next = null;
		Node newLeft = mergeSort(head);
		Node newRight = mergeSort(rightHead);

		// merge two linkedlist by comparing two lists
		return merge(newLeft, newRight).next;
	}

	/*
	 * Function to merge two halves
	 */
	private Node merge(Node head1, Node head2) {
		Node mergedLL = new Node(-1);
		Node temp = mergedLL;

		while (null != head1 && null != head2) {
			if (head1.data <= head2.data) {
				temp.next = head1;
				head1 = head1.next;
				temp = temp.next;
			} else {
				temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
			}
		}

		while (null != head1) {
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		while (null != head2) {
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}

		return mergedLL;
	}

	/*
	 * Get middle position value from a linked list
	 */
	private Node getMid(Node head) {
		Node slow = head;
		Node fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static void main(String[] args) {
		System.out.println("LL before sorting");

		MergeSortLinkedList ll = new MergeSortLinkedList();
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(4);
		// ll.addFirst(5);

		ll.printLinkedList();

		System.out.println();

		System.out.println("LL after sorting");

		MergeSortLinkedList.head = ll.mergeSort(MergeSortLinkedList.head);
		ll.printLinkedList();
	}
}
