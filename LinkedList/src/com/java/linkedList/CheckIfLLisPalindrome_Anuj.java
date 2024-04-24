package com.java.linkedList;

import com.java.linkedList.MiddleNodeLinkedList.MyNode;

public class CheckIfLLisPalindrome_Anuj {

	// Finding Middle node
	private static MyNode findMiddleNode(MyNode head) {
		if (head == null) {
			return head;
		}

		MyNode slow = head;
		MyNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static void printLinkedList(MyNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println();
	}

	public static boolean isPalin(MyNode head) {
		MyNode middleNode = findMiddleNode(head);
		// System.out.println(middleNode.val);
		MyNode t2 = ReverseLL.reverseLLrecursive(middleNode);
		MyNode t1 = head;

		while (t2 != null) {
			if (t1.val != t2.val) {
				return false;
			}
			t1 = t1.next;
			t2 = t2.next;
		}
		return true;
	}

	public static void main(String[] args) {
		MyNode head1 = new MyNode(1);
		head1.next = new MyNode(2);
		head1.next.next = new MyNode(3);
		head1.next.next.next = new MyNode(3);
		head1.next.next.next.next = new MyNode(2);
		head1.next.next.next.next.next = new MyNode(1);

		System.out.println("Original LL => ");
		printLinkedList(head1);

		System.out.println(isPalin(head1));
	}
}
