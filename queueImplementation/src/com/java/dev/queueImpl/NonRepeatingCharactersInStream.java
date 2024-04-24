package com.java.dev.queueImpl;

import java.util.LinkedList;
import java.util.Queue;

public class NonRepeatingCharactersInStream {

	public static String firstNonRepeatingInStream(String s) {
		StringBuilder sb = new StringBuilder(); // mutable class
		int frequency[] = new int[26]; // A=0, B-1, C-2

		Queue<Character> q = new LinkedList<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			q.offer(c);
			frequency[c - 'a']++;

			while (!q.isEmpty() && frequency[q.peek() - 'a'] > 1) {
				q.poll();
			}
			if (q.isEmpty()) {
				sb.append('#');
			} else {
				sb.append(q.peek());
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "abcbacdabcdeef";

		System.out.println("Resultant String for Non-Repeating char in a stream : " + firstNonRepeatingInStream(s));
	}
}
