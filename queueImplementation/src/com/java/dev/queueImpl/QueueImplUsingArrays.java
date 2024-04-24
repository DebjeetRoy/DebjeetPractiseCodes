package com.java.dev.queueImpl;

public class QueueImplUsingArrays {
	static class Queue {
		static int arr[];
		static int size;
		static int rear;

		Queue(int n) {
			arr = new int[n];
			size = n;
			rear = -1;
		}

		public static boolean isEmpty() {
			return rear == -1;
		}

		/*
		 * add in queue
		 */
		public void add(int data) { // O(1) - Enqueue
			if (rear == size - 1) {
				System.out.println("Queue is full");
				return;
			}

			rear = rear + 1;
			arr[rear] = data;
		}

		/*
		 * remove from queue
		 */
		public int remove() { // O(n) - Dequeue
			if (Queue.isEmpty()) {
				System.out.println("Empty Queue");
				return -1;
			}
			int front = arr[0];

			for (int i = 0; i < rear; i++) {
				arr[i] = arr[i + 1];
			}
			rear--;

			return front;
		}

		/*
		 * peek()
		 */
		public int peek() { // O(1) - Front
			if (isEmpty()) {
				System.out.println("Empty Queue");
				return -1;
			}
			return arr[0];
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue(5);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);

		while (!Queue.isEmpty()) {
			System.out.print(q.peek() + " ");
			q.remove();
		}
	}
}
