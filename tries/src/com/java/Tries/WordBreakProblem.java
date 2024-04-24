package com.java.Tries;

public class WordBreakProblem {

	public static boolean wordBreak(String key) { // O(Length of key) ~ O(n)
		if (key.length() == 0) {
			return true;
		}
		for (int i = 1; i <= key.length(); i++) {
			if (TrieOperations.searchWord(key.substring(0, i)) && wordBreak(key.substring(i))) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String[] words = { "i", "like", "sam", "samsung", "mobile", "ice" };

		for (int i = 0; i < words.length; i++) {
			TrieOperations.insert(words[i]);
		}
		String key = "ilikesam";
		boolean isWordBreak = wordBreak(key);
		System.out.println(isWordBreak);
	}
}
