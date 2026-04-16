package patterns;

public class LadderPattern {
	public static void main(String[] args) {
		
		int n =5;
		int i,j,k =1;
		for(i=1; i<=n;i++) {
			
			for(j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			System.out.print("/");
			for(k=1;k<=(2*i-1);k++) {
				System.out.print("*");
			}
			System.out.print("\\");
		System.out.println();
		}
	}

}
