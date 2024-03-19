package com.dev.dsa.BST;

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Pair {
	TreeNode node;
	int hd;

	Pair(int hd, TreeNode node) {
		this.hd = hd;
		this.node = node;
	}
}

public class RangeSum_BST {

	// BFS algo
	public static int rangeSumBSTbfs(TreeNode root, int low, int high) {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(0, root));
		int sum = 0;

		while (!q.isEmpty()) {
			Pair curr = q.poll();
			if (curr.node.val >= low && curr.node.val <= high) {
				sum += curr.node.val;
			}
			if (curr.node.left != null) {
				q.add(new Pair(curr.hd - 1, curr.node.left));
			}
			if (curr.node.right != null) {
				q.add(new Pair(curr.hd + 1, curr.node.right));
			}
		}
		return sum;
	}

	// DFS algo
	public static int rangeSumBSTdfs(TreeNode root, int low, int high) {
		if (root == null)
			return 0;
		int val = root.val;
		int sum = 0;

		if (val >= low && val <= high) {
			sum = val;
		}

		if (low < val) {
			sum += rangeSumBSTdfs(root.left, low, high);
		}
		if (high > val) {
			sum += rangeSumBSTdfs(root.right, low, high);
		}
		return sum;
	}

	public static void main(String[] args) {
		// int[] arr = { 10, 5, 15, 3, 7, null, 18 };
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(7);
		// TreeNode n6 = new TreeNode(13);
		TreeNode n7 = new TreeNode(18);
		// TreeNode n8 = new TreeNode(1);
		// TreeNode n9 = new TreeNode(6);

		TreeNode root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		// n3.left = n6;
		n3.right = n7;
		// n4.left = n8;
		// n5.left = n9;

		int low = 7, high = 15;

		System.out.println("With BFS approach : " + rangeSumBSTbfs(root, low, high));
		System.out.println();
		System.out.println("With DFS approach : " + rangeSumBSTdfs(root, low, high));
	}
}
