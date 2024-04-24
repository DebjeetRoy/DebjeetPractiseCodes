package com.dev.java.ThreadSafeMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class CMEcheck {
	public static void main(String[] args) {

		synchronizedMapCMEcheck();
	}

	private static void synchronizedMapCMEcheck() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Debjeet");
		map.put(2, "HashMap");
		// Map<Integer, String> synchronizedMap = Collections.synchronizedMap(map);

		Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>(map);
		Iterator<Entry<Integer, String>> iterator = concurrentHashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			concurrentHashMap.put(3, "Modification");
			iterator.next();
		}
		System.out.println("Executed Successfully !!");
	}
}
