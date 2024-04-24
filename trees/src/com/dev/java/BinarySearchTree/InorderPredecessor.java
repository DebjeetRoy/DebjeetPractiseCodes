package com.dev.java.BinarySearchTree;

import com.dev.java.NodeInfo.Node;

public class InorderPredecessor {
	static Node inorderPredecessor(Node root, int key, Node predecessor) {
		if (root == null)
			return null;

		if (key < root.data) {
			// GO to left
			return inorderPredecessor(root.left, key, predecessor);
		} else if (key > root.data) {
			// GO to right
			predecessor = root;
			return inorderPredecessor(root.right, key, predecessor);
		} else {
			if (root.left == null)
				return predecessor;
			else
				return getMax(root.left);
		}
	}

	static Node getMax(Node root) {
		while (root.right != null) {
			root = root.right;
		}
		return root;
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

		int key = 4;
		Node predecessor = inorderPredecessor(root, key, null);
		if (predecessor == null)
			System.out.println("Predecessor not found !!");
		else
			System.out.println("Inorder Predecessor of given BST with key = " + key + " is : " + predecessor.data);
	}
}
