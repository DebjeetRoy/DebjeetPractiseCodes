package com.dev.java.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.dev.java.NodeInfo.Node;

public class TopViewOfBinaryTree {
	// static int max_level = 0;

	static class Pair {
		int hd;
		Node node;

		public Pair(int hd, Node node) {
			this.hd = hd;
			this.node = node;
		}
	}

	static ArrayList<Integer> topView(Node root) {
		Queue<Pair> q = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();

		q.add(new Pair(0, root));
		while (!q.isEmpty()) {
			Pair curr = q.poll();

			if (!map.containsKey(curr.hd)) {
				map.put(curr.hd, curr.node.data);
			}
			if (null != curr.node.left) {
				q.add(new Pair(curr.hd - 1, curr.node.left));
			}
			if (null != curr.node.right) {
				q.add(new Pair(curr.hd + 1, curr.node.right));
			}
		}
		return new ArrayList<>(map.values());
	}

	static ArrayList<Integer> bottomView(Node root) {
		Queue<Pair> q = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		q.add(new Pair(0, root));

		while (!q.isEmpty()) {
			Pair curr = q.poll();
			map.put(curr.hd, curr.node.data);

			// Add left node data in queue
			if (null != curr.node.left) {
				q.add(new Pair(curr.hd - 1, curr.node.left));
			}
			if (null != curr.node.right) {
				// Add right node data in queue
				q.add(new Pair(curr.hd + 1, curr.node.right));
			}
		}
		return new ArrayList<>(map.values());
	}

	static ArrayList<Integer> leftView(Node root) {
		ArrayList<Integer> al = new ArrayList<>();
		int level = 0;

		leftViewHelper(al, root, level);
		return al;
	}

	private static void leftViewHelper(List<Integer> al, Node root, int level) {
		if (root == null)
			return;

		// Check if its 1st node of it's level
		if (level == al.size()) {
			al.add(root.data);
			// max_level = level;
		}
		leftViewHelper(al, root.left, level + 1);
		leftViewHelper(al, root.right, level + 1);
	}

	public static void main(String[] args) {
		Node n1 = new Node(3);
		Node n2 = new Node(9);
		Node n3 = new Node(20);
		Node n4 = new Node(15);
		Node n5 = new Node(7);

		Node root = n1;
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;

		System.out.println("Top View : ");
		System.out.println(topView(root));
		System.out.println();

		System.out.println("Bottom View : ");
		System.out.println(bottomView(root));
		System.out.println();

		System.out.println("Left View : ");
		System.out.println(leftView(root));
	}
}
