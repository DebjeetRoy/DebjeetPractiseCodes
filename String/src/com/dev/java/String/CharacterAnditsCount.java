package com.dev.java.String;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CharacterAnditsCount {

	public static void main(StringTest[] args) {
		final String s = "aaahhcccddaah";
		final Map<Character, Integer> map = new HashMap<>();
		final StringBuilder sb = new StringBuilder();
		System.out.println("Input String : " + s);

		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), !map.containsKey(s.charAt(i)) ? 1 : map.get(s.charAt(i)) + 1);
		}
		final TreeMap<Character, Integer> tm = new TreeMap<>(map);

		for (final Map.Entry<Character, Integer> mp : tm.entrySet()) {
			sb.append(mp.getKey()).append(mp.getValue());
		}
		System.out.println("Final String ->");
		System.out.println(sb.toString());
	}
}
