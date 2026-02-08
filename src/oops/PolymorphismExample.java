package oops;

class Student {
	public void display(String name, int rollNo) {
		System.out.println("Name: " + name + ", Roll No: " + rollNo);
	}

	public void display(int rollNo, String name) {
		System.out.println("Roll No: " + rollNo + ", Name: " + name);
	}
}

public class MethodOverloadExample {
	public static void main(String[] args) {
		Student student = new Student();
		student.display("Alice", 1); // Output: Name: Alice, Roll No: 1
		student.display(2, "Bob"); // Output: Roll No: 2, Name: Bob
	}
}
