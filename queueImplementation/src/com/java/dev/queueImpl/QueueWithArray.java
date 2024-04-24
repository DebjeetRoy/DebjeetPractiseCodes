package com.java.dev.queueImpl;

public class QueueWithArray {
	static class MyQueue {
		static int front;
		static int rear;
		static int arr[] = new int[100005];

		MyQueue() {
			front = -1;
			rear = -1;
		}

		public static boolean isEmpty() {
			return front == -1;
		}

		public static boolean isFull() {
			return rear == arr.length - 1;
		}

		void push(int a) {
			if (isFull()) {
				System.out.println("Queue is full");
			}
			if (isEmpty()) {
				front = 0;
			}

			rear = rear + 1;
			arr[rear] = a;
		}

		int pop() {
			// You can code here
			if (isEmpty()) {
				System.out.println("Queue is Empty");
				return -1;
			}
			int temp = arr[front];
			if (front == rear) {
				front = rear = -1;
			}
			front++;
			return temp;
		}

		public static void printQueue() {
			if (isEmpty())
				return;

			for (int i = front; i <= rear; i++) {
				System.out.print(arr[i]);
			}
		}

		int peek() {
			return arr[front];
		}
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(2);
		queue.push(3);
		queue.pop();
		queue.push(4);
		queue.pop();
		MyQueue.printQueue();
	}
}
