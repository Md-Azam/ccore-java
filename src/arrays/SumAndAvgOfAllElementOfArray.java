package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class SumAndAvgOfAllElementOfArray {
	public static void main(String[] args) {
		
	 int[] arr = {1,2,3,44,55,66,77,33,11};
	int sumOfAll = Arrays.stream(arr).sum();
	System.out.println("sumOfAll: " + sumOfAll);
	OptionalDouble avgOfAllElement = 	Arrays.stream(arr).average();
	System.out.println("avgOfAllElement: "+ avgOfAllElement);
	}

}
