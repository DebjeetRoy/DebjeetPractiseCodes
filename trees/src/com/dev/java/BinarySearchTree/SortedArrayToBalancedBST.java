package com.dev.java.BinarySearchTree;

import com.dev.java.NodeInfo.Node;

public class SortedArrayToBalancedBST {
	static Node createBalancedBSTFromSortedArray(int[] a, int l, int r) {
		if (l > r)
			return null;

		int m = l + (r - l) / 2;
		Node root = new Node(a[m]);

		root.left = createBalancedBSTFromSortedArray(a, l, m - 1);
		root.right = createBalancedBSTFromSortedArray(a, m + 1, r);

		return root;
	}

	static void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 5, 6, 8, 9 };
		Node root = createBalancedBSTFromSortedArray(a, 0, a.length - 1);
		inorder(root);
	}
}
