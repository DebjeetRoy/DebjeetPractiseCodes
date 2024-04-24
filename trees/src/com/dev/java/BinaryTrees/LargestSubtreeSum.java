package com.dev.java.BinaryTrees;

import com.dev.java.NodeInfo.Node;

public class LargestSubtreeSum {
	private static int ans;

	private static int subtreeSum(Node root) {
		if (root == null)
			return 0;
		int p1 = subtreeSum(root.left);
		int p2 = subtreeSum(root.right);
		ans = Math.max(ans, root.data + p1 + p2);
		return root.data + p1 + p2;
	}

	public static int findMaxSubtree(Node root) {
		ans = Integer.MIN_VALUE;
		subtreeSum(root);
		return ans;
	}

	public static void main(String[] args) {
		Node n1 = new Node(-88);
		Node n2 = new Node(64);
		Node n3 = new Node(-100);
		Node n4 = new Node(-1);
		Node n5 = new Node(-14);
		Node n6 = new Node(62);
		Node n7 = new Node(-85);
		Node n8 = new Node(-27);
		Node n9 = new Node(-47);
		Node n10 = new Node(-73);

		Node root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n4.right = n9;
		n5.left = n10;

		System.out.println(findMaxSubtree(root));
	}
}
