package com.dev.AdapterDesignPattern;

import com.krishna.Pen.PilotPen;

public class PenAdapter implements Pen {

	PilotPen pp = new PilotPen();

	@Override
	public void write(String str) {

		pp.mark(str);
	}
}
