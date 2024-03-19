package com.branching.conditions;

public class WhileFunctionality {

	public static void main(String[] args) {
		
		int i = 1;
		
		/*
		 * while loop example
		 */
//		while(i <= 100) {
//			if(i%2 == 0) {
//				System.out.println(i+ " is an Even Number");
//				i = i+1;
//			} else {
//				System.out.println(i+ " is an Odd number");
//				i = i+1;
//			}
//		}
		
		/*
		 * do - while loop example
		 */
		int j=5;
		do {
			if(j%2 == 0) {
				System.out.println(i+ " is an Even Number");
				i = i+1;
			} else {
				System.out.println(i+ " is an Odd number");
				i = i+1;
			}
		}while(j <= 4);

	}

}
