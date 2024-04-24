package com.dev.java.BinaryTrees;

import java.util.ArrayList;

import com.dev.java.NodeInfo.Node;

public class RightViewOfBinaryTree {
	static ArrayList<Integer> rightView(Node root, int level, ArrayList<Integer> al) {
		if (root == null)
			return null;

		int size = al.size();
		if (level >= size) {
			al.add(root.data);
		}
		rightView(root.right, level + 1, al);
		rightView(root.left, level + 1, al);

		return al;
	}
	
	static ArrayList<Integer> leftView(Node root, int level, ArrayList<Integer> al) {
		if (root == null)
			return null;

		int size = al.size();
		if (level >= size) {
			al.add(root.data);
		}
		leftView(root.left, level + 1, al);
		leftView(root.right, level + 1, al);

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
		/*
		 *    1
		 *   / \
		 *  2   3
		 *   \   \
		 *    4   5
		 */

		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<Integer> res = rightView(root, 0, al);

		System.out.println("Right View of given Binary Tree :- ");
		for (Integer ele : res) {
			System.out.print(ele + " ");
		}
	}
}
