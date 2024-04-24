package com.dev.java.String;

public class StringCompression {
	public static void main(String[] args) {
		final String str = "aaabbccccdd";

		final String compressedString = stringCompression(str);
		System.out.println("Compressed String : " + compressedString);
	}

	private static String stringCompression(String str) {
		final int len = str.length();
		StringBuffer sb = new StringBuffer("");

		// O(n)
		for (int i = 0; i < len; i++) {
			Integer count = 1;
			while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
				count++;
				i++;
			}
			sb = sb.append(str.charAt(i));
			if (count > 1) {
				sb = sb.append(count.toString());
			}
		}
		return sb.toString();
	}
}
