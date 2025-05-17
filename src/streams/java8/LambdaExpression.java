package streams.java8;

@FunctionalInterface
interface Payment{
	void paymentStatus();
}
public class LambdaExpression {
	public static void main(String[] args) {
		Payment p = () -> {
			System.out.println("Payment is in progress");
		};
		p.paymentStatus();
	}

}
