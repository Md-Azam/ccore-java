package logical;

public class SquarePatterns {

	public static void main(String[] args) {
		int k = 6;
		HallowSquare(k);
		HallowAlphaBeticalPattern(k);
	}

	// Print Hollow Square pattern:
	public static void HallowSquare(int n) {

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				// Print * for border cells
				if (i == 1 || i == n || j == 1 || j == n) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(); // Move to next line
		}
		System.out.println("Ending -----------");
	}
	
	// Print HallowAlphaBeticalPattern Square pattern:
		public static void HallowAlphaBeticalPattern(int n) {

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					// Print * for border cells
					if (i == 1 || i == n || j == 1 || j == n) {
						System.out.print((char)(64 +i));
					} else {
						System.out.print(" ");
					}
				}
				System.out.println(); // Move to next line
			}
		}

}
