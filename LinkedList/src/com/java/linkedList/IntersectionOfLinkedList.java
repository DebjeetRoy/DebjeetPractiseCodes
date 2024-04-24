package com.java.linkedList;

import com.java.linkedList.MiddleNodeLinkedList.MyNode;

public class IntersectionOfLinkedList {

	public static int findIntersection(MyNode head1, MyNode head2) {
		// You can code here
		MyNode temp2 = head2;
		int intersectionNode = 0;

		while (temp2 != null) {
			MyNode temp1 = head1;
			while (temp1 != null) {
				if (temp1.val == temp2.val) {
					return temp2.val;
				}
				temp1 = temp1.next;
			}
			temp2 = temp2.next;
		}

		return intersectionNode == 0 ? -1 : intersectionNode;
	}

	public static void main(String[] args) {
		MyNode head1 = new MyNode(1);
		head1.next = new MyNode(2);
		head1.next.next = new MyNode(3);
		head1.next.next.next = new MyNode(4);
		head1.next.next.next.next = new MyNode(2);

		MyNode head2 = new MyNode(9);
		head2.next = new MyNode(8);
		head2.next.next = new MyNode(7);
		head2.next.next.next = new MyNode(4);
		head2.next.next.next.next = new MyNode(2);

		System.out.println("Intersection point of given 2 LinkedList is => " + findIntersection(head1, head2));
	}
}
