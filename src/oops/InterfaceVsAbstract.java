package oops;

/**
 * Strong Example Demonstrating Interface vs Abstract Class
 * 
 * This example shows: 1. Interface - PaymentMethod (defines WHAT can be done)
 * 2. Abstract Class - Vehicle (defines WHAT it is + shared code)
 */

// ============================================
// INTERFACE EXAMPLE: Payment Method
// ============================================
// Interface defines a CONTRACT - "What can you do?"
interface PaymentMethod {
	// Abstract methods - must be implemented
	boolean processPayment(double amount);

	String getPaymentDetails();

	// Default method (Java 8+) - provides default implementation
	default boolean validateAmount(double amount) {
		return amount > 0 && amount <= 10000;
	}

	// Static method (Java 8+)
	static void showPaymentInfo() {
		System.out.println("=== Payment Processing System ===");
	}
}

// Multiple classes implement the same interface differently
class CreditCard implements PaymentMethod {
	private String cardNumber;
	private String cardHolder;

	public CreditCard(String cardNumber, String cardHolder) {
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
	}

	@Override
	public boolean processPayment(double amount) {
		if (!validateAmount(amount)) {
			System.out.println("Invalid amount!");
			return false;
		}
		System.out.println("Processing credit card payment of $" + amount);
		System.out.println("Card: " + maskCardNumber(cardNumber));
		System.out.println("Cardholder: " + cardHolder);
		return true;
	}

	@Override
	public String getPaymentDetails() {
		return "Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4);
	}

	private String maskCardNumber(String card) {
		return "****-****-****-" + card.substring(card.length() - 4);
	}
}

class PayPal implements PaymentMethod {
	private String email;

	public PayPal(String email) {
		this.email = email;
	}

	@Override
	public boolean processPayment(double amount) {
		if (!validateAmount(amount)) {
			System.out.println("Invalid amount!");
			return false;
		}
		System.out.println("Processing PayPal payment of $" + amount);
		System.out.println("Email: " + email);
		return true;
	}

	@Override
	public String getPaymentDetails() {
		return "PayPal: " + email;
	}
}

// ============================================
// ABSTRACT CLASS EXAMPLE: Vehicle
// ============================================
// Abstract class defines IDENTITY + shared code
abstract class Vehicle {
	// Instance variables - interfaces can't have these
	protected String brand;
	protected String model;
	protected int year;
	protected double fuelLevel;

	// Constructor - interfaces can't have this
	public Vehicle(String brand, String model, int year) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.fuelLevel = 100.0;
	}

	// Concrete methods - shared implementation
	public void start() {
		System.out.println(brand + " " + model + " is starting...");
	}

	public void stop() {
		System.out.println(brand + " " + model + " has stopped.");
	}

	public void refuel(double amount) {
		fuelLevel = Math.min(100.0, fuelLevel + amount);
		System.out.println("Refueled. Fuel level: " + fuelLevel + "%");
	}

	// Abstract methods - must be implemented by subclasses
	public abstract void accelerate();

	public abstract void brake();

	public abstract double calculateFuelEfficiency();

	// Template method - uses abstract methods
	public void drive() {
		start();
		accelerate();
		System.out.println("Fuel efficiency: " + calculateFuelEfficiency() + " km/L");
		brake();
		stop();
	}

	// Getters
	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public double getFuelLevel() {
		return fuelLevel;
	}
}

// Concrete class extends abstract class
class Car extends Vehicle {
	private int numberOfDoors;

	public Car(String brand, String model, int year, int numberOfDoors) {
		super(brand, model, year);
		this.numberOfDoors = numberOfDoors;
	}

	@Override
	public void accelerate() {
		System.out.println("Car is accelerating using engine power");
		fuelLevel -= 2.0;
	}

	@Override
	public void brake() {
		System.out.println("Car is braking using disc brakes");
	}

	@Override
	public double calculateFuelEfficiency() {
		return 12.5;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}
}

class Motorcycle extends Vehicle {
	public Motorcycle(String brand, String model, int year) {
		super(brand, model, year);
	}

	@Override
	public void accelerate() {
		System.out.println("Motorcycle is accelerating");
		fuelLevel -= 1.0;
	}

	@Override
	public void brake() {
		System.out.println("Motorcycle is braking");
	}

	@Override
	public double calculateFuelEfficiency() {
		return 25.0; // Better efficiency
	}
}

