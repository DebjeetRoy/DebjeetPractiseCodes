package com.java.SerDeserInheritance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class E implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6626298115533462601L;
	int i;

	public E(int i) {
		this.i = i;
	}
}

class F extends E {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3412863280045991267L;
	int j;

	public F(int i, int j) {
		super(i);
		this.j = j;
	}

	// By implementing writeObject method,
	// we can prevent
	// subclass from serialization
	private void writeObject(ObjectOutputStream out) throws IOException {
		throw new NotSerializableException();
	}

	// By implementing readObject method,
	// we can prevent
	// subclass from de-serialization
	private void readObject(ObjectInputStream in) throws IOException {
		throw new NotSerializableException();
	}
}

public class CustomSerialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		F b1 = new F(10, 20);

		System.out.println("i = " + b1.i);
		System.out.println("j = " + b1.j);

		/* Serializing B's(subclass) object */

		// Saving of object in a file
		FileOutputStream fos = new FileOutputStream("abc.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		// Method for serialization of B's class object
		oos.writeObject(b1);

		// closing streams
		oos.close();
		fos.close();

		System.out.println("Object has been serialized");

		/* De-Serializing B's(subclass) object */

		// Reading the object from a file
		FileInputStream fis = new FileInputStream("abc.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);

		// Method for de-serialization of B's class object
		F b2 = (F) ois.readObject();

		// closing streams
		ois.close();
		fis.close();

		System.out.println("Object has been deserialized");

		System.out.println("i = " + b2.i);
		System.out.println("j = " + b2.j);
	}
}
