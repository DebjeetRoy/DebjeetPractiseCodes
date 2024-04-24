package com.java.dev.queueImpl;

import java.util.LinkedList;
import java.util.Queue;

public class CircularQueueUsingArray_AB {
	static class MyCircularQueue {
		static int front;
		static int rear;
		static int arr[] = new int[3];

		MyCircularQueue() {
			front = -1;
			rear = -1;
		}

		public static boolean isEmpty() {
			return front == -1;
		}

		public static boolean isFull() {
			if (rear == arr.length - 1 && front == 0)
				return true;

			return (rear + 1) == front;
		}

		void enqueue(int a) {
			if (isFull()) {
				System.out.println("Queue is full");
			}
			if (isEmpty()) {
				front = 0;
			}

			rear = (rear + 1) % arr.length;
			arr[rear] = a;
		}

		int dequeue() {
			// You can code here
			if (isEmpty()) {
				System.out.println("Queue is Empty");
				return -1;
			}
			int temp = arr[front];
			if (front == rear) {
				front = rear = -1;
			}
			front = (front + 1) % (arr.length - 1);
			return temp;
		}

		public static void printQueue() {
			if (isEmpty())
				return;

			// Case-1
			if (front <= rear) {
				for (int i = front; i <= rear; i++) {
					System.out.print(arr[i] + " ");
				}
			}

			// Case-2
			else if (rear < front) {
				for (int i = front; i < arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				for (int j = 0; j <= rear; j++) {
					System.out.print(arr[j] + " ");
				}
			}
		}

		int peek() {
			if (isEmpty()) {
				System.out.println("Queue is Empty !!");
				return -1;
			}
			return arr[front];
		}

		public static void main(String[] args) {
			MyCircularQueue queue = new MyCircularQueue();
			Queue<Integer> q = new LinkedList<>();
			queue.enqueue(2);
			queue.enqueue(3);
			queue.enqueue(4);
			queue.dequeue();
			queue.enqueue(5);
			MyCircularQueue.printQueue();
		}
	}
}
