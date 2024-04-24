package com.java.Tries;

public class UniquePrefixProblem {
	static class Node {
		Node[] children = new Node[26];
		boolean eow = false;
		int frequency = 0;

		public Node() {
			for (int i = 0; i < children.length; i++) {
				children[i] = null;
			}
			frequency = 1;
		}
	}

	public static Node root = new Node();

	public static void insert(String data) {

		Node currNode = root;
		for (int level = 0; level < data.length(); level++) {
			int idx = data.charAt(level) - 'a';
			if (currNode.children[idx] == null) {
				currNode.children[idx] = new Node();
			} else {
				currNode.children[idx].frequency++;
			}
			currNode = currNode.children[idx];
		}
		currNode.eow = true;
	}

	public static void findPrefix(Node root, String ans) {// TC : O(level) - Longest word
		if (root == null) {
			return;
		}
		if (root.frequency == 1) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < root.children.length; i++) {
			if (root.children[i] != null) {
				findPrefix(root.children[i], ans + (char) (i + 'a'));
			}
		}
	}

	public static void main(String[] args) {
		String[] words = { "zebra", "dog", "duck", "dove" };

		for (int i = 0; i < words.length; i++) {
			insert(words[i]);
		}
		root.frequency = -1;

		findPrefix(root, "");
	}
}
