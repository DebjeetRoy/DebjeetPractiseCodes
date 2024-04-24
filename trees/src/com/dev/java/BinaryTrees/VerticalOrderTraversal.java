package com.dev.java.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import com.dev.java.NodeInfo.Node;

public class VerticalOrderTraversal {
	static class Pair {
		int hd;
		Node node;

		public Pair(int hd, Node node) {
			this.hd = hd;
			this.node = node;
		}
	}

	static List<List<Integer>> verticalOrderTraversal(Node root) {
		Queue<Pair> q = new LinkedList<>();
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

		q.add(new Pair(0, root));
		while (!q.isEmpty()) {
			Pair curr = q.poll();
			if (!map.containsKey(curr.hd)) {
				map.put(curr.hd, new ArrayList<>());
			}
			map.get(curr.hd).add(curr.node.data);

			if (null != curr.node.left) {
				q.add(new Pair(curr.hd - 1, curr.node.left));
			}
			if (null != curr.node.right) {
				q.add(new Pair(curr.hd + 1, curr.node.right));
			}
		}
		return new ArrayList<>(map.values());
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

		System.out.println(verticalOrderTraversal(root));
	}
}
