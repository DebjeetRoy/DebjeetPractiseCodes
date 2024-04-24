package com.dev.java.ThreadSafeMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NullCheck {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, null);
		map.put(2, "Raj");
		// Collections.synchronizedMap(map);

		Map<Integer, String> map1 = new ConcurrentHashMap<>(map);

		System.out.println("Executed Successfully !!");
	}
}
