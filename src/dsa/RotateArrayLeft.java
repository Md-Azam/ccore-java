package dsa;

import java.util.Scanner;

public class RotateArrayLeft {
	public static void main(String[] args) {
		
		int[] a =  {1,3,6,8,12,34,44};
		System.out.println(a);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of rotation");
		int n = sc.nextInt();
		for (int i=0;i<n;i++) {
			int first = a[0];
			for (int j =0;j<a.length-1;j++) {
				a[j] = a[j+1];
			}
			a[a.length-1] = first;
			
		}
		System.out.println();
		System.out.println("Output array");
		for (int i=0;i<a.length;i++) {
			System.out.print(a[i]+ " ");
		}
	}

}
