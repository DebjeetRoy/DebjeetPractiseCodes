package com.dev.FacadeDesignPattern;

/*
 * Facade Class
 */
public class ShapeManager {
	private Shape circle;
	private Shape rectangle;
	private Shape square;

	public ShapeManager() {
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}

	public void drawCircle() {
		circle.drawShape();
	}

	public void drawSquare() {
		square.drawShape();
	}

	public void drawRectangle() {
		rectangle.drawShape();
	}
}
