package com.dev.java.BinaryTrees;

import com.dev.java.NodeInfo.Node;

public class LowestCommonAncestors {

	static Node lca(Node root, int n1, int n2) {
		if (root == null)
			return null;

		// 1st case
		if (root.data == n1 || root.data == n2)
			return root;

		Node leftSubTree = lca(root.left, n1, n2);
		Node rightSubTree = lca(root.right, n1, n2);

		// 2nd and 3rd case
		// 2 - if left and right subtree both are null then return null
		// 3 - if one of the subtree returns null then return other subtree
		if (leftSubTree == null)
			return rightSubTree;
		if (rightSubTree == null)
			return leftSubTree;

		return root;
	}

	public static void main(String[] args) {
		Node n1 = new Node(3);
		Node n2 = new Node(5);
		Node n3 = new Node(1);
		Node n4 = new Node(6);
		Node n5 = new Node(2);
		Node n6 = new Node(0);
		Node n7 = new Node(8);
		Node n8 = new Node(7);
		Node n9 = new Node(4);

		Node root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n5.left = n8;
		n5.right = n9;

		int node1 = 7;
		int node2 = 4;

		Node ans = lca(root, node1, node2);
		System.out.println("Lowest Common Ancestor of " + node1 + " and " + node2 + " = " + ans.data);
	}
}
