package logical;

public class LcmAndHcf {

	public static void main(String[] args) {

		lcmCacl(12, 18);

		System.out.print("Calling gcdCalc Method, So ");
		int gcd = gcdCalcRecursion(12, 18);
		int lcm2 = 12 * 18 / gcd;
		System.out.println("Value of  lcm2 is: " + lcm2);

	}

	//Calculatin LCM using normal function
	public static int lcmCacl(int n1, int n2) {
		// define and declare two numbers
		int on1 = n1;
		int on2 = n2;

		// check if n1%n2 !=0
		// assign remainder to a new variable
		// assign n1 to n2
		// assign n2 = remainder
		// you will get GCD value
		while (n1 % n2 != 0) {
			int rem = n1 % n2;
			n1 = n2;
			n2 = rem;

			System.out.println("Rem = " + rem + " n1 =" + n1 + " n2 = " + n2);
		}

		// n1 * n2 / GCD = LCM
		int gcd = n2;
		int lcm = (on1 * on2) / gcd;
		System.out.println("on1 =  " + on1);
		System.out.println("on2 = " + on2);
		System.out.println("LCM of n1 and n2 is: " + lcm);
		return lcm;

	}

	// GCD Calculation using recursion
	public static int gcdCalcRecursion(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcdCalcRecursion(b, a % b);
		}
	}
}
