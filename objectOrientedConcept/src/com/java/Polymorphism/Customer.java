package com.java.Polymorphism;

class Bank {
	public void rateOfInterest() {
		System.out.println("Default ROI is 5%");
	}
}

class Sbi extends Bank {
	@Override
	public void rateOfInterest() {
		System.out.println("ROI in SBI is 6%");
	}
}

class Icici extends Bank {
	@Override
	public void rateOfInterest() {
		System.out.println("ROI in ICICI is 7%");
	}
}

class BankData {
	// Upcasting happens here
	public void discussROI(Bank bank) {// Upcasting
		bank.rateOfInterest();
	}
}

public class Customer {

	public static void main(String[] args) {
		Sbi sbi = new Sbi();
		Icici icici = new Icici();

		BankData bd = new BankData();
		bd.discussROI(sbi);
		bd.discussROI(icici);
	}
}
