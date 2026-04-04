package basics;

public class ExceptionsHandling {

	public static void main(String[] args) {
		try {
			System.out.println("Try");
			int a = 5/0;
			System.out.println(a);
		}
		catch(ArithmeticException e) {
			System.out.println("catch");
			return ;
		}finally {
			System.out.println("Finally block :");
		}
		
	}
}
