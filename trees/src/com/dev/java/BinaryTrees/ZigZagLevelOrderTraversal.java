package com.dev.java.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.dev.java.NodeInfo.Node;

public class ZigZagLevelOrderTraversal {
	public static List<List<Integer>> zigzagLevelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		boolean leftToRight = true;

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> levelNodes = new ArrayList<>();

			for (int i = 0; i < levelSize; i++) {
				Node current = queue.poll();

				// Depending on the flag, add nodes to the list from left to right or right to
				// left
				if (leftToRight) {
					levelNodes.add(current.data);
				} else {
					levelNodes.add(0, current.data);
				}

				// Add the children to the queue for the next level
				if (current.left != null) {
					queue.offer(current.left);
				}
				if (current.right != null) {
					queue.offer(current.right);
				}
			}

			// Toggle the flag for the next level
			leftToRight = !leftToRight;

			// Add the current level nodes to the result
			result.add(levelNodes);
		}
		return result;
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

		List<List<Integer>> ans = zigzagLevelOrder(root);

		System.out.println(ans);
	}
}
