package com.java.dev.queueImpl;

public class QueueImplUsingCircularArray {
	static class Queue {
		static int arr[];
		static int size;
		static int rear;
		static int front;

		Queue(int n) {
			arr = new int[n];
			size = n;
			rear = -1;
			front = -1;
		}

		public static boolean isEmpty() {
			return rear == -1 && front == -1;
		}

		// next index of rear is front only.
		public static boolean isFull() {
			if (rear == arr.length - 1 && front == 0)
				return true;

			return rear + 1 == front;
		}

		/*
		 * add in queue
		 */
		public void add(int data) { // O(1) - Enqueue
			if (isFull()) {
				System.out.println("Queue is full");
				return;
			}

			// add 1st element
			if (front == -1) {
				front = 0;
			}
			rear = (rear + 1) % size;
			arr[rear] = data;
		}

		/*
		 * remove from queue
		 */
		public int remove() { // O(1) - Deque
			if (Queue.isEmpty()) {
				System.out.println("Empty Queue");
				return -1;
			}
			int result = arr[front];

			// last element to be deleted
			if (rear == front) {
				rear = front = -1;
			} else {
				front = (front + 1) % size;
			}
			return result;
		}

		/*
		 * peek()
		 */
		public int peek() { // O(1) - Front
			if (isEmpty()) {
				System.out.println("Empty Queue");
				return -1;
			}
			return arr[front];
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue(3);
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q.remove());
		q.add(4);
		System.out.println(q.remove());
		q.add(5);

		while (!q.isEmpty()) {
			System.out.println(q.peek() + " ");
			q.remove();
		}
	}
}
