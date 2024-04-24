package com.java.Tries;

public class StartsWithPrefix extends TrieOperations {

	public static boolean startsWith(String prefix) {
		Node curr = root;
		for (int level = 0; level < prefix.length(); level++) {
			int idx = prefix.charAt(level) - 'a';

			if (curr.children[idx] == null) {
				return false;
			} else {
				curr = curr.children[idx];
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words = { "apple", "app", "mango", "man", "woman" };

		// Trie Creation
		for (int i = 0; i < words.length; i++) {
			TrieOperations.insert(words[i]);
		}

		// Prefix Search
		System.out.println(startsWith("mam"));
	}
}
