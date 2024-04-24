package com.dev.java.String;

public class MergeStringAlternately {
	public static void main(String[] args) {
		final String word2 = "ab";
		final String word1 = "pqrs";

		System.out.println(mergeAlternately(word1, word2));
	}

	public static String mergeAlternately(String word1, String word2) {
		final int len1 = word1.length();
		final int len2 = word2.length();

		final String[] mergedString = new String[len1 + len2];
		String s = new String("");
		int j = 0, k = 0;

		for (int i = 0; i < mergedString.length; i++) {
			if (len1 == len2) {
				if (i % 2 == 0 && j < len1) {
					mergedString[i] = word1.charAt(j++) + "";
					s += mergedString[i];
				}
				if (i % 2 != 0 && k < len2) {
					mergedString[i] = word2.charAt(k++) + "";
					s += mergedString[i];
				}
			} else if (len1 < len2) {
				if (j < len1 && i % 2 == 0) {
					mergedString[i] = word1.charAt(j++) + "";
					s += mergedString[i];
				}
				if (j < len1 && i % 2 != 0 && k < len2) {
					mergedString[i] = word2.charAt(k++) + "";
					s += mergedString[i];
				}
				if (j == len1 && k < len2) {
					mergedString[i] = word2.charAt(k++) + "";
					s += mergedString[i];
				}
			} else if (len1 > len2) {
				if (k < len2 && i % 2 == 0) {
					mergedString[i] = word1.charAt(j++) + "";
					s += mergedString[i];
				}
				if (k < len2 && i % 2 != 0 && j < len1) {
					mergedString[i] = word2.charAt(k++) + "";
					s += mergedString[i];
				}
				if (k == len2 && j < len1) {
					mergedString[i] = word1.charAt(j++) + "";
					s += mergedString[i];
				}
			}
		}
		return s;
	}
}
