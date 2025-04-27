package basics;

public class PalindromeNum {
	public static void main(String[] args) {
		boolean b = isPalindrome(341);
		boolean b1 = isPalindrome(141);
		boolean b2 = isPalindrome(-111);
		System.out.println("b "+b);
		System.out.println("b1 "+b1);
		System.out.println("b2 "+b2);
	}

	
	public static boolean isPalindrome(int x) {
		if(x<0) {
			return false;
		}
		int n =x;
		int revNum = 0;
		
		while(n>0) {
			int d = n%10;
			System.out.println("value of n%10 is "+ d);
			revNum = revNum*10 + d;
			System.out.println("revNum "+ revNum);
			System.out.println("value of n/10 is "+ n/10);
			n = n/10;
		}
		if(revNum == x) {
			return true;
		}
		else {
			return false;
		}
	}
}
