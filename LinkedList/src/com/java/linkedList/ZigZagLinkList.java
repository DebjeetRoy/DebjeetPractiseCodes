package com.java.linkedList;

public class ZigZagLinkList {
	public static Node head;
	public static Node tail;
	public static int size = 0;

	public void zigzag() {
		// find middle
		Node slow = head;
		Node fast = head.next;

		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node mid = slow;

		// reverse 2nd half
		Node curr = mid.next;
		mid.next = null;
		Node prev = null;
		Node next;

		while (null != curr) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		Node left = head;
		Node right = prev;
		Node nextLeft, nextRight;

		// alternate merging(zig-zag merge)
		while (left != null && right != null) {
			// Zig Zag printing
			nextLeft = left.next;
			left.next = right;
			nextRight = right.next;
			right.next = nextLeft;

			// Update left and right node values
			left = nextLeft;
			right = nextRight;
		}
	}

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

	public static void main(String[] args) {
		ZigZagLinkList ll = new ZigZagLinkList();

		System.out.println("Original linked list");
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		ll.addLast(6);

		ll.printLinkedList();
		System.out.println();

		System.out.println("Linked list after Zig-Zag");
		ll.zigzag();
		ll.printLinkedList();
	}
}
