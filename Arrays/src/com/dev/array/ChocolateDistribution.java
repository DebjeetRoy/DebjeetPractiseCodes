package com.dev.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChocolateDistribution {

	public static int findMinDiff(int[] arr, int m) {
		// You Can Code Here
		Arrays.sort(arr);
		int comp = Integer.MAX_VALUE;

		int j = 0;
		while ((j + m < arr.length)) {
			int diff = arr[j + m - 1] - arr[j];
			comp = Math.min(comp, diff);
			j++;
		}
		return comp;
	}

	public static String findMostFreq(List<String> words, int n){
        //You can code here
		Map<String, Integer> map = new HashMap<>();
		String mostFreq = null;

		for (String str : words) {
			map.put(str, !map.containsKey(str) ? 1 : map.get(str) + 1);
        }

        int maxWordCount = Integer.MIN_VALUE;
		for (Map.Entry<String, Integer> mp : map.entrySet()) {
            maxWordCount = Math.max(maxWordCount, mp.getValue());
        }

		for (Map.Entry<String, Integer> mp : map.entrySet()) {
			if (maxWordCount == mp.getValue()) {
				mostFreq = mp.getKey();
				break;
			}
		}
		return mostFreq;
    }

	public static void main(String[] args) {
		int[] arr = { 7, 3, 2, 4, 9, 12, 56 };
		// System.out.println(findMinDiff(arr, 3));

		List<String> wordList = List.of("do", "done", "doing", "do");
		System.out.println("Most frequent word : " + findMostFreq(wordList, wordList.size()));
	}
}
