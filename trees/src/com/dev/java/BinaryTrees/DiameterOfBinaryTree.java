package com.dev.java.BinaryTrees;

import com.dev.java.NodeInfo.Node;

public class DiameterOfBinaryTree {

	static int diameterOfTree(Node root) {
		if (root == null)
			return 0;

		int leftHt = height(root.left);
		int rightHt = height(root.right);

		int diameterMiddle = leftHt + rightHt;
		int leftDia = diameterOfTree(root.left);
		int rightDia = diameterOfTree(root.right);

		return Math.max(Math.max(leftDia, rightDia), diameterMiddle);
	}

	static int diameter = 0;

	static int height(Node root) {
		if (root == null)
			return 0;

		int heightLeft = height(root.left);
		int heightRight = height(root.right);

		// Optimizing from O(N^2) -> O(N)
		// Calculating diameter from height method only
		diameter = Math.max(diameter, heightLeft + heightRight);

		return Math.max(heightLeft, heightRight) + 1;
	}

	public static void main(String[] args) {
		Node n1 = new Node(3);
		Node n2 = new Node(9);
		Node n3 = new Node(20);
		Node n4 = new Node(15);
		Node n5 = new Node(7);

		Node root = n1;
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;

		System.out.println("Diameter of a given Binary Tree with O(N^2): " + diameterOfTree(root));

		// Optimization from O(N^2) to O(N)
		System.out.println("Diameter of a given Binary Tree with O(N): " + height(root));
	}
}
