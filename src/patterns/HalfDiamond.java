package patterns;

public class HalfDiamond {

	// Upper Half Diamond Pattern
	public static void upperHalfDiamond(int n) {
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= n - i; j++)
				System.out.print(" ");
			for (int j = 1; j <= 2 * i - 1; j++)
				System.out.print("*");
			System.out.print("\n");
		}
		System.out.println("End of upperHalfDiamond");

	}

	// Lower Half Diamond Pattern
	public static void lowerHalfDiamond(int n) {
		for (int i = n - 1; i >= 1; i--) {
			for (int j = 1; j <= n - i; j++)
				System.out.print(" ");
			for (int k = 1; k <= 2 * i - 1; k++)
				System.out.print("*");
			System.out.print("\n");
		}
		System.out.println("End of lowerHalfDiamond");
	}

	// Left Half Diamond Pattern
	public static void lowerHalfDigitDiamond(int n) {
		for(int i=n-1; i >= 1; i--) {
	         // in each iteration a will start from 1
	         int a = 1; 
	         // print space
	         for(int j=n; j >= i; j--) {
	            System.out.print(" ");
	         }
	         // print digit
	         for(int k=1; k <= 2*i-1; k++) {
	            System.out.print(a++);
	         }
	         // new line
	         System.out.println();      
		}
		System.out.println("End of lowerHalfDigitDiamond");
	}
	
	//4. Left half diamond pattern:
	public static void leftHalfDiamondPattern(int n) {
		int star = 0;
		//for(int i=1; i < n; i++) -> for right angle triangle:
	      for(int i=1; i < 2*n; i++) {
	         if(i < n) star = i;
	         else star = Math.abs(2*n - i);
	         // print star 
	         for(int j = 1; j <= star; j++) {
	            System.out.print("*");
	         }
	         // new line
	         System.out.println();
	      }
	     System.out.println("End of leftHalfDiamondPattern");
	}
	
	// Left Half Diamond Pattern
		public static void lowerHalfAlphaDiamond(int n) {
			for(int i=n-1; i >= 1; i--) {
		         // in each iteration a will start from 1
		         char  a = 'A'; 
		         // print space
		         for(int j=n; j >= i; j--) {
		            System.out.print(" ");
		         }
		         // print digit/character
		         for(int k=1; k <= 2*i-1; k++) {
		            System.out.print((char)(a++));
		         }
		         // new line
		         System.out.println();      
			}
			System.out.println("End of lowerHalfAlphaDiamond");
		}


	public static void main(String[] args) {
		lowerHalfDiamond(6);
		upperHalfDiamond(6);
		lowerHalfDigitDiamond(6);
		leftHalfDiamondPattern(7);
		lowerHalfAlphaDiamond(6);
		
	}

}
