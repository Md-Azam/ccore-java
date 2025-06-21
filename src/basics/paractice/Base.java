package basics.paractice;

class Parent {
	public static void display() {
		System.out.println("Parent Azam");
	}

}

class Derived extends Parent {
	public static void display() {
		System.out.println("Inherit class");
	}
}

public class Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Derived();
		p.display();

	}

}
