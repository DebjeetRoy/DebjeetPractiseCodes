package com.dev.FacadeDesignPattern;

public class FacadePatternMain {
	public static void main(String[] args) {
		ShapeManager sm = new ShapeManager();

		sm.drawCircle();
		sm.drawRectangle();
		sm.drawSquare();
	}
}
