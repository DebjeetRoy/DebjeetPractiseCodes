package com.dev.java.BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dev.java.NodeInfo.Node;

public class BuildBinaryTreeFromInorderPostOrder {
	static Node buildTree(List<Integer> preorder, List<Integer> inorder) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < inorder.size(); i++) {
			map.put(inorder.get(i), i);
		}

		Node root = buildTree(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, map);
		return root;
	}

	static Node buildTree(List<Integer> preorder, int preStart, int preEnd, List<Integer> inorder, int inStart,
			int inEnd, Map<Integer, Integer> map) {
		if (preStart > preEnd || inStart > inEnd)
			return null;

		Node root = new Node(preorder.get(preStart));
		int inRoot = map.get(root.data);
		int numsLeft = inRoot - inStart;

		root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);
		root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);

		return root;
	}

	public static void main(String[] args) {
		List<Integer> preorder = new ArrayList<>();
		// 3, 2, 5, 1, 4
		preorder.add(3);
		preorder.add(2);
		preorder.add(5);
		preorder.add(1);
		preorder.add(4);

		List<Integer> inorder = new ArrayList<>();
		// 2, 1, 5, 4, 3
		inorder.add(2);
		inorder.add(1);
		inorder.add(5);
		inorder.add(4);
		inorder.add(3);

		Node ans = buildTree(preorder, inorder);
		// while(ans.left != null && )
	}
}
