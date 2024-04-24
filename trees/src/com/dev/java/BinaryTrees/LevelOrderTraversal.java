package com.dev.java.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.dev.java.NodeInfo.Node;

public class LevelOrderTraversal {
	public static ArrayList<Integer> levelOrderTraverse1(Node root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node curr = q.poll();
			ans.add(curr.data);
			if (null != curr.left)
				q.add(curr.left);
			if (null != curr.right)
				q.add(curr.right);
		}
		return ans;
	}

	static ArrayList<ArrayList<Integer>> levelOrderTraverse2(Node root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		Queue<Node> queue = new LinkedList<>();
		ArrayList<Integer> currList = new ArrayList<>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			if (curr == null) {
				res.add(currList);
				if (queue.isEmpty())
					break;
				currList = new ArrayList<>();
				queue.add(null);
			} else {
				currList.add(curr.data);
				if (null != curr.left)
					queue.add(curr.left);
				if (null != curr.right)
					queue.add(curr.right);
			}
		}
		return res;
	}

	static ArrayList<ArrayList<Integer>> levelOrderTraverse3(Node root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {
			int n = queue.size();
			ArrayList<Integer> currList = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				Node curr = queue.poll();
				currList.add(curr.data);

				if (null != curr.left)
					queue.add(curr.left);
				if (null != curr.right)
					queue.add(curr.right);
			}
			res.add(currList);
		}
		return res;
	}

	public static void main(String[] args) {
		Node n1 = new Node(2);
		Node n2 = new Node(1);
		Node n3 = new Node(3);
		Node n4 = new Node(7);
		Node n5 = new Node(4);
		Node n6 = new Node(5);
		Node n7 = new Node(6);
		Node n8 = new Node(8);
		Node n9 = new Node(9);

		Node root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n4.left = n7;
		n4.right = n8;
		n8.left = n9;

//		ArrayList<Integer> res = levelOrderTraverse1(root);
//		System.out.println(res);

//		ArrayList<ArrayList<Integer>> ans = levelOrderTraverse2(root);
//		System.out.println(ans);

		ArrayList<ArrayList<Integer>> ans = levelOrderTraverse3(root);
		System.out.println(ans);
	}
}
