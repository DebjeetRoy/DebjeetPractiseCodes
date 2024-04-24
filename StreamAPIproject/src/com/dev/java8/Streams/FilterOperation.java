package com.dev.java8.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterOperation {

	public static void main(String[] args) {
		Car c = new Car("Maruti", "M800", 1000000);
		Car c1 = new Car("Nano", "nano100", 200000);
		Car c2 = new Car("Skoda", "Luna", 500000);

		List<Car> al = new ArrayList<>();
		al.add(c);
		al.add(c1);
		al.add(c2);

		System.out.println("List of Cars : ");
		al.stream().forEach(System.out::println);
		System.out.println();

		List<Car> filteredList = al.stream().filter(s -> s.getCarPrice() < 500001).collect(Collectors.toList());

		System.out.println("Cars having price less than 500000 are : " + filteredList);
	}
}

class Car {
	private String carName;
	private String carModel;
	private double carPrice;

	public Car(String carName, String carModel, double carPrice) {
		this.carName = carName;
		this.carModel = carModel;
		this.carPrice = carPrice;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public double getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}

	@Override
	public String toString() {
		return "Car [carName=" + carName + ", carModel=" + carModel + ", carPrice=" + carPrice + "]";
	}
}
