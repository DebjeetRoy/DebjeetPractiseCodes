package com.dev.java.BinarySearchTree;

import com.dev.java.NodeInfo.Node;

public class CreateBSTfromPreOrder {

	static Node createBSTfromPreorder(int[] a, int l, int r) {
		if (l > r)
			return null;

		Node root = new Node(a[l]);
		int i = l + 1;
		for (; i <= r; i++) {
			if (a[i] > a[l])
				break;
		}

		// Creating partition and going towards left and right of the partition value
		root.left = createBSTfromPreorder(a, l + 1, i - 1);
		root.right = createBSTfromPreorder(a, i, r);

		return root;
	}

	public static void main(String[] args) {
		int[] preorder = { 8, 5, 1, 7, 10, 12 };
		Node root = createBSTfromPreorder(preorder, 0, preorder.length - 1);

		SortedArrayToBalancedBST.inorder(root);
	}
}
