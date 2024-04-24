package com.dev.hashMapQuestions;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortHashMapByValues_Streams {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("Dev", 30);
		map.put("Prakash", 24);
		map.put("Prakash", 22);
		map.put("Prakash", 9);
		map.put("Rajni", 9);
		map.put("Rajesh", 27);
		map.put("Arijeet", 27);
		map.put("Boya", 27);

		// System.out.println(nameSet);

		Entry<Integer, List<String>> nameSet = nthLargestData(2, map);
		System.out.println(nameSet.getValue());
	}

	private static Entry<Integer, List<String>> nthLargestData(int n, Map<String, Integer> map) {
		Map<Integer, List<String>> resultSet = map.entrySet().stream().collect(
				Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

		return resultSet.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
				.collect(Collectors.toList()).get(n - 1);
	}
}
