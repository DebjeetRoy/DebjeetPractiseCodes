package com.dev.array;

public class CapitalSmall {

	public static void main(String[] args) {
		String s1 = "iam_bonu_iama_star";
		String s2 = "iamaDeveloper";

		System.out.println(replaceString(s1));
		System.out.println(replaceString(s2));

	}

	private static String replaceString(String s) {
		int length = s.length();
		String finalString = "";

		if (s.contains("_")) {
			for (int i = 0; i < length; i++) {
				StringBuilder st = new StringBuilder();
				if (i < s.length() - 1 && s.charAt(i) == '_') {
					st = st.append(s.charAt(i + 1));
					finalString = finalString + st.toString().toUpperCase();
					i++;
				} else {
					finalString = finalString + s.charAt(i);
				}
			}
		} else if (!s.contains("_")) {
			for (int i = 0; i < length; i++) {
				StringBuilder st = new StringBuilder();
				if (i < s.length() - 1 && (s.charAt(i) >= 65 && s.charAt(i) <= 90)) {
					String lowerCase = "";
					lowerCase = (lowerCase + s.charAt(i)).toLowerCase();
					st = st.append("_" + lowerCase);
					finalString = finalString + st.toString();
				} else {
					finalString = finalString + s.charAt(i);
				}
			}
		}
		return finalString;
	}
}
