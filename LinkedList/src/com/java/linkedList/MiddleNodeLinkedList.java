package com.java.linkedList;

public class MiddleNodeLinkedList {
	static class MyNode {
		int val;
		MyNode next;

		public MyNode(int val) {
			this.val = val;
		}
	}

	public static MyNode findMiddleNode(MyNode head) {
		MyNode slow = head;
		MyNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		MyNode head = new MyNode(1);
		MyNode node2 = new MyNode(2);
		MyNode node3 = new MyNode(3);
		MyNode node4 = new MyNode(4);
		// MyNode node5 = new MyNode(5);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		// node4.next = node5;

		System.out.println(findMiddleNode(head).val);
	}
}
