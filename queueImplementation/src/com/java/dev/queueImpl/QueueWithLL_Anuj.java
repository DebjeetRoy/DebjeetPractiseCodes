package com.java.dev.queueImpl;

public class QueueWithLL_Anuj {
	class QueueNode {
		int data;
		QueueNode next;

		QueueNode(int a) {
			data = a;
			next = null;
		}
	}

	QueueNode front;
	QueueNode rear;

	void push(int a) {
		// You can code here
		QueueNode newNode = new QueueNode(a);

		if (rear == null) {
			front = rear = newNode;
		}
		rear.next = newNode;
		rear = newNode;
	}

	int pop() {
		// You can code here
		if (front == null && rear == null) {
			return -1;
		}
		int value = front.data;

		if (rear == front) {
			rear = front = null;
		} else {
			front = front.next;
		}

		return value;
	}

	public static void main(String[] args) {
		QueueWithLL_Anuj q = new QueueWithLL_Anuj();
		q.push(10);
		q.pop();
		q.push(20);
		q.pop();
		q.push(30);
		q.pop();
		q.push(40);

		while (!q.isEmpty()) {
			System.out.println(q.peek() + " ");
			q.pop();
		}
	}

	private int peek() {
		return front.data;
	}

	private boolean isEmpty() {
		if (front == null && rear == null) {
			return true;
		}
		return false;
	}
}
