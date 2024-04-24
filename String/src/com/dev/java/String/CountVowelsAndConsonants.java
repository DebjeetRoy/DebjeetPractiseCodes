package com.dev.java.String;

public class CountVowelsAndConsonants {

	public static void main(StringTest[] args) {

		final String str = "I am a good boy";
		int countVowel = 0;
		int countConsonants = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'A' || str.charAt(i) == 'e' || str.charAt(i) == 'E'
					|| str.charAt(i) == 'i' || str.charAt(i) == 'I' || str.charAt(i) == 'o' || str.charAt(i) == 'O'
					|| str.charAt(i) == 'u' || str.charAt(i) == 'U') {
				countVowel++;
			} else if (str.charAt(i) != ' ') {
				countConsonants++;
			}
		}
		// System.out.println(str.toLowerCase());
		System.out.println("Number of vowels in this string is : " + countVowel);
		System.out.println("Number of consonants in this string is : " + countConsonants);
	}
}
