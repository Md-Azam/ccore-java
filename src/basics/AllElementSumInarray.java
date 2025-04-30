package basics;

public class AllElementSumInarray {
	public static void main(String args[]) {
		int[] list = {2,3,4,5,6,7,8};
		int sum =0 ;
		int s2 =0;
		for(int i=0;i<list.length;i++) {
			sum = sum +list[i];
		}
		System.out.println(sum);
		
		for(int num : list) {
			s2 = s2+num;
		}
		System.out.println(s2);
	}
	

}
