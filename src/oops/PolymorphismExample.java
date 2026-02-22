package oops;

public class PolymorphismExample {
	public static void main(String[] args) {
		Student student = new Student();
		student.display("Alice", 1); // Output: Name: Alice, Roll No: 1
		student.display(2, "Bob"); // Output: Roll No: 2, Name: Bob

		Vehicles myVehicle = new Vehicles();
		myVehicle.start(); // Calls the start method in Vehicle

		Vehicles myCar = new Cars();
		myCar.start(); // Calls the overridden start method in Car

		Vehicles myBike = new Bike();
		myBike.start(); // Calls the overridden start method in Bike
	}
}

class Student {
	public void display(String name, int rollNo) {
		System.out.println("Name: " + name + ", Roll No: " + rollNo);
	}

	public void display(int rollNo, String name) {
		System.out.println("Roll No: " + rollNo + ", Name: " + name);
	}
}

class Vehicles {
	void start() {
		System.out.println("The vehicle starts");
	}
}

class Cars extends Vehicles{
	@Override
	void start() {
		System.out.println("The car starts with a key ignition");
	}
}

class Bike extends Vehicles {
	@Override
	void start() {
		System.out.println("The bike starts with a kick");
	}
}
