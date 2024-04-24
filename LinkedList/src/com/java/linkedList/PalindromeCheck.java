package com.java.linkedList;

//Slow-fast pointer
public class PalindromeCheck {
	public static Node head;
	public static Node tail;
	public static int size = 0;

	/*
	 * Add nodes in first position
	 */
	public void addFirst(int data) {
		Node newNode = new Node(data);
		size++;

		if (head == null) {
			head = tail = newNode;
			return;
		}
		newNode.next = head; // link
		head = newNode;
	}

	/*
	 * Add nodes in last position
	 */
	public void addLast(int data) {
		Node newNode = new Node(data);
		size++;

		if (head == null) {
			head = tail = newNode;
			return;
		}
		tail.next = newNode;
		tail = newNode;
	}

	/*
	 * Add nodes in specific position
	 */
	public void add(int index, int data) {
		if (index == 0) {
			addFirst(data);
			return;
		}
		Node newNode = new Node(data);
		size++;

		Node temp = head;
		int i = 0;

		while (i < index - 1) {
			temp = temp.next;
			i++;
		}

		newNode.next = temp.next;
		temp.next = newNode;
	}

	/*
	 * Finding middle element for checking palindrome
	 */
	public static Node findMid(Node head) {
		Node slow = head;
		Node fast = head;

		while (null != fast && null != fast.next) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	/*
	 * Checking Palindrome of a given LinkedList
	 */
	public static boolean checkPalindrome() {
		if (null == head || null == head.next) {
			return true;
		}

		// Step-1 find mid element
		Node midNode = findMid(head);

		// Step-2 reverse second half
		Node prev = null;
		Node curr = midNode;
		Node next;

		while (null != curr) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		Node right = prev; // right half head
		Node left = head; // left half head

		// Step-3 compare to find palindrome or not
		while (null != right) {
			if (left.data != right.data) {
				return false;
			}
			left = left.next;
			right = right.next;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromeCheck linkList = new PalindromeCheck();

		linkList.addLast(1);
		linkList.addLast(2);
		linkList.addLast(2);
		linkList.addLast(2);
		linkList.addLast(1);

		if (checkPalindrome()) {
			System.out.println("Linked List is Palindrome");
		} else {
			System.out.println("Linked List is not Palindrome");
		}
	}
}
