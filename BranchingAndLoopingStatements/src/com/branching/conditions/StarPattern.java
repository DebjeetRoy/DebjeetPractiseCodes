package com.branching.conditions;

public class StarPattern {

	public static void main(String[] args) {
		
		for(int i=1; i<=4; i++) {
			for(int j=4; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		
		double num = test(5);
		
		System.out.println(num);
	}
	
	public static double test(int a)
	{
		System.out.println(a);
		return a;
	}
}

