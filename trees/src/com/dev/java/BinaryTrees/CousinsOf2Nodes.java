package com.dev.java.BinaryTrees;

import com.dev.java.NodeInfo.Node;

public class CousinsOf2Nodes {
	static Node xPar, yPar;
	static int xLevel, yLevel;

	public static boolean isCousin(Node root, int x, int y) {
		isCousinHelper(root, null, x, y, 0);
		boolean onSameLevel = xLevel == yLevel;
		boolean onDiffParent = xPar != yPar;

		return onSameLevel && onDiffParent;
	}

	private static void isCousinHelper(Node currNode, Node par, int x, int y, int level) {
		if (currNode == null)
			return;

		if (currNode.data == x) {
			xPar = par;
			xLevel = level;
		}

		if (currNode.data == y) {
			yPar = par;
			yLevel = level;
		}
		isCousinHelper(currNode.left, currNode, x, y, level + 1);
		isCousinHelper(currNode.right, currNode, x, y, level + 1);
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		Node root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		n3.right = n5;

		System.out.println("Is Cousin : " + isCousin(root, 4, 5));
	}
}
