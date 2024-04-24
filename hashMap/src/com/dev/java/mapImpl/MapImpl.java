package com.dev.java.mapImpl;

import java.util.HashMap;
import java.util.Map;

public class MapImpl {
	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();

		map.put("CS", 60);
		map.put("ECE", 80);
		map.put("IN", 60);
		map.put("EE", 70);
		boolean flag = false;

		for (Map.Entry<String, Integer> hm : map.entrySet()) {
			System.out.println("Key -> " + hm.getKey() + " value -> " + hm.getValue());
		}
		if (map.containsKey("AAA")) {
			flag = true;
			System.out.println("Data is present " + flag);
		} else {
			flag = false;
			System.out.println("Data not present " + flag);
		}
		map.clear();
		System.out.println("Map after clearing => ");
		System.out.println(map);
	}
}
