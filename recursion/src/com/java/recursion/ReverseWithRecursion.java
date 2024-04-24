package com.java.recursion;

public class ReverseWithRecursion {
	public static void main(String[] args) {
		String str = "Shyam";
		twoPointerReverse(str);
	}

	public static void twoPointerReverse(String s) {
		char[] ch = s.toCharArray();
		int left = 0;
		int right = s.length() - 1;

		reverseHelper(ch, left, right);
		System.out.println(new String(ch));
	}

	private static void reverseHelper(char[] ch, int left, int right) {
		if (left >= right) {
			return;
		}
		swap(ch, left, right);
		reverseHelper(ch, left + 1, right - 1);
	}

	private static void swap(char[] ch, int left, int right) {
		char c = ch[left];
		ch[left] = ch[right];
		ch[right] = c;
	}

	private static void reverse(String str) {
		int len = str.length();
		if (len == 0) {
			return;
		}
		System.out.print(str.charAt(str.length() - 1));
		reverse(str.substring(0, len - 1));
	}
}
