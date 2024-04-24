package com.dev.java.BinaryTrees;

import com.dev.java.NodeInfo.Node;

public class PathSum {

	public static boolean isPathSum(Node root, int targetSum) {
		if (root == null)
			return false;

		if (root.data == targetSum && root.left == null && root.right == null) {
			return true;
		}

		return isPathSum(root.left, targetSum - root.data) || isPathSum(root.right, targetSum - root.data);
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

		int targetSum = 22;

		System.out.println("Is Path Sum = " + isPathSum(root, targetSum));
	}
}
