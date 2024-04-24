package com.dev.hashMapQuestions;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		String s = "devaadfdf";
		String t = "vedaadfdf";

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		int val = 0;
		for (int i = 0; i < t.length(); i++) {
			if (map.containsKey(t.charAt(i))) {
				val = map.get(t.charAt(i));
				map.put(t.charAt(i), --val);
				if (val == 0) {
					map.remove(t.charAt(i));
				}
			}
		}
		if (map.isEmpty()) {
			System.out.println("Valid Anagram");
		} else {
			System.out.println("Not a Valid Anagram");
		}
	}
}
