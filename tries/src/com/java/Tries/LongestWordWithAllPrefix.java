package com.java.Tries;

public class LongestWordWithAllPrefix extends TrieOperations {
	public static String ans = "";

	public static void longestWord(Node root, StringBuilder temp) {
		if (root == null) {
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null && root.children[i].endOfWord == true) {
				char ch = (char) (i + 'a');
				temp.append(ch);
				if (temp.length() > ans.length()) {
					ans = temp.toString();
				}
				longestWord(root.children[i], temp);
				temp.deleteCharAt(temp.length() - 1); // backtrack
			}
		}
	}

	public static void main(String[] args) {
		String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };

		for (int i = 0; i < words.length; i++) {
			TrieOperations.insert(words[i]);
		}
		longestWord(root, new StringBuilder(""));
		System.out.println(ans);
	}
}
