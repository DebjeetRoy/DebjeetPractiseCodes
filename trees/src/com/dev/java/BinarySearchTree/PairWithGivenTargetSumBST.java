package com.dev.java.BinarySearchTree;

import java.util.ArrayDeque;

import com.dev.java.NodeInfo.Node;

public class PairWithGivenTargetSumBST {

	static boolean twoSumBST(Node root, int target) {
		Node curr1 = root, curr2 = root;

		boolean done1 = false;
		boolean done2 = false;

		int val1 = 0, val2 = 0;

		ArrayDeque<Node> s1 = new ArrayDeque<>();
		ArrayDeque<Node> s2 = new ArrayDeque<>();

		while (true) {
			// LNR Traversal
			while (done1 == false) {
				if (curr1 != null) {
					s1.push(curr1);
					curr1 = curr1.left;
				} else {
					if (s1.isEmpty()) {
						done1 = true;
					}
					Node pop = s1.pop();
					val1 = pop.data;
					curr1 = pop.right;
					done1 = true;
				}
			}

			// RNL Traversal
			while (done2 == false) {
				if (curr2 != null) {
					s2.push(curr2);
					curr2 = curr2.right;
				} else {
					if (s2.isEmpty()) {
						done2 = true;
					}
					Node pop = s2.pop();
					val2 = pop.data;
					curr2 = pop.left;
					done2 = true;
				}
			}

			// Here done1 and done2 both are true
			if (val1 != val2 && val1 + val2 == target) {
				return true;
			} else if (val1 + val2 < target) {
				done1 = false;
			} else if (val1 + val2 > target) {
				done2 = false;
			}

			if (val1 >= val2) {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		Node n1 = new Node(8);
		Node n2 = new Node(3);
		Node n3 = new Node(10);
		Node n4 = new Node(1);
		Node n5 = new Node(6);
		Node n6 = new Node(14);
		Node n7 = new Node(4);
		Node n8 = new Node(7);

		Node root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		n5.left = n7;
		n5.right = n8;

		int target = 2;

		System.out.println("Is 2 sum BST possible = " + twoSumBST(root, target));
	}
}
