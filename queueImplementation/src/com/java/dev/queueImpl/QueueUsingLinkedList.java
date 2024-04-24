package com.java.dev.queueImpl;

public class QueueUsingLinkedList {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static class Queue {
		static Node head = null;
		static Node tail = null;

		public boolean isEmpty() {
			if (head == null && tail == null) {
				return true;
			}
			return false;
		}

		public void add(int data) { // O(1)
			Node newNode = new Node(data);

			if (head == null) {
				head = tail = newNode;
			}
			tail.next = newNode;
			tail = newNode;
		}

		public int remove() { // O(1)
			if (isEmpty()) {
				System.out.println("Queue is empty !!");
				return -1;
			}
			int front = head.data;
			if (tail == head) {
				tail = head = null;
			} else {
				head = head.next;
			}
			return front;
		}

		public int peek() {// O(1)
			if (head == null) {
				System.out.println("Queue is empty !!");
				return -1;
			}
			return head.data;
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.add(10);
		q.remove();
		q.add(20);
		q.remove();
		q.add(30);
		q.remove();
		q.add(40);
		// System.out.println(q.remove());

		while (!q.isEmpty()) {
			System.out.println(q.peek() + " ");
			q.remove();
		}
	}
}