// ============================================
// MAIN CLASS: Demonstrating Both Concepts
// ============================================
public class InterfaceVsAbstract {

	public static void demonstrateInterface() {
		System.out.println("\n=== INTERFACE DEMONSTRATION ===");
		System.out.println("Interface: Defines WHAT can be done (Contract)\n");

		PaymentMethod.showPaymentInfo();

		// Polymorphism - same interface, different implementations
		PaymentMethod payment1 = new CreditCard("1234567890123456", "John Doe");
		PaymentMethod payment2 = new PayPal("john.doe@email.com");

		System.out.println("\n--- Credit Card Payment ---");
		payment1.processPayment(150.50);
		System.out.println("Details: " + payment1.getPaymentDetails());

		System.out.println("\n--- PayPal Payment ---");
		payment2.processPayment(75.25);
		System.out.println("Details: " + payment2.getPaymentDetails());

		System.out.println("\n✅ Key Points:");
		System.out.println("- Interface defines contract (what methods must exist)");
		System.out.println("- Multiple classes can implement same interface");
		System.out.println("- Each class provides different implementation");
		System.out.println("- No code sharing between implementations");
	}

	public static void demonstrateAbstractClass() {
		System.out.println("\n=== ABSTRACT CLASS DEMONSTRATION ===");
		System.out.println("Abstract Class: Defines WHAT it is + shared code\n");

		// Polymorphism - same abstract class, different implementations
		Vehicle vehicle1 = new Car("Toyota", "Camry", 2023, 4);
		Vehicle vehicle2 = new Motorcycle("Honda", "CBR600", 2023);

		System.out.println("--- Car ---");
		System.out.println("Brand: " + vehicle1.getBrand());
		System.out.println("Model: " + vehicle1.getModel());
		System.out.println("Year: " + vehicle1.getYear());
		vehicle1.drive(); // Uses template method

		System.out.println("\n--- Motorcycle ---");
		System.out.println("Brand: " + vehicle2.getBrand());
		System.out.println("Model: " + vehicle2.getModel());
		System.out.println("Year: " + vehicle2.getYear());
		vehicle2.drive(); // Uses template method

		System.out.println("\n✅ Key Points:");
		System.out.println("- Abstract class defines identity (what it is)");
		System.out.println("- Can have instance variables and constructors");
		System.out.println("- Shares common code (start(), stop(), refuel())");
		System.out.println("- Subclasses implement abstract methods");
		System.out.println("- Template method pattern (drive() uses abstract methods)");
	}

	public static void demonstrateBothTogether() {
		System.out.println("\n=== USING BOTH TOGETHER ===");
		System.out.println("A class can extend abstract class AND implement interface\n");

		// Vehicle is abstract class, but we can also add interfaces
		// Let's create a vehicle that can also be paid for

		System.out.println("Example: Electric Car with Payment");
		Car tesla = new Car("Tesla", "Model 3", 2023, 4);
		tesla.drive();

		// Can also use payment interface
		PaymentMethod payment = new CreditCard("9876543210987654", "Tesla Owner");
		payment.processPayment(50000.0); // Buying the car

		System.out.println("\n✅ Key Points:");
		System.out.println("- Class can extend ONE abstract class");
		System.out.println("- Class can implement MULTIPLE interfaces");
		System.out.println("- This gives you both identity (abstract class) and capabilities (interfaces)");
	}

	public static void main(String[] args) {
		System.out.println("========================================");
		System.out.println("Interface vs Abstract Class Comparison");
		System.out.println("========================================");

		demonstrateInterface();
		demonstrateAbstractClass();
		demonstrateBothTogether();

		System.out.println("\n========================================");
		System.out.println("Summary:");
		System.out.println("========================================");
		System.out.println("INTERFACE:");
		System.out.println("  - Defines: WHAT can be done (contract)");
		System.out.println("  - Use when: Multiple unrelated classes need same capability");
		System.out.println("  - Example: PaymentMethod, Flyable, Swimmable");
		System.out.println();
		System.out.println("ABSTRACT CLASS:");
		System.out.println("  - Defines: WHAT it is + shared code");
		System.out.println("  - Use when: Related classes share common code");
		System.out.println("  - Example: Vehicle, Animal, Employee");
		System.out.println();
		System.out.println("========================================");
	}
}
