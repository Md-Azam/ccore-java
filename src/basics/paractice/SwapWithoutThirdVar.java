package basics.paractice;

public class SwapWithoutThirdVar {
	public static void main(String[] args) {
		
		int a =10;
		int b =5;
		a = a ^ b;  // a = 5 ^ 10 = 15
		b = a ^ b;  // b = 15 ^ 10 = 5
		a = a ^ b;  // a = 15 ^ 5  = 10
		System.out.println(a);
		System.out.println(b);
		
		
	}

}
