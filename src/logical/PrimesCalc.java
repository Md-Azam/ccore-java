package logical;

import java.util.ArrayList;
import java.util.List;

public class PrimesCalc {

	public static void main(String[] args) {
		List<Integer> l1 = countListOfPrimes(2, 11);
		System.out.println("List Of Primes: " + l1);

	}
	//Calculating List Of Primes For Given Ranges.
	public static List<Integer> countListOfPrimes(int a, int b) {
		List<Integer> l = new ArrayList<>();
		for (int i = a; i <= b; i++) {
			String s = primeCheck(i);
			if (s.equalsIgnoreCase("Prime")) {
				l.add(i);
			}

		}
		return l;

	}
	//Calculating Given Number Is Prime Number Or Not.
	public static String primeCheck(int p) {
		int count = 0;
		for (int i = 1; i <= p; i++) {
			if (p % i == 0) {
				count++;

			}
		}
		if (count == 2) {
			return "Prime";

		} else {
			return "NotPrime";
		}
	}

}
