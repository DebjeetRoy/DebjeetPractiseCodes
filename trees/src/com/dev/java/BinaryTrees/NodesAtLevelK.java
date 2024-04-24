package com.dev.java.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;

import com.dev.java.NodeInfo.Node;

public class NodesAtLevelK {

	static void nodesAtLevelk(Node root, int level, ArrayList<Integer> ans) {
		if (root == null || level < 0)
			return;

		if (level == 0) {
			ans.add(root.data);
			return;
		}
		nodesAtLevelk(root.left, level - 1, ans);
		nodesAtLevelk(root.right, level - 1, ans);
	}

	static class Pair {
		Node node;
		int level;

		public Pair(Node node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	static ArrayList<Integer> nodesAtLevelKIterative(Node root, int level) {
		ArrayList<Integer> al = new ArrayList<>();
		ArrayDeque<Pair> stack = new ArrayDeque<>();

		Pair first = new Pair(root, level);
		stack.push(first);

		while (!stack.isEmpty()) {
			Pair curr = stack.poll();
			if (curr.node == null)
				continue;
			if (curr.level == 0) {
				al.add(curr.node.data);
				continue;
			}

			stack.push(new Pair(curr.node.right, curr.level - 1));
			stack.push(new Pair(curr.node.left, curr.level - 1));
		}
		return al;
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

		int k = 2;

		ArrayList<Integer> ans = new ArrayList<>();
//		nodesAtLevelk(root, k, ans);
//		System.out.println("No. of nodes at level " + k + " is " + ans);

		System.out.println("Iterative Solution :- ");
		ArrayList<Integer> res = new ArrayList<>();
		res = nodesAtLevelKIterative(root, k);
		System.out.println("No. of nodes at level " + k + " is " + res);
	}
}
