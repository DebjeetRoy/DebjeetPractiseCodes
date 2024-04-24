package com.dev.java.streams;

import java.util.LinkedHashMap;
import java.util.Map;

public class NthnonRepeatingCharacter {

	static char nthNonRepeatingChar(String s, int n) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		char[] ch = s.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			map.put(ch[i], map.containsKey(ch[i]) ? map.get(ch[i]) + 1 : 1);
		}
		return map.entrySet().stream().filter(x -> x.getValue() == 1)
				.skip(n).map(x -> x.getKey()).findFirst().get();
	}

	public static void main(String[] args) {
		String str = "she is good girl";
		int n = 2;
		System.out.println(n + "th non repeating character is : " + nthNonRepeatingChar(str, n - 1));
	}
}
