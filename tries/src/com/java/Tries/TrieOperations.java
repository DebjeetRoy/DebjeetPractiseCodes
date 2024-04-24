package com.java.Tries;

public class TrieOperations {

	static class Node {
		Node[] children = new Node[26];
		boolean endOfWord = false;

		Node() {
			for (int i = 0; i < 26; i++) {
				children[i] = null;
			}
		}
	}

	public static Node root = new Node();

	public static boolean searchWord(String key) { // O(Length of key)
		Node curr = root;

		for (int level = 0; level < key.length(); level++) {
			int idx = key.charAt(level) - 'a';
			if (curr.children[idx] == null) {
				return false;
			}
			curr = curr.children[idx];
		}
		if (curr.endOfWord != true) {
			return false;
		}
		return true;
	}

	public static void insert(String word) { // O(Length of Word)
		Node curr = root;

		for (int level = 0; level < word.length(); level++) {
			int idx = word.charAt(level) - 'a';
			if (curr.children[idx] == null) {
				curr.children[idx] = new Node();
			}
			curr = curr.children[idx]; // next child node becomes current node and search occurs in child node
		}
		curr.endOfWord = true;
	}

	public static void main(String[] args) {
		String[] words = { "the", "a", "there", "their", "any", "thee" };

		for (int i = 0; i < words.length; i++) {
			insert(words[i]);
		}

		String key = "they";
		System.out.println(searchWord(key));
	}
}
