package com.java.Encapsulation;

class Account {
	private int accountNo = 7113390;
	private double balance;

	public int getAccountNo(int pin) {
		if (pin == 1234) {
			return accountNo;
		} else {
			System.out.println("Invalid Pin");
		}
		return 0;

	}

	public double getBalance(int pin) {
		if (pin == 1234) {
			return balance;
		} else {
			System.out.println("Invalid Pin");
		}
		return 0;
	}

	public void setBalance(double balance) {
		if (balance > 0) {
			this.balance = balance;
		} else {
			System.out.println("Not sufficient balance !!");
		}
	}
}

public class MainClass {

	public static void main(String[] args) {
		Account a1 = new Account();
		a1.setBalance(3000);

		double bal = a1.getBalance(7);
		System.out.println("Balance Amount : " + bal);

		int accountNo = a1.getAccountNo(8);
		System.out.println("Account Number : " + accountNo);
	}

}
