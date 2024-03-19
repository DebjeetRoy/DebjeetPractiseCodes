package com.branching.conditions;

public class switchCaseStatements {

	public static void main(String[] args) {
		
		int a = 3;
		
		switch(a) {
		case 1 : System.out.println("This is One");
		break; 
		
		case 2 : System.out.println("This is Two");
		break;
		
		case 3 : System.out.println("This is Three");
		break;
		
		case 4 : System.out.println("This is Four");
		break;

		default : System.out.println("The number is other than 1, 2, 3, 4");
		}
	}

}
