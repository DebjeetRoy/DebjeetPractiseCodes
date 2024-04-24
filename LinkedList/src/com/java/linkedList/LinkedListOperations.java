package com.java.linkedList;

class Node {
	int data;
	Node next;
	Node previous;

	Node(int data) {
		this.data = data;
	}
}

public class LinkedListOperations {
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
	 * Add nodes in specific position
	 */
	public void add(int index, int data) {
		if (index == 0) {
			addFirst(data);
			return;
		}
		Node newNode = new Node(data);
		size++;

		Node temp = head;
		int i = 0;

		while (i < index - 1) {
			temp = temp.next;
			i++;
		}

		newNode.next = temp.next;
		temp.next = newNode;
	}

	/*
	 * Remove first element
	 */
	private int removeFirst() {
		if (size == 0) {
			System.out.println("Linked List is empty");
			return Integer.MIN_VALUE;
		} else if (size == 1) {
			int val = head.data;
			head = tail = null;
			size = 0;
			return val;
		}
		int value = head.data;
		head = head.next;
		size--;

		return value;
	}

	/*
	 * Remove last element
	 */
	private int removeLast() {
		if (size == 0) {
			System.out.println("Linked List is empty");
			return Integer.MIN_VALUE;
		} else if (size == 1) {
			int val = head.data;
			head = tail = null;
			size = 0;
			return val;
		}
		Node prev = head;
		for (int i = 0; i < size - 2; i++) {
			prev = prev.next;
		}
		int val = prev.next.data; // tail data
		prev.next = null;
		tail = prev;
		size--;
		return val;
	}

	private static int searchKey(int key) {
		Node temp = head;
		int index = 0;

		while (temp.next != null) {
			if (key == temp.data) {
				return index;
			}
			index++;
			temp = temp.next;
		}
		return -1;
	}

	private static int helper(Node head, int key) {
		// No data in linked list
		if (head == null) {
			return -1;
		}
		if (head.data == key) {
			return 0;
		}

		int index = helper(head.next, key);

		if (index == -1) {
			return -1;
		}

		return index + 1;
	}

	/*
	 * Recursive Approach
	 */
	private static int recursiveSearch(int key) {
		return helper(head, key);
	}

	/*
	 * reverse a Linked List
	 */
	private static void reverse() { // O(n)
		Node prev = null;
		Node curr = tail = head;
		Node next;

		while (null != curr) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	public static void deleteNthNodeFromEnd(int n) {
		// calculate size
		int sz = 0;
		Node temp = head;
		while (null != temp) {
			temp = temp.next;
			sz++;
		}

		if (n == sz) {
			head = head.next; // delete first
			return;
		}

		// sz-n = previous value after which my node will be deleted(curr)
		int i = 1;
		int itoFind = sz - n;
		Node prev = head;

		while (i < itoFind) {
			prev = prev.next;
			i++;
		}
		prev.next = prev.next.next;
		return;
	}

	/*
	 * Printing LinkedList
	 */
	public static void printLinkedList() {
		if (null == head) {
			return;
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
		LinkedListOperations linkList = new LinkedListOperations();
		System.out.println("Linked List data -> ");
		linkList.addFirst(3);
		linkList.addFirst(2);
		linkList.addFirst(1);

		linkList.addLast(4);
		linkList.addLast(5);
		linkList.addLast(6);

		linkList.add(2, 9);
		linkList.removeFirst();
		linkList.removeLast();

		printLinkedList();
		System.out.println();

//		int key = 3;
//		int searchPos = searchKey(key);
//
//		System.out.println("Position -> " + searchPos);
//		if (searchPos == -1) {
//			System.out.println(key + " is not present in linked list");
//		} else {
//			System.out.println("Key " + key + " is found at " + searchPos + " position");
//		}
//
//		System.out.println("-------------- Recursive Approach---------------");
//		searchPos = recursiveSearch(key);
//		if (searchPos == -1) {
//			System.out.println(key + " is not present in linked list");
//		} else {
//			System.out.println("Key " + key + " is found at " + searchPos + " position");
//		}
//		System.out.println("Size -> " + size);

		reverse();
		System.out.println("Reversed linked List : ");
		printLinkedList();

		System.out.println();
//		int toBeDeleted = 3;
//		System.out.println("Deleting " + toBeDeleted + "th node from end");
//
//		deleteNthNodeFromEnd(toBeDeleted);
//		printLinkedList();

	}
}
