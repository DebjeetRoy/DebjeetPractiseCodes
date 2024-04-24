package com.java.linkedList;

import com.java.linkedList.MiddleNodeLinkedList.MyNode;

public class AddTwoReversedLL {
	public static MyNode reverseList(MyNode head) {
		// Base case
		if (head == null || head.next == null) {
			return head;
		}
		MyNode prev = null;
		MyNode curr = head;
		MyNode next = null;

		while (null != curr) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return head = prev;
	}

	public static MyNode addTwoNumbers(MyNode l1, MyNode l2) {
		MyNode r1 = reverseList(l1);
		MyNode r2 = reverseList(l2);

		int carry = 0;
		MyNode ans = null;
		MyNode temp = null;

		while (r1 != null || r2 != null || carry != 0) {
			int sum = carry;
			if (r1 != null) {
				sum += r1.val;
				r1 = r1.next;
			}
			if (r2 != null) {
				sum += r2.val;
				r2 = r2.next;
			}
			int digit = sum % 10;
			carry = sum / 10;
			MyNode newNode = new MyNode(digit);

			if (ans == null) {
				ans = temp = newNode;
			} else {
				temp.next = newNode;
				temp = newNode;
			}
		}
		return reverseList(ans);
	}

	public static void printList(MyNode ans) {
		while (ans != null) {
			System.out.print(ans.val + " -> ");
			ans = ans.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyNode head1 = new MyNode(1);
		head1.next = new MyNode(2);
		head1.next.next = new MyNode(3);

		MyNode head2 = new MyNode(9);
		head2.next = new MyNode(4);

		System.out.println("1st LinkedList : ");
		printList(head1);

		System.out.println("2nd LinkedList : ");
		printList(head2);

		System.out.println("Sum of 2 LinkedList in reverse order : ");
		MyNode ans = addTwoNumbers(head1, head2);

		System.out.print("Sum is : ");
		printList(ans);
	}
}
