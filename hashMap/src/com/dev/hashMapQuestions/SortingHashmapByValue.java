package com.dev.hashMapQuestions;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortingHashmapByValue {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Dev", 30);
		map.put("Prakash", 24);
		map.put("Arunesh", 27);
		map.put("Arijeet", 27);

		// Sorting by Key
		System.out.println("Sorted Hashmap based on Keys -> ");
		TreeMap<String, Integer> tm = new TreeMap<>();
		tm.putAll(map);

		for (Map.Entry<String, Integer> mp : tm.entrySet()) {
			System.out.print(mp.getKey() + " ");
		}

		// Sorting by Value
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		// Sort List
		Collections.sort(list, (o1, o2) -> o1.getValue() - o2.getValue());
		System.out.println();
		System.out.println("Sorted Hashmap based on Values -> ");

		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> sorted : list) {
			sortedMap.put(sorted.getKey(), sorted.getValue());
		}

		// printing Map
		for (Map.Entry<String, Integer> mp : sortedMap.entrySet()) {
			System.out.println(mp.getKey() + " - " + mp.getValue());
		}
	}
}
