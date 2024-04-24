package com.java.linkedList;

import com.java.linkedList.MiddleNodeLinkedList.MyNode;

public class LongestPalindrome {

	public static int longestPalindrome(MyNode head) {
		// Base case
		if (head == null)
			return 0;
		if (head.next == null)
			return 1;

		// Logic
		MyNode curr = head;
		MyNode prev = null;
		int ans = 0;

		while (null != curr) {
			MyNode next = curr.next;
			curr.next = prev;

			int commonIfcurrIsExactCenter = countCommon(prev, next);
			int lengthFromExactCenter = 2 * commonIfcurrIsExactCenter + 1;

			int commonIfcurrIsNotExactCenter = countCommon(curr, next);
			int lengthFromNotExactCenter = 2 * commonIfcurrIsNotExactCenter;

			int largestOfTheseTwoLengths = Math.max(lengthFromExactCenter, lengthFromNotExactCenter);
			ans = Math.max(ans, largestOfTheseTwoLengths);
			prev = curr;
			curr = next;
		}
		return ans;
	}

	private static int countCommon(MyNode a, MyNode b) {
		int count = 0;
		while (a != null && b != null) {
			if (a.val == b.val) {
				count++;
				a = a.next;
				b = b.next;
			} else
				break;
		}
		return count;
	}

	public static void main(String[] args) {
		MyNode head1 = new MyNode(1);
		head1.next = new MyNode(2);
		head1.next.next = new MyNode(3);
		head1.next.next.next = new MyNode(3);
		head1.next.next.next.next = new MyNode(2);
		head1.next.next.next.next.next = new MyNode(4);

		System.out.println(longestPalindrome(head1));
	}
}
