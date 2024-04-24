package com.dev.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
	public static int longestUniqueSubstring(String s) {
		int l = 0, r = 0;
		int ans = 0;
		Map<Character, Integer> map = new HashMap<>();

		while (r < s.length()) {
			// Checking if character is there in map or character is present at index <
			// left(l)
			if (!map.containsKey(s.charAt(r)) || map.get(s.charAt(r)) < l) {
				ans = Math.max(ans, r - l + 1);
			} else {
				l = map.get(s.charAt(r)) + 1;
			}
			map.put(s.charAt(r), r++);
		}
		return ans;
	}

	public static void main(String[] args) {
		String s = "abcdcbecada";
		System.out.println("Longest Unique Substring is : ");
		System.out.println(longestUniqueSubstring(s));
	}
}
