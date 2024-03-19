package com.dev.array.LeetCode;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] s = { "coder", "coding", "code" };
		System.out.println("LongestCommon Substring : " + longestCommonPrefix(s));
	}

	public static String longestCommonPrefix(String[] s) {
		// You can code here
		int size = s.length;
		StringBuffer sb = new StringBuffer();

		if (size == 0) {
			return null;
		}

		// If lengthh of String is 1 then longest common prefix will be the string
		// itself
		else if (size == 1) {
			return s[0];
		} else {
			Arrays.sort(s);
			for (int i = 0; i < s[0].length(); i++) {
				// Checking first and last string character by character
				if (s[0].charAt(i) == s[size - 1].charAt(i)) {
					sb = sb.append(s[0].charAt(i));
				} else {
					break;
				}
			}
		}
		return sb.toString();
	}

}
