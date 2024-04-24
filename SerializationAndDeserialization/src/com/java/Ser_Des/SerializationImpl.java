package com.java.Ser_Des;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationImpl {
	public static void printEmployeedata(Employee employee) {
		System.out.println("Employee Name = " + employee.empName);
		System.out.println("Employee Age = " + employee.empAge);
		System.out.println("Employee ID = " + employee.empId);
		System.out.println("Employee Salary = " + employee.empSalary);
	}

	public static void main(String[] args) {
		Employee emp = new Employee("Rajesh", 31, 2, 30000);
		String filename = "rajesh.txt";

		// Serialization
		try {
			// Saving of emp in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of emp
			out.writeObject(emp);

			out.close();
			file.close();

			System.out.println("Employee object has been Serialized and Data before Serialization is => ");
			System.out.println();
			printEmployeedata(emp);

			// value of static variable changed
			Employee.empSalary = 40000;
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		emp = null;

		// Deserialization
		try {

			// Reading the emp from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of emp
			emp = (Employee) in.readObject();

			// Close all the open resources
			in.close();
			file.close();

			System.out.println();
			System.out.println("Employee object has been Deserialized and Data after Deserialization is =>");
			System.out.println();
			printEmployeedata(emp);
		} catch (IOException e1) {
			System.out.println("IOException " + e1);
		} catch (ClassNotFoundException e2) {
			System.out.println("ClassNotFoundException " + e2);
		}
	}
}
