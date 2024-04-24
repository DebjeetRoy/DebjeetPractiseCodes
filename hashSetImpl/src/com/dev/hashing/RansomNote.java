package com.dev.hashing;

public class RansomNote {
	public static boolean canConstruct(String ransomNote, String magazine) {
		// Take length of first string
		int l1 = ransomNote.length();
		// Take length of second string
		int l2 = magazine.length();
		// Check if length of first string is greater than length of second string
		if (l1 > l2)
			// terminate execution as basic condition fails
			return false;
		// Iterate char by char of first string
		char[] ransomNoteChars = ransomNote.toCharArray();
		for (char charOfransomNote : ransomNoteChars) {
			// Check char is present in magazine string
			if (magazine.contains(Character.toString(charOfransomNote)))
				// If magazine contains char, replace that with empty string.
				// I am using replaceFirst method to replace only first occurrence.
				magazine = magazine.replaceFirst(Character.toString(charOfransomNote), "");
			else
				// If char is not present in magazine string then return false
				return false;
		}
		// If iteration is completed for each char it means all chars of ransom note is
		// present in
		// magazine note.
		return true;

	}

	public static void main(String[] args) {
		System.out.println(canConstruct("aa", "aab"));
		System.out.println(canConstruct("aba", "aab"));
		System.out.println(canConstruct("abc", "ab"));
		System.out.println(canConstruct("b", "a"));
		System.out.println(canConstruct("amod maha", "mdoamaa h"));
	}
}
