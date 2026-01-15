package oops;

import java.util.Scanner;

//Parent class (Base class)
class Animal {
	String name;

	// Constructor
	Animal(String name) {
		this.name = name;
	}

	// Method to display animal sound
	void sound() {
		System.out.println(name + " makes a sound.");
	}
}

//Child class (Derived class) inheriting from Animal
class Dog extends Animal {
	String breed;

	// Constructor calling parent constructor using super()
	Dog(String name, String breed) {
		super(name); // Call parent constructor
		this.breed = breed;
	}

	// Overriding the sound method
	@Override
	void sound() {
		System.out.println(name + " barks.");
	}

	// Additional method specific to Dog
	void displayBreed() {
		System.out.println("Breed: " + breed);
	}
}

public class InheritanceTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			// Taking user input
//			System.out.print("Enter dog name: ");
			String name = "kala kutta";

//			System.out.print("Enter dog breed: ");
			String breed = "bhouku";
			
			if (name.isEmpty() || breed.isEmpty()) {
				System.out.println("Name and breed cannot be empty.");
				return;
			}

			// Creating Dog object
			Dog myDog = new Dog(name, breed);

			// Demonstrating inheritance
			myDog.sound(); // Overridden method
			myDog.displayBreed(); // Child-specific method

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		} finally {
			sc.close();
		}
	}
}