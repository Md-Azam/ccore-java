package basics.paractice;

public class FindTargetSum {
	
public static void main(String[] args) {
	
	int[] a = {2,3,33,6,55,23};
	boolean b = false;
	for (int i=0;i<a.length;i++) {
		for (int j=0;j<a.length-1;j++) {
			if(a[i]+a[j] == 35) {
				System.out.println("sum target meets");
				b = true;
			}
			
		}
		if(b) {
			break;
		}
		else {
			System.out.println("Target not found");
		}
	}
}
}
