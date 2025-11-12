package arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumAndAvgOfAllElementOfArray {
	public static void main(String[] args) {
		
	 int[] arr = {1,2,3,44,55,66,77,33,11};
	int sumOfAll = Arrays.stream(arr).sum();
	System.out.println("sumOfAll: " + sumOfAll);
	OptionalDouble avgOfAllElement = 	Arrays.stream(arr).average();
	System.out.println("avgOfAllElement: "+ avgOfAllElement);
	int sumofArr = 0;
	for (int i=0; i <arr.length;i++) {
		sumofArr += arr[i];
	}
	System.out.println("sumofArr: "+ sumofArr);
	float manualAvg = sumofArr/arr.length;
	System.out.println(manualAvg);
	
	List<String> ls = Arrays.asList("apple","grapes","anar","apple","litchi","manago","litchi","apple");
	Map<String, Long> maplong = ls.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println(maplong);
	
}
}
