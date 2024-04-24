package com.dev.java8.Streams;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterStream {
	public static void main(String[] args) {
		final String str = "ssaavsstb";

		System.out.println("Nth non Repeating Character is ->");

		// Using hashMap
		final Map<Character, Integer> map = new LinkedHashMap<>();
		final char[] ch = str.toCharArray();
		final int n = str.length();

		for (int i = 0; i < n; i++) {
			map.put(ch[i], !map.containsKey(ch[i]) ? 1 : map.get(ch[i]) + 1);
		}
		final int skip = 2;
		System.out.println("nth non repeating character with Stream :");
		System.out.println(
				map.entrySet().stream().filter(mp -> mp.getValue() == 1).skip(skip).findFirst().get().getKey());
	}
}
