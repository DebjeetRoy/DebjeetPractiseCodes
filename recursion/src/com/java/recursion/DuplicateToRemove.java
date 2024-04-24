package com.java.recursion;

public class DuplicateToRemove {
	public static void main(String[] args) {
		String str = "aabddssdff";
		removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
	}

	private static void removeDuplicates(String str, int index, StringBuilder newValue, boolean[] map) {
		if (index == str.length()) {
			System.out.println(newValue);
			return;
		}
		char curr = str.charAt(index);

		if (map[curr - 'a'] == true) {
			removeDuplicates(str, index + 1, newValue, map);
		} else {
			map[curr - 'a'] = true;
			removeDuplicates(str, index + 1, newValue.append(curr), map);
		}
	}
}
