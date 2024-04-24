package com.dev.java.String;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstring {

	public static void main(String[] args) {
		final String str = "badeaebcaae";
		final String pattern = "aabc";

		final String minSubString = smallestSubstringWithAllPatternMatch(str, pattern);
		System.out.println(
				"Minimum Substring sequence in " + str + " with " + pattern + " characters is :- " + minSubString);
	}

	public static String smallestSubstringWithAllPatternMatch(String str, String pattern) {
		if (str == null || str.length() == 0 || pattern == null || pattern.length() == 0)
			return "";

		final Map<Character, Integer> map = new HashMap<>();
		int matchedElement = 0;
		int start = 0;
		int minSubstrLength = Integer.MAX_VALUE;
		int minSubstrStart = 0;

		// TO store frequency of characters in a map
		for (int i = 0; i < pattern.length(); i++) {
			map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
		}

		for (int end = 0; end < str.length(); end++) {
			final char currChar = str.charAt(end);

			if (map.containsKey(currChar)) {
				map.put(currChar, map.get(currChar) - 1);

				if (map.get(currChar) >= 0) {
					matchedElement++;
				}
			}

			while (matchedElement == pattern.length()) {
				if (end - start + 1 < minSubstrLength) {
					minSubstrLength = end - start + 1;
					minSubstrStart = start;
				}

				final char charAtStart = str.charAt(start++);

				if (map.containsKey(charAtStart)) {
					if (map.get(charAtStart) == 0) {
						matchedElement--;
					}

					map.put(charAtStart, map.get(charAtStart) + 1);
				}
			}
		}

		if (minSubstrLength > str.length())
			return "";
		return str.substring(minSubstrStart, minSubstrStart + minSubstrLength);
	}
}
