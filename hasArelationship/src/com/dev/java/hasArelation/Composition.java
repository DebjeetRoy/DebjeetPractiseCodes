package com.dev.java.hasArelation;

class Engine {
	String type;
	String horsePower;
	double mileage;

	public Engine(String type, String horsePower, double mileage) {
		this.type = type;
		this.horsePower = horsePower;
		this.mileage = mileage;
	}

	public void showEngineDetails() {
		System.out.println(
				"Engine Type :- " + type + " Engine horsepower :- " + horsePower + " Engine Mileage :- " + mileage);
	}
}

class Car {
	String colour;
	String model;
	double price;
	Engine ref;

	public Car(String colour, String model, double price) {
		super();
		this.colour = colour;
		this.model = model;
		this.price = price;
		ref = new Engine("Mercedes C class", "10000HPW", 5000.0);
	}

	public void showCarDetails() {
		System.out.println("Car Model :- " + model + " Car Colour :- " + colour + " Car Price :- " + price);
	}
}

public class Composition {

	public static void main(String[] args) {
		Car car = new Car("Black", "C class", 4000000);
		car.ref.showEngineDetails();
	}
}
