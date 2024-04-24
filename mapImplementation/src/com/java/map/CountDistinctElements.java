package com.java.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class CountDistinctElements {
	public static void main(String[] args) {
		int[] num = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < num.length; i++) {
			map.put(num[i], !map.containsKey(num[i]) ? 1 : map.get(num[i]) + 1);
		}

		// Count of all numbers in an array
		System.out.println("Count of all numbers in an array => ");
		for (Map.Entry<Integer, Integer> hm : map.entrySet()) {
			System.out.println(hm.getKey() + " -> " + hm.getValue());
		}
		System.out.println();

		// Distinct elements
		Set<Integer> uniqueElements = new HashSet<>();
		List<Entry<Integer, Integer>> distinct = map.entrySet().stream().filter(x -> uniqueElements.add(x.getKey()))
				.collect(Collectors.toList());

		System.out.println("Distinct Elements :- ");
		for (Entry<Integer, Integer> entry : distinct) {
			System.out.println(entry.getKey());
		}

		// count distinct numbers
		System.out.println("Size of distinct elements are : " + map.entrySet().size());
	}
}
