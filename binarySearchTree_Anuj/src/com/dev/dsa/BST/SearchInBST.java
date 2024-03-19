package com.dev.dsa.BST;

public class SearchInBST {
	static boolean searchInBST(Node root, int key) {
		if (root == null)
			return false;

		if (root.data == key)
			return true;

		if (key < root.data)
			return searchInBST(root.left, key);

		if (key > root.data)
			return searchInBST(root.right, key);

		return false;
	}

	public static void main(String[] args) {
		Node n1 = new Node(8);
		Node n2 = new Node(3);
		Node n3 = new Node(10);
		Node n4 = new Node(1);
		Node n5 = new Node(6);
		Node n6 = new Node(14);
		Node n7 = new Node(4);
		Node n8 = new Node(7);

		Node root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		n5.left = n7;
		n5.right = n8;

		int key = 7;

		System.out.println(searchInBST(root, key));
	}
}
