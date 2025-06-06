package patterns;

public class DiamondPattern {
	public static void main(String[] args) {

		int n = 6;
		// Right Angle Triangle
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		// Inverted Right Angle Triangle
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		// Upper Half Diamond Pattern
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= n - i; j++)
				System.out.print(" ");
			for (int j = 1; j <= 2 * i - 1; j++)
				System.out.print("*");
			System.out.print("\n");
		}

		// Lower Half Diamond Pattern
		for (int i = n - 1; i >= 1; i--) {
			for (int j = 1; j <= n - i; j++)
				System.out.print(" ");
			for (int k = 1; k <= 2 * i - 1; k++)
				System.out.print("*");
			System.out.print("\n");
		}

	}

}
