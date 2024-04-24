package com.dev.exception.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryCatchMechanism extends BurgerNotFoundException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	TryCatchMechanism(String message) {
		super(message);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		try (BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in))) {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("I am within try !!");
			// System.exit(0);
			// int a = 10 / 0;
			// throw new BurgerNotFoundException("I want burger");
		} catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e1) {
			e1.printStackTrace();
		} finally {
			System.out.println("Finally block");
			br.close();
		}
	}

}
