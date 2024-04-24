package com.dev.hashSet;

import java.util.HashMap;
import java.util.Map;

public class ItinieryProblem {

	public static String startingPoint(Map<String, String> tickets) {

		Map<String, String> revMap = new HashMap<>();

		for (String key : tickets.keySet()) {
			revMap.put(tickets.get(key), key);
		}

		for (String key : tickets.keySet()) {
			if (!revMap.containsKey(key)) {
				return key; // starting point
			}
		}
		return null;
	}

	public static void main(String[] args) { // O(n)
		Map<String, String> tickets = new HashMap<>();
		tickets.put("Chennai", "Bengaluru");
		tickets.put("Mumbai", "Delhi");
		tickets.put("Goa", "Chennai");
		tickets.put("Delhi", "Goa");

		String start = startingPoint(tickets);

		System.out.print(start);
		for (String key : tickets.keySet()) {
			System.out.print(" -> " + tickets.get(start));
			start = tickets.get(start);
		}
	}
}
