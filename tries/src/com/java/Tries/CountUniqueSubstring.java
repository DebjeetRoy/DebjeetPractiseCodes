package com.java.Tries;

public class CountUniqueSubstring extends TrieOperations {

	public static int countNodes(Node root) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null) {
				count += countNodes(root.children[i]);
			}
		}
		return count + 1;
	}

	public static void main(String[] args) {
		// String str = "ababa"; // ans = 10
		String str1 = "apple"; // ans = 15

		// suffix -> insert in trie
		for (int i = 0; i < str1.length(); i++) {
			String suffix = str1.substring(i);
			TrieOperations.insert(suffix);
		}

		// count unique substrings
		int count = countNodes(root);
		System.out.println("Count of unique Substrings formed = " + count);
	}
}
