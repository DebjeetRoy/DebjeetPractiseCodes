package com.java.linkedList;

public class DoublyLinkList {
	public class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}

	public static Node head;
	public static Node tail;
	public static int size;

	public void addFirst(int data) {
		Node newNode = new Node(data);
		size++;

		if (null == head) {
			head = tail = newNode;
			return;
		}
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}

	public int removeFirst() {
		if (null == head) {
			System.out.println("Doubly LL is empty");
			return Integer.MIN_VALUE;
		}

		if (size == 1) {
			int val = head.data;
			head = tail = null;
			size--;
			return val;
		}

		int val = head.data;
		head = head.next;
		head.prev = null;
		size--;

		return val;
	}

	public void print() {
		Node temp = head;
		while (null != temp) {
			System.out.print(temp.data + " <-> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		DoublyLinkList dll = new DoublyLinkList();
		dll.addFirst(3);
		dll.addFirst(2);
		dll.addFirst(1);

		dll.print();
		System.out.println("Size of doubly LL : " + size);

		dll.removeFirst();

		dll.print();
		System.out.println("Size of doubly LL : " + size);
	}
}
