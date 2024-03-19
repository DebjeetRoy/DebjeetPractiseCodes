package com.dev.ArrayListProblems;

import java.util.ArrayList;
import java.util.List;

public class Swap {
	
	public static void swap(List<Integer> al, int index1, int index2) {
		int temp = al.get(index1);
		al.set(index1, al.get(index2));
		al.set(index2, temp);
	}
	
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.add(6);
		
		System.out.println("List data before Swapping ->");
		System.out.println(l1);
		
		int index1 = 1;
		int index2 = 3;
		
		System.out.println("List data after Swapping ->");
		swap(l1, index1, index2);
		System.out.println(l1);
	}
}
