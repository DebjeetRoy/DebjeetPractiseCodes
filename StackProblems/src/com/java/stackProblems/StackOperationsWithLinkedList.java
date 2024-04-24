package com.java.stackProblems;

public class StackOperationsWithLinkedList {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static class StackCustomClass {
		static Node head = null;

		public boolean isEmpty() {
			return head == null;
		}

		// push
		public void push(int data) {
			Node newNode = new Node(data);
			if (isEmpty()) {
				head = newNode;
				return;
			} else {
				newNode.next = head;
				head = newNode;
			}
		}

		// pop
		public int pop() {
			if (isEmpty()) {
				return -1;
			}

			int top = head.data;
			head = head.next;
			return top;
		}

		// peek
		public int peek() {
			if (isEmpty()) {
				return -1;
			}
			return head.data;
		}
	}

	public static void main(String[] args) {
		StackCustomClass stackOperation = new StackCustomClass();

		stackOperation.push(1);
		stackOperation.push(2);
		stackOperation.push(3);
		stackOperation.push(4);
		stackOperation.push(5);

		while (!stackOperation.isEmpty()) {
			System.out.println(stackOperation.peek());
			stackOperation.pop();
		}
	}
}
