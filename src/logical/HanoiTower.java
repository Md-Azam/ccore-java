package logical;

public class HanoiTower {
	/*
	 * move n-1 from source to helper by the help of destination.
	 * move nth from source to destination.
	 * repeat to move n-1 from helper to destination with the help of source.
	 */
	public static void TOH(int n,char source, char helper,char destination) {
		//Base condition
		if(n==1) {
			System.out.println("Moving Disk: "+ n + " from "+ source + " to "+ destination);
			return;
		}
		//move n-1 from source to helper by the help of destination.
		TOH(n-1,source,destination,helper);
		System.out.println("Moving Disk: "+ n + " from "+ source + " to "+ destination);
		
		//move nth from source to destination.
		TOH(n-1,helper,source,destination);
		System.out.println("Moving Disk: "+ n + " from "+ source + " to "+ destination);
		
	}
	public static void main(String[] args) {
		
		int n = 4;
		TOH(n,'A','B','C');
		
	}

}
