package com.dev.java.BinaryTrees;

public class ConvertBinaryTreeToDoublyLL {
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	static Node convertBinaryTreeToDoublyLL(Node root) {
		if (root == null)
			return null;

		convertBinaryTreeToDoublyLLUtil(root);
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	static Node convertBinaryTreeToDoublyLLUtil(Node root) {
		if (root == null)
			return null;

		// Handling left side of the root
		// Inorder Successor of current root
		if (root.left != null) {
			Node leftRoot = convertBinaryTreeToDoublyLLUtil(root.left);

			while (leftRoot.right != null) {
				leftRoot = leftRoot.right;
			}
			leftRoot.right = root;
			root.left = leftRoot;
		}

		// Handling right side of the root
		// Inorder Successor of current root
		if (root.right != null) {
			Node rightRoot = convertBinaryTreeToDoublyLLUtil(root.right);

			while (rightRoot.left != null) {
				rightRoot = rightRoot.left;
			}
			rightRoot.left = root;
			root.right = rightRoot;
		}
		return root;
	}

	public static void main(String[] args) {
		Node n1 = new Node(5);
		Node n2 = new Node(4);
		Node n3 = new Node(8);
		Node n4 = new Node(11);
		Node n5 = new Node(13);
		Node n6 = new Node(4);
		Node n7 = new Node(7);
		Node n8 = new Node(2);
		Node n9 = new Node(1);

		Node root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;
		n3.right = n6;
		n4.left = n7;
		n4.right = n8;
		n6.right = n9;

		System.out.println("Converting Binary Tree to Doubly LL");

		Node head = convertBinaryTreeToDoublyLL(root);
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
	}
}
