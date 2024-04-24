package com.dev.java.BinaryTrees;

import com.dev.java.NodeInfo.Node;

public class HeightOfBinaryTree {

	public static int htOfBinaryTree(Node root) {
		if (root == null)
			return 0;

		int leftHt = htOfBinaryTree(root.left);
		int rightHt = htOfBinaryTree(root.right);

		return Math.max(leftHt, rightHt) + 1;
	}

	public static void main(String[] args) {
		Node n1 = new Node(9);
		Node n2 = new Node(4);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(7);
		Node n6 = new Node(5);

		Node root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;

		System.out.println("Height of Given Binary Tree = " + htOfBinaryTree(root));
	}
}
