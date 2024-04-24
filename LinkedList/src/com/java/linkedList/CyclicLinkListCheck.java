package com.java.linkedList;

public class CyclicLinkListCheck {
	public static Node head;

	/*
	 * Logic to fetch cyclic loop(Floyd's algo)
	 */
	public static boolean isCycle() {
		if (null == head || null == head.next) {
			return false;
		}
		Node slow = head;
		Node fast = head;

		while (fast != null && null != fast.next) {
			fast = fast.next.next; // +2
			slow = slow.next; // +1

			if (fast == slow) {
				return true; // cycle exists
			}
		}
		return false; // cycle not exists
	}

	/*
	 * Remove Cyclicity of a LinkedList
	 */
	public static void removeCycle() {
		// detect cycle
		Node slow = head;
		Node fast = head;
		boolean cycle = false;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {
				cycle = true;
				break;
			}
		}
		if (cycle == false) {
			return;
		}

		// find meeting point
		slow = head;
		Node prev = null;
		while (slow != fast) {
			prev = fast;
			slow = slow.next;
			fast = fast.next;
		}

		// remove cycle => last.next = null
		prev.next = null; // last node set as null;
	}

	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = head.next;

		// 1->2->3->2

		if (isCycle()) {
			System.out.println("Linked List is Cyclic");
		} else {
			System.out.println("Linked List is not Cyclic");
		}

		removeCycle();

		System.out.println("After removing Cyclicity of LL");

		if (isCycle()) {
			System.out.println("Linked List is Cyclic");
		} else {
			System.out.println("Linked List is not Cyclic");
		}
	}
}
