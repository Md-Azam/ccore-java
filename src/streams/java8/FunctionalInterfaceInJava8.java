package streams.java8;

/*
 * Functional Interface: A interface having only one Abstract method but may have multiple default or static method.
 * Allows to use lambda Expression to make code concise and readable and use anonymous function.
 * JDK 7 - Functional Interface ->Comparator, Comparable, Runnable, Callable
 * JDK 8 - Functional Interface -> Function, Predicate, Consumer, Supplier,
 */

@FunctionalInterface
interface Test {
	
	void show();
	
	default void myDefaultMethod(int n) {
		System.out.println(n*n);
		System.out.println("*************");
		
}
	public static String myStaticMethod(String s) {
		System.out.println("Azam Static method");
		return "azam";
	}
	public int hashCode();
	
	public String toString();
}

public class FunctionalInterfaceInJava8 {
	public static void main(String[] args) {
		
		//Calling Functional Interface
		Test t = () -> System.out.println("azam ");
		t.show();
		
		//Calling default method.
		t.myDefaultMethod(3);
		
		//Calling static method
		Test.myStaticMethod("azam");
	}

	
		
	

}
