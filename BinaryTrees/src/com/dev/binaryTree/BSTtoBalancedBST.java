package com.dev.binaryTree;

import java.util.ArrayList;

import com.dev.binaryTree.BinaryTree.Node;

public class BSTtoBalancedBST {
	public static void preorder(Node root) { // O(n)
		// base case
		if (null == root) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left); // left subtree
		preorder(root.right); // right subtree
	}

	public static void getInorder(Node root, ArrayList<Integer> al) {
		if (root == null) {
			return;
		}
		getInorder(root.left, al);
		al.add(root.data);
		getInorder(root.right, al);
	}

	public static Node createBST(ArrayList<Integer> al, int st, int end) {
		// Base case
		if (st > end) {
			return null;
		}

		int mid = (st + end) / 2;
		Node root = new Node(al.get(mid));
		root.left = createBST(al, st, mid - 1);
		root.right = createBST(al, mid + 1, end);

		return root;
	}

	public static Node balancedBST(Node root) { // O(n)
		// inorder sequence
		ArrayList<Integer> inorder = new ArrayList<>();
		getInorder(root, inorder);

		// sorted inorder -> balanced BST
		root = createBST(inorder, 0, inorder.size() - 1);
		return root;
	}

	public static void main(String[] args) {
		Node root1 = new Node(8);
		root1.left = new Node(5);
		root1.right = new Node(11);
		root1.left.left = new Node(3);
		root1.left.right = new Node(6);
		root1.right.left = new Node(10);
		root1.right.right = new Node(12);

		root1 = balancedBST(root1);
		preorder(root1);
	}
}
